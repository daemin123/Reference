package com.example.app.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.app.controller.SubController;
import com.example.app.domain.common.dto.SessionDto;
import com.example.app.domain.common.service.UserService;
import com.example.app.domain.common.service.UserServiceImpl;
import com.example.app.type.ROLE;

public class UserInfoController implements SubController {

	UserService userService;
	
	public UserInfoController(){
		try {
			userService = UserServiceImpl.getInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		//ROLE_SEEKER
		//ROLE_OFFER
		//ROLE_MANAGER
		
		try {
			HttpSession session = request.getSession();
			
			SessionDto sessionDto = (SessionDto)session.getAttribute("sessionDto");
			
			if(sessionDto!=null) {
				
				ROLE role =  sessionDto.getRole();
				
				if(role.ordinal()==0) {
					//ROLE_USER
					
				}else if(role.ordinal()==1) {
					//ROLE_SEEKER
					request.getRequestDispatcher("/WEB-INF/view/seeker/myinfo.jsp").forward(request, response);
				}else if(role.ordinal()==2){
					//ROLE_OFFER
					request.getRequestDispatcher("/WEB-INF/view/offer/myinfo.jsp").forward(request, response);
				}else {
					
					//ROLE_ADMIN
					
				}
					
			}		
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

		
		

	}

}

