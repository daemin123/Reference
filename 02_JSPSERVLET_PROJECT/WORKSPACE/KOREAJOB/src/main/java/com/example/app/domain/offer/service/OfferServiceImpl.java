package com.example.app.domain.offer.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.app.domain.common.dao.UserDaoImpl;
import com.example.app.domain.common.dao.connectionPool.ConnectionPool;
import com.example.app.domain.common.dto.UserDto;
import com.example.app.domain.offer.dao.OfferDaoImpl;
import com.example.app.domain.offer.dto.OfferDto;

public class OfferServiceImpl {

	private OfferDaoImpl offerDaoImpl;
	private UserDaoImpl userDaoImpl;
	private ConnectionPool connectionPool;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	//싱글톤
	private static OfferServiceImpl instance ;
	public static OfferServiceImpl getInstance() throws Exception {
		if(instance==null)
			instance=new OfferServiceImpl();
		return instance;
	}
	
	private OfferServiceImpl() throws Exception{
		System.out.println("OfferServiceImpl's constructor invoke ..");
		offerDaoImpl = OfferDaoImpl.getInstance();
		userDaoImpl = UserDaoImpl.getInstance();
		connectionPool = ConnectionPool.getInstance();
		bCryptPasswordEncoder = new BCryptPasswordEncoder();
	}
	
	
	//회원가입
	public Map<String,Object> join(OfferDto newUser) throws Exception{
		Map<String,Object> returnValue =new HashMap();
		connectionPool.txStart();
		//작업위치
		
		//기존계정명에서 일치하는 계정이 있는지 확인
		UserDto existingUser = getUser(newUser.getId());
		if(existingUser != null) {
	        returnValue.put("response", false);
	        return returnValue;
	  	}
		
		newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
		boolean isRegistered = userDaoImpl.Insert(newUser); 
		isRegistered = offerDaoImpl.Insert(newUser);
		if (!isRegistered) {
		        returnValue.put("response", false);
		        returnValue.put("msg", "회원가입 실패.");
		        return returnValue;
		}
		    
		returnValue.put("response", true);
		returnValue.put("msg", "회원가입이 성공.");
				
		connectionPool.txCommit();
			
		return returnValue;
	}
	
	




	//회원탈퇴
//	public Map<String,Object> remove() throws Exception{
//		Map<String,Object> returnValue =new HashMap();
//		connectionPool.txStart();	
//	
//		//작업위치
//		boolean success = offerDaoImpl.remove(id받으면될듯..); // 회원 삭제 메서드 호출
//		if (success) {
//            returnValue.put("success", true);
//            returnValue.put("message", "회원 탈퇴에 성공하였습니다.");
//        } else {
//            returnValue.put("success", false);
//            returnValue.put("message", "회원 탈퇴에 실패하였습니다.");
//        } 
//				
//		connectionPool.txCommit();
//	
//
//		return returnValue;
//	}
	
	
	//이력서 등록
//	public Map<String,Object> addResume() throws Exception{
//		Map<String,Object> returnValue =new HashMap();
//		connectionPool.txStart();
//		
//		//작업위치
//		
//		connectionPool.txCommit();
//		return returnValue;
	
	
	private UserDto getUser(String id) throws Exception{
		connectionPool.txStart();
		UserDto userDto =  userDaoImpl.Select(id);
		connectionPool.txCommit();
		return userDto;
	}
	
}
	

