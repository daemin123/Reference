package com.example.app.controller.user.seeker;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.app.controller.SubController;
import com.example.app.domain.seeker.dto.SeekerDto;
import com.example.app.domain.seeker.service.SeekerServiceImpl;
import com.example.app.type.ROLE;

public class SeekerJoinController implements SubController {

	private SeekerServiceImpl seekerServiceImpl;
	
	public SeekerJoinController() {
		System.out.println("SeekerRemoveController Constructor invoke");

		try {
			seekerServiceImpl = SeekerServiceImpl.getInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		try {
			//GET MAPPING 
			String method = request.getMethod();
			if(method.contains("GET")) {
				request.getRequestDispatcher("/WEB-INF/view/seeker/join.jsp").forward(request, response);
				return ;
			}
			
			//01 파라미터받기 
			String id = request.getParameter("id");
		    String username = request.getParameter("username");
		    String password = request.getParameter("password");
		    String tel = request.getParameter("tel");
		    String addr = request.getParameter("address");
			
		    //02 유효성검사
		    if(!isValid(id,username,password,tel,addr)) {		
				return ;
			} else {
			}
			
			//03 - 
		    SeekerDto scckerDto = new SeekerDto();
		    scckerDto.setId(id);
		    scckerDto.setUsername(username);
		    scckerDto.setPassword(password);
		    scckerDto.setRole(ROLE.ROLE_SEEKER);
		    scckerDto.setTel(tel);
		    scckerDto.setAddress(addr);
		    Map<String, Object> isAdded = seekerServiceImpl.join(scckerDto);
		    Boolean responseMsg = (Boolean)isAdded.get("response");
			String msg = (String)isAdded.get("msg");
			HttpSession session = request.getSession();
		    //04
		    if(isAdded != null) {
				session.setAttribute("msg",msg);
				response.sendRedirect(request.getContextPath()+ "/");
				return ;
				
			}else {
				session.setAttribute("msg",msg);
				request.getRequestDispatcher("/WEB-INF/view/user/join.jsp").forward(request, response);
				return ;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		

	}

	private boolean isValid(String id, String username, String password, String tel, String addr) {
		// 널 값인지 확인
		
//		if(id==null || id.isEmpty() || username == null || username == "" || password == null || password == ""
//				|| tel == null || tel == "" || addr == null || addr == ""	
//				) {
//			return false;
//		}
		
		
		return true;
	}

}
