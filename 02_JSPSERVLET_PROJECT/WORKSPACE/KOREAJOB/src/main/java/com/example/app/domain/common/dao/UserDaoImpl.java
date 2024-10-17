package com.example.app.domain.common.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.app.domain.common.dao.connectionPool.CommonDao;
import com.example.app.domain.common.dto.SessionDto;
import com.example.app.domain.common.dto.UserDto;
import com.example.app.type.ROLE;

public class UserDaoImpl extends CommonDao implements UserDao{

	private static UserDaoImpl instance ;
	public static UserDaoImpl getInstance() throws Exception {
		if(instance==null)
			instance=new UserDaoImpl();
		return instance;
	}
	private UserDaoImpl() throws Exception{
		System.out.println("UserDaoImpl's constructor invoke .." + conn);
	}
	
	
	@Override
	public boolean Insert(UserDto dto) throws Exception {
		pstmt =  conn.prepareStatement("insert into user values(?,?,?,?,?)");
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getPassword());
		pstmt.setNString(3, dto.getUsername());
		pstmt.setString(4, dto.getRole().name());
		pstmt.setString(5,"FALSE");
		int result = pstmt.executeUpdate();
		freeConnection(pstmt);
		return result>0;
	}
	
	
	//이름으로 찾기(수정요망)
//	@Override
//	public UserDto Select(String username) throws Exception {
//		pstmt = conn.prepareStatement("select * from user where username=?");
//		pstmt.setString(1, username);
//		rs = pstmt.executeQuery();
//		UserDto dto = null;
//		
//		if(rs!=null) {
//			if(rs.next()) {
//				dto = new UserDto();
//				dto.setUsername(username);
//				dto.setId("id");
//				dto.setPassword(rs.getString("password"));
//				String roleString=rs.getString("role");
//				ROLE role=ROLE.valueOf(roleString);
//				dto.setRole(role);
//				dto.setIslocked(rs.getBoolean("islocked"));
//			}
//			
//		}
//		freeConnection(pstmt,rs);
//		return dto;	
//	}
//	
	//id로 찾기
	public UserDto Select(String userid) throws Exception {
		pstmt = conn.prepareStatement("select * from user where id=?");
		pstmt.setString(1, userid);
		rs = pstmt.executeQuery();
		UserDto dto = null;
		
		if(rs.next()) {
				dto = new UserDto();
				dto.setId("id");
				dto.setUsername("username");
				dto.setPassword(rs.getString("password"));
				String roleString=rs.getString("role");
				ROLE role=ROLE.valueOf(roleString);
				dto.setRole(role);
				dto.setIslocked(rs.getBoolean("islocked"));		
		}
		freeConnection(pstmt,rs);
		return dto;	
	}
	
//	전체 조회
	@Override
	public List<UserDto> SelectAll() throws Exception {
		pstmt = conn.prepareStatement("select * from user");
		rs =  pstmt.executeQuery();
		List<UserDto> list = new ArrayList();
		UserDto dto = null;
		if(rs!=null)
		{
			while(rs.next()) {
				dto = new UserDto();
				dto.setUsername(rs.getString("username"));
				dto.setId(rs.getString("id"));	
				String roleString=rs.getString("role");
				ROLE role=ROLE.valueOf(roleString);
				dto.setRole(role);
				dto.setPassword(rs.getString("password"));
				dto.setIslocked(rs.getBoolean("islocked"));
				
				list.add(dto);
			}
		}	
		freeConnection(pstmt,rs);
		return list;
	}
	@Override
	public boolean Delete(String userid) throws Exception{
		pstmt = conn.prepareStatement("delete from user where id=?");
		pstmt.setString(1, userid);
		int result = pstmt.executeUpdate();
		
		freeConnection(pstmt);
		return  result>0;
	}
	
	//Update
	@Override
	public boolean Update(String userid) throws Exception{
		pstmt = conn.prepareStatement("update user set=? where id=?");
		pstmt.setString(1, "username");
		pstmt.setString(2, userid);
		int result = pstmt.executeUpdate();
		
		freeConnection(pstmt);
		return  result>0;
	}
}
		

	
