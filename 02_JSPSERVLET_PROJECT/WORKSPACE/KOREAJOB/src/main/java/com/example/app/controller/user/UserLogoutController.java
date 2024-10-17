package com.example.app.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.app.controller.SubController;
import com.example.app.domain.common.dao.connectionPool.ConnectionPool;
import com.example.app.domain.common.dto.SessionDto;
import com.example.app.domain.common.service.UserServiceImpl;

public class UserLogoutController implements SubController {
	
	private UserServiceImpl userServiceImpl;
	private ConnectionPool connectionPool;
	
	public UserLogoutController() {
		System.out.println("UserLogoutController Constructor invoke");

		try {
			userServiceImpl = UserServiceImpl.getInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("UserLogoutController..execute");
			Map<String,Object> result=new HashMap();
		try {

			//01 파라미터 다 받아오기
			HttpSession session = request.getSession();
			SessionDto sessionDto = (SessionDto)session.getAttribute("sessionDto");	
			
			//02
			if(sessionDto==null) {
				session.setAttribute("msg", "로그인상태가아닙니다.");
				request.getRequestDispatcher("/WEB-INF/view/user/login.jsp").forward(request, response);
				return ;
			}
	
			//03
			//유저 서비스로 logout 함수 실행
			Map<String,Object> logoutValue=null;
			logoutValue=userServiceImpl.logout(session,sessionDto, response);
			
			//04
			boolean logout=(boolean) logoutValue.get("response");
			System.out.println("RESPONSE : " + logout);
			if(logout) {//로그아웃이 성공을한다면?
				response.sendRedirect(request.getContextPath()+"/user/login");
			}else {
				//로그아웃 실패이면?
				request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	private boolean isValid(SessionDto sessionDto) {
		// TODO Auto-generated method stub
		return true;
	}

}
