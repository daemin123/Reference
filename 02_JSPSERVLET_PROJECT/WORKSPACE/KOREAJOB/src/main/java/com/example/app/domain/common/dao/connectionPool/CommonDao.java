package com.example.app.domain.common.dao.connectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.app.domain.common.dto.UserDto;
import com.example.app.domain.offer.dto.OfferDto;

public class CommonDao {
	protected Connection conn =null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;
	
	protected ConnectionPool connectionPool;
	
	public CommonDao() throws Exception{
		connectionPool = ConnectionPool.getInstance();
		conn = connectionPool.getConnection();
	}

	public void freeConnection(Connection conn) throws SQLException {
		 conn.close();
	}
	public void freeConnection(Connection conn,PreparedStatement pstmt) throws SQLException {
		pstmt.close(); 
		conn.close();
	}
	public void freeConnection(Connection conn,PreparedStatement pstmt,ResultSet rs) throws SQLException {
		rs.close();
		pstmt.close();
		conn.close();
	}
	public void freeConnection(PreparedStatement pstmt) throws SQLException {
		pstmt.close(); 
	}
	public void freeConnection(PreparedStatement pstmt,ResultSet rs) throws SQLException {
		rs.close();
		pstmt.close(); 
	}	
	

	// 기본 CRUD 함수
	public boolean INSERT(Object object ) {
		return false;
	}

	public boolean Update(OfferDto dto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean Remove(OfferDto dto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public OfferDto Select(OfferDto dto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean Insert(UserDto dto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
















