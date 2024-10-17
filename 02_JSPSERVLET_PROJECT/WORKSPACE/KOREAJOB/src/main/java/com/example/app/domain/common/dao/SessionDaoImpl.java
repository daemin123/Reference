package com.example.app.domain.common.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.app.domain.common.dao.connectionPool.CommonDao;
import com.example.app.domain.common.dto.SessionDto;
import com.example.app.type.ROLE;

public class SessionDaoImpl extends CommonDao implements SessionDao{

	private static SessionDaoImpl instance ;
	public static SessionDaoImpl getInstance() throws Exception {
		if(instance==null)
			instance=new SessionDaoImpl();
		return instance;
	}
	
	private SessionDaoImpl() throws Exception{
		System.out.println("SessionDaoImpl Constructor "+conn);

	}

	@Override
	public boolean Insert(SessionDto sessionDto) throws Exception {
		pstmt =  conn.prepareStatement("insert into session values(?,?,?)");
		pstmt.setString(1, sessionDto.getSessionId());
		pstmt.setString(2, sessionDto.getUsername());
		pstmt.setNString(3, sessionDto.getRole().name());
		
		return pstmt.executeUpdate()>0;
	}

	
	//id로 찾기
	@Override
	public SessionDto Select(int sessiondId) throws Exception {
		pstmt = conn.prepareStatement("select * from session where id=?");
		pstmt.setInt(1,sessiondId);
		rs=pstmt.executeQuery();
		SessionDto dto=null;
		if(rs!=null) {
			rs.next();
			dto=new SessionDto();
			dto.setUsername(rs.getString("username"));
			String roleString=rs.getString("role");
			ROLE role=ROLE.valueOf(roleString);
			dto.setRole(role);
			dto.setSessionId(rs.getString("id"));
		}
			
		freeConnection(pstmt,rs);
		return dto;
	}

	//이름으로 찾기
	@Override
	public SessionDto Select(String username) throws Exception {
		pstmt = conn.prepareStatement("select * from session where username=? order by id desc");
		pstmt.setString(1,username);
		
		rs=pstmt.executeQuery();
		SessionDto dto=null;
		if(rs!=null) {
			rs.next();
			dto=new SessionDto();
			dto.setUsername(rs.getString("username"));
			String roleString=rs.getString("role");
			ROLE role=ROLE.valueOf(roleString);
			dto.setRole(role);
			dto.setSessionId(rs.getString("id"));
		}
		freeConnection(pstmt,rs);
		return dto;
	}
	
	//세션id로 삭제
	@Override
	public boolean Delete(String sessionId) throws Exception {
		pstmt = conn.prepareStatement("delete from session where id=?");
		pstmt.setString(1, sessionId);
		int result = pstmt.executeUpdate();
		
		freeConnection(pstmt);
		return  result>0;
	}

	
	//전체조회
	@Override
	public List<SessionDto> SelectAll() throws Exception {
		pstmt = conn.prepareStatement("select * from session");
		rs =  pstmt.executeQuery();
		List<SessionDto> list = new ArrayList();
		SessionDto dto = null;
		if(rs!=null)
		{
			while(rs.next()) {
				dto = new SessionDto();
				dto.setUsername(rs.getString("username"));
				dto.setSessionId(rs.getString("id"));
				String roleString=rs.getString("role");
				ROLE role=ROLE.valueOf(roleString);
				dto.setRole(role);
				list.add(dto);
			}
		}	
		freeConnection(pstmt,rs);
		return list;
	}
	
	@Override
	public boolean Update(String userid) throws Exception{
		pstmt = conn.prepareStatement("update session set=? where id=?");
		pstmt.setString(1, "username");
		pstmt.setString(2, userid);
		int result = pstmt.executeUpdate();
		
		freeConnection(pstmt);
		return  result>0;
	}

}
	


	
	
