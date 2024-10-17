package com.example.app.controller.user;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.app.controller.SubController;
import com.example.app.domain.common.dao.connectionPool.ConnectionPool;
import com.example.app.domain.common.service.UserServiceImpl;

public class UserLoginController implements SubController {

	private UserServiceImpl userServiceImpl;
	private ConnectionPool connectionpool;
	
	public UserLoginController() {

		try {
			userServiceImpl = UserServiceImpl.getInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("UserLoginController's Constructor invoke! userServiceImpl : " + userServiceImpl);
	}
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			//GET MAPPING 
			String method = request.getMethod();
			if(method.contains("GET")) {
				request.getRequestDispatcher("/WEB-INF/view/user/login.jsp").forward(request, response);
				return ;
			}
				}catch(Exception e) {
			e.printStackTrace();
			}
			
			//01
			String id=request.getParameter("id");
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			//02
			if(!isValid(username,password,id)) {
				return ;
			}
			//03
			Map<String,Object> LoginValue=null;
			HttpSession session=request.getSession();
			System.out.println("CONTROLLER : " + id);
			try {
				LoginValue=userServiceImpl.login(id, password, session, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//04
			//userServiceimpl에 있는 각 response 들을 꺼내온다
			boolean isLogined=(boolean)LoginValue.get("response");
			String msg=(String) LoginValue.get("msg");
			session.setAttribute("msg", msg);
			
			if(isLogined) {//로그인에 성공을 했다면?
				try {
					response.sendRedirect(request.getContextPath()+"/");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				try {
					request.getRequestDispatcher("/WEB-INF/view/user/login.jsp").forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			

	}
	private boolean isValid(String username, String password,String id) {
		// TODO Auto-generated method stub
		return true;
	}

}
