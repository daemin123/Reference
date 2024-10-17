package com.example.app.domain.offer.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.app.domain.common.dao.connectionPool.CommonDao;
import com.example.app.domain.common.dto.UserDto;
import com.example.app.domain.offer.dto.OfferDto;

public class OfferDaoImpl extends CommonDao implements OfferDao{

	
	//싱글톤 패턴 적용 
	private static OfferDaoImpl instance ;
	public static OfferDaoImpl getInstance() throws Exception {
		if(instance==null)
			instance=new OfferDaoImpl();
		return instance;
	}
	private OfferDaoImpl() throws Exception{
		System.out.println("OfferDaoImpl's constructor invoke .." + conn);
	}
	
	
	
	//INSERT
	// offer db 에 입력
	@Override
	public  boolean Insert(OfferDto dto) throws Exception {
		pstmt=conn.prepareStatement("insert into offer values(?,?,?,?)");
		pstmt.setString(1, dto.getId());  		
		pstmt.setString(2, dto.getOfferName());
		pstmt.setString(3, dto.getOfferTel());
		pstmt.setString(4, dto.getOfferAddress());

		int result=pstmt.executeUpdate();
		
		freeConnection(pstmt);
		System.out.println("insert 성공");
		return result>0;
	}
	
	//USER/INSERT
	// offer db 에 입력
	@Override
	public boolean Insert(UserDto dto) throws Exception {
		pstmt =  conn.prepareStatement("insert into user values(?,?,?,?,?)");
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getPassword());
		pstmt.setNString(3, dto.getRole().name());
		pstmt.setBoolean(4, false);
		pstmt.setString(5,dto.getUsername());
		int result = pstmt.executeUpdate();
		freeConnection(pstmt);
		return result>0;
	}
	
	//UPDATE
	@Override
	public boolean Update(OfferDto dto) throws Exception {
		pstmt =	conn.prepareStatement("update offer set name=?, id=?, pw=?, Tel =? where Offername=?  ");
		pstmt.setString(1, dto.getOfferName());
		pstmt.setString(2, dto.getId());
		pstmt.setString(3, dto.getPassword());
		pstmt.setString(4, dto.getOfferTel());
		pstmt.setString(5, dto.getOfferAddress());
	
		int result = pstmt.executeUpdate();
		freeConnection(pstmt);
	    return result > 0;
	}
	
	//remove
	//offername을 이용한 삭제 
//	@Override
//	public boolean Remove(OfferDto dto) throws Exception {
//		System.out.println("DB Connected..");
//		
//		pstmt =	conn.prepareStatement("delete from user where OfferName=?");
//		pstmt.setString(1, dto.getOfferName());
//		
//		
//		int result =  pstmt.executeUpdate();
//		
//		if(result>0)
//			System.out.println("REMOVE 성공");
//		else
//			System.out.println("REMOVE 실패");
//		
//		return result>0;
//	}
	
	//SELECT ONE
	//DB명 offer offerName으로 단건 조회
	@Override
	public OfferDto Select(OfferDto dto)throws Exception {
		pstmt = conn.prepareStatement("select * from offer where OfferName=?");
		pstmt.setString(1, dto.getOfferName());
		rs =  pstmt.executeQuery();
		if(rs!=null) {
			rs.next();
			dto= new OfferDto();
			dto.setOfferName(rs.getString("OfferName"));
			dto.setOfferTel(rs.getString("Tel"));
			dto.setOfferAddress(rs.getString("address"));
		}
		freeConnection(pstmt,rs);
		return dto;
	}
	

	//SELECT
	//offer db에서 전체조회 
	@Override
	public List<OfferDto> SelectAll() throws Exception{
		pstmt = conn.prepareStatement("select * from Offer");
		rs =  pstmt.executeQuery();
		List<OfferDto> list = new ArrayList();
		OfferDto dto = null;
		if(rs!=null)
		{
			while(rs.next()) {
				dto = new OfferDto();
				dto.setOfferName(rs.getString("OfferName"));
				dto.setOfferTel(rs.getString("Tel"));
				dto.setOfferAddress(rs.getString("address"));
				list.add(dto);
			}
		}	
		freeConnection(pstmt,rs);
		return list;
	}
	
	
	@Override
	public OfferDto Select(String offername) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean Remove(String Id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean Update(String Id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	

	
	
	






	
}
