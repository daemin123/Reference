package com.example.app.controller.user.offer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.SubController;
import com.example.app.domain.offer.service.OfferServiceImpl;

public class OfferRemoveController implements SubController {

	private OfferServiceImpl offerServiceImpl;
	
	public OfferRemoveController() {
	       System.out.println("OfferRemoveController Constructor invoke");

	        try {
	            offerServiceImpl = OfferServiceImpl.getInstance();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void execute(HttpServletRequest request, HttpServletResponse response) {
	        try {
	            if (request.getMethod().equals("GET")) {
	                request.getRequestDispatcher("/WEB-INF/view/offer/remove.jsp").forward(request, response);
	                return;
	            }
	            String offerId = request.getParameter("offerId");
	            boolean success = false;
	            //boolean success = offerServiceImpl.remove(offerId);
	            if (success) {
	                response.sendRedirect(request.getContextPath() + "/main");
	            } else {
	                request.setAttribute("errorMessage", "회원 탈퇴에 실패하였습니다.");
	                request.getRequestDispatcher("/WEB-INF/view/offer/remove.jsp").forward(request, response);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	}