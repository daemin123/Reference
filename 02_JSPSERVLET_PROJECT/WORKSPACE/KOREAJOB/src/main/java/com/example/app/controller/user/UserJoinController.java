package com.example.app.controller.user;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.SubController;
import com.example.app.domain.common.dto.UserDto;
import com.example.app.domain.common.service.UserServiceImpl;
import com.example.app.type.ROLE;

public class UserJoinController implements SubController {

	private UserServiceImpl userServiceImpl;
	
	public UserJoinController() {
		System.out.println("UserJoinController Constructor invoke");

		try {
			userServiceImpl = UserServiceImpl.getInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("userJoinController..excute");
		try {
			//GET MAPPING 
			String method = request.getMethod();
			if(method.contains("GET")) {
				request.getRequestDispatcher("/WEB-INF/view/user/join.jsp").forward(request, response);
				return ;
			}
				}catch(Exception e) {
						e.printStackTrace();
				}
			//01 파라미터 받기
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String id=request.getParameter("id");
	

			//02 유효성 체크
			if(!isValid(username,password)) {
				return;
			}
			//03
			Map<String, Object> isJoined=null;
			UserDto userDto=new UserDto();
			userDto.setUsername(username);
			userDto.setId(id);
			userDto.setIslocked(false);
			userDto.setRole(ROLE.ROLE_USER);
			userDto.setPassword(password);
			
			//UserServiceimpl에있는 회원가입으로 전달.
			try {
				isJoined=userServiceImpl.join(userDto);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			//04 뷰로 전달
			if(isJoined!=null) { //만약회원가입에 성공을 했따면 로그인 페이지로 넘긴다
				try {
					response.sendRedirect(request.getContextPath()+"/user/login");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else { //회원가입에 실패했다면 다시 회원가입 페이지로 넘긴다.
				try {
					request.getRequestDispatcher("WEB-INF/view/user/join.jsp").forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			

	}
	private boolean isValid(String username, String password) {
		// TODO Auto-generated method stub
		return true;
	}

}
