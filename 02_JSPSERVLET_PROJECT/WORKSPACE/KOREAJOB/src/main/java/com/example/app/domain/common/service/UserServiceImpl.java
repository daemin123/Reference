package com.example.app.domain.common.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.app.domain.common.dao.SessionDao;
import com.example.app.domain.common.dao.SessionDaoImpl;
import com.example.app.domain.common.dao.UserDaoImpl;
import com.example.app.domain.common.dao.connectionPool.ConnectionPool;
import com.example.app.domain.common.dto.SessionDto;
import com.example.app.domain.common.dto.UserDto;
import com.example.app.type.ROLE;

public class UserServiceImpl implements UserService{
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private UserDaoImpl userDaoImpl;
	private ConnectionPool connectionPool;
	private SessionDao sessionDao;
	//싱글톤
	private static UserServiceImpl instance ;
	public static UserServiceImpl getInstance() throws Exception {
		if(instance==null)
			instance=new UserServiceImpl();
		return instance;
	}
	
	private UserServiceImpl() throws Exception{
		System.out.println("UserServiceImpl's constructor invoke ..");
		connectionPool = ConnectionPool.getInstance();
		
		//암호화
		bCryptPasswordEncoder = new BCryptPasswordEncoder();
		//User
		userDaoImpl = UserDaoImpl.getInstance();
		//session
		sessionDao =SessionDaoImpl.getInstance();
		
		//접속중인 sessionid를 session테이블에서 list로 저장
		List<SessionDto> tmpList =sessionDao.SelectAll();
		for(SessionDto dto : tmpList) {
				//SessionIdList.add(dto.getSessionId());
		}
	}
	
	//Join(회원가입)
	public Map<String,Object> join(UserDto newUser) throws Exception {
	    Map<String,Object> returnValue = new HashMap<>();
	    connectionPool.txStart();
	    
	    // 유저가 이미 존재하는지 확인
	    UserDto existingUser = getUser(newUser.getId());
	    if (existingUser != null) {
	        returnValue.put("response", false);
	        returnValue.put("msg", "이미 등록된 아이디입니다.");
	        return returnValue;
	    }
	    
	    // 비밀번호 암호화
	    String encodedPassword = bCryptPasswordEncoder.encode(newUser.getPassword());
	    newUser.setPassword(encodedPassword);
	    
	    // 역할 설정
	    newUser.setRole(ROLE.ROLE_USER);
	    
	    // 유저 등록
	    boolean isRegistered = userDaoImpl.Insert(newUser);
	    if (!isRegistered) {
	        returnValue.put("response", false);
	        returnValue.put("msg", "회원가입에 실패했습니다.");
	        return returnValue;
	    }
	    
	    returnValue.put("response", true);
	    returnValue.put("msg", "회원가입이 성공적으로 완료되었습니다.");
	    

		
		
	    connectionPool.txCommit();
	    return returnValue;
	}


	
	//login
	public Map<String,Object> login(String id,String password,HttpSession session,HttpServletResponse response) throws Exception{
		Map<String,Object> returnValue =new HashMap();
		connectionPool.txStart();
		
		//1.sessionList에 동일한 정보가 있는가?
		SessionDto loginSession=(SessionDto)session.getAttribute("sessionDto");
		if(loginSession!=null) {
			returnValue.put("response", false);
			returnValue.put("msg", "해당 계정은 이미 로그인 되어있습니다.");
			System.out.println("login func error : " + "해당 계정은 이미 로그인 되어있습니다.");
			return returnValue;
		}
		
		//2.로그인이 되어있지 않다면 user테이블에서 동일한 이름의 user정보를 가져온다.
		UserDto savedUser=getUser(id);
		if(savedUser==null) {
			returnValue.put("response", false);
			returnValue.put("msg", "해당 계정이 존재하지 않습니다.");
			System.out.println("login func error : " + "해당 계정이 존재하지 않습니다.");
			return returnValue;
		}
		
		//3pw일치여부확인
		if(!bCryptPasswordEncoder.matches(password,savedUser.getPassword())) {
			returnValue.put("response", false);
			returnValue.put("msg", "Password가 일치하지 않습니다.");
			System.out.println("login func error : " + "Password가 일치하지 않습니다.");

			return returnValue;
		}
		//4pw 일치한다면 로그인 거의 성공 session에 저장한다
		SessionDto sessionDto = new SessionDto();
		String randUUID =  UUID.randomUUID().toString();
		sessionDto.setSessionId(randUUID);
		sessionDto.setUsername(id);
		sessionDto.setRole(savedUser.getRole());
		
		boolean isSessionSaved =  sessionDao.Insert(sessionDto);
		if(!isSessionSaved) {
			returnValue.put("response", false);
			returnValue.put("msg", "로그인 처리중 오류가 발생하였습니다.Session생성 실패..");
			System.out.println("login func error : " + "로그인 처리중 오류가 발생하였습니다.Session생성 실패.");

			return returnValue;
		}
		
		//5 pw일치한다면 sessionList에 sessionId값 저장
		returnValue.put("response", true);
		returnValue.put("msg", "로그인 성공");
		session.setAttribute("sessionDto", sessionDto);
		
		
		//sessionId 쿠키 암호화 해서 전달하기
		String enCryptedSessionId = bCryptPasswordEncoder.encode(randUUID);
		Cookie cookie = new Cookie("sessionId",enCryptedSessionId);
		cookie.setMaxAge(30*30); //3600초 1시간
		cookie.setPath("/");	//모든 path 에 적용
		response.addCookie(cookie);
		
		connectionPool.txCommit();
		return returnValue;
	}
	
	


	//logout
	public Map<String,Object> logout(HttpSession session ,SessionDto sessionDto,HttpServletResponse resp) throws Exception{
		
		Map<String,Object> returnValue =new HashMap();
		connectionPool.txStart();
		
		String sessionId=sessionDto.getSessionId();
		//1.session에서 id를 삭제한다.
		
		boolean isRemoved=sessionDao.Delete(sessionId);
		if(!isRemoved) {
			returnValue.put("response", false);
			returnValue.put("msg", "session에 id가 없는 관계로 로그아웃이 불가합니다.");
		}
		
		//sessionId 쿠키 삭제하기
		Cookie cookie = new Cookie("sessionId",null);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
		
		//세션 제거 
		session.invalidate();
		
		returnValue.put("response", true);
		returnValue.put("msg", "로그아웃 성공");
		
		connectionPool.txCommit();
		return returnValue;
	}
	
	
	//UserDaoImpl에 있는 username을 꺼내온다
	@Override
	public UserDto getUser(String id) throws Exception {
		return userDaoImpl.Select(id);
	}
	
	
}
