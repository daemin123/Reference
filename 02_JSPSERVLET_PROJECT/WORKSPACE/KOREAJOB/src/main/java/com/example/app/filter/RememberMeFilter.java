package com.example.app.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.app.domain.common.dao.SessionDao;
import com.example.app.domain.common.dao.SessionDaoImpl;
import com.example.app.domain.common.dto.SessionDto;

 
public class RememberMeFilter implements Filter {
	private SessionDao sessiondao;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("RememberFilter Excute...!");
		//제일먼저 실행된다 
		try {
			sessiondao=SessionDaoImpl.getInstance();
			bCryptPasswordEncoder = new BCryptPasswordEncoder();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("RememberFilter start~!");
		
		//전달받은 request,response를 각각 저장하는것같다.
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		
		//req에 있는 쿠키들을 가져와 배열형식으로 담는것같다.
		Cookie[] cookies=req.getCookies();
		//쿠키를 null로 초기화 하는것같다 
		Cookie sessionIdCookie=null;
		if(cookies!=null) { //쿠키에 값이 들어가있다면?
			for(Cookie cookie:cookies) {//for문으로 쿠키를 꺼내온다
				if(cookie.getName().equals("sessionId")) {
					//만약 꺼내온 쿠키 이름에 sessionId랑 동일하다면??			
					sessionIdCookie=cookie;
					//초기화 한 쿠키에 값을 넣어준다
				}
			}
		}
		System.out.println("sessionIdCookie값:"+sessionIdCookie);
		if(sessionIdCookie!=null) 
				{ //위에서 쿠키값을 넣엇을때 sessionIdCookie값이 들어가있다면?
			HttpSession session=req.getSession(false); //false로 로그인 실패인것같다
			if(session!=null)
				{ //false가 아니라면? -> session에 쿠키값이 없다는 뜻인건가?
				SessionDto sessiondto=(SessionDto) session.getAttribute("sessionDto"); //sessionDto에 있는 값들을 꺼내오는것같다.
				System.out.println("RememberFilter SessionDto :"+sessiondto);
				if(sessiondto==null)
					{ //sessiondto에 값이없다면 로그인이안된다.
						
						//db에 있는 정보들을 비교해보자
						List<SessionDto> list=null;
							try {
								//selectAll 로 list 에 다담아준다
								list=sessiondao.SelectAll();
								if(list!=null) { //list에 정보가있다면?
									for(SessionDto dto:list) { 
										//반복문으로 list에 잇는 내용들을 다 꺼내와서  rawSessionId->에 넣어준다.
										String rawSessionId=dto.getSessionId();
										if(bCryptPasswordEncoder.matches(rawSessionId, sessionIdCookie.getValue()))
										{ //만약에 암호화된 rawSessionId와, 우ㅟ에서 저장한 sessionCookie값이 동일하다면?
											System.out.println("session 테이블의 sessionid와 sessionIdCookie의 sessionid일치여부확인");
											//일치하다면 session에 값을 넣어준다
											session.setAttribute("sessionDto", dto);
											
											break;
											
										}
										
									}							
								}
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}			
					}
			}
		}
		else
		{
			//sessionIdCookie null이라는 뜻이니깐 로그인이 이미 되어있따는건가? 아니면 로그인을 하지 않은상태인건가?? 잘모르겟음..
		}
		chain.doFilter(request, response);
		
		System.out.println("RememberMeFilter end------");
	}
}
