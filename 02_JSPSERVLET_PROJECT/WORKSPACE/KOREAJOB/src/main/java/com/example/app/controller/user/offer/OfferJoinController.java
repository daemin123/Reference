package com.example.app.controller.user.offer;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.app.controller.SubController;
import com.example.app.domain.offer.dto.OfferDto;
import com.example.app.domain.offer.service.OfferServiceImpl;
import com.example.app.type.ROLE;

public class OfferJoinController implements SubController {

	private OfferServiceImpl offerServiceImpl;
	
	public OfferJoinController() {
		System.out.println("OfferJoinController Constructor invoke");

		try {
			offerServiceImpl = OfferServiceImpl.getInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
			try {
				
		
				//OfferDto의 속성에 맞게 받습니다
				String id=request.getParameter("id");	
				String password=request.getParameter("password");
				String username=request.getParameter("username");
				String offername = request.getParameter("offername");			
				String offertel = request.getParameter("offertel");			
				String offeraddress = request.getParameter("offeraddress");			
				
			
				if(!isValid(id,password)) {
					return ;
				}
				
				Map<String, Object> isJoined = null;
				OfferDto offerDto = new OfferDto();
				offerDto.setId(id);
				offerDto.setPassword(password);
				offerDto.setIslocked(false);
				offerDto.setRole(ROLE.ROLE_OFFER);
				offerDto.setOfferName(offername);
				offerDto.setOfferTel(offertel);
				offerDto.setOfferAddress(offeraddress);
				System.out.println("offerDto : " +offerDto );
				isJoined=offerServiceImpl.join(offerDto);
				
				String msg = (String)isJoined.get("msg");
				Boolean respmsg = (Boolean)isJoined.get("response");
				HttpSession session = request.getSession();
				if(isJoined!=null) { //	
						session.setAttribute("msg", msg);
						session.setAttribute("response", respmsg);
						response.sendRedirect(request.getContextPath()+"/user/login");		
				}
				else {	
						session.setAttribute("msg", msg);
						session.setAttribute("response", respmsg);
						request.getRequestDispatcher("/WEB-INF/view/user/join.jsp").forward(request, response);
				}
			
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}

	private boolean isValid(String id, String password) {
		// TODO Auto-generated method stub
		return true;
	}


}
