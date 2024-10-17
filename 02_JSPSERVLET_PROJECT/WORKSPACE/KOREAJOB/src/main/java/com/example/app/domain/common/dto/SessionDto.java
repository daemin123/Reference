package com.example.app.domain.common.dto;
import java.io.Serializable;

import com.example.app.type.ROLE;

public class SessionDto  implements Serializable{
	private static final long serialVersionUID = 4L;

	
	private String sessionId;
	private String username;
	private ROLE role;
	//toString
	//getter and setter
	//생성자(디폴트,모든인자)
	@Override
	public String toString() {
		return "SessionDto [sessionId=" + sessionId + ", username=" + username + ", role=" + role + "]";
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public ROLE getRole() {
		return role;
	}
	public void setRole(ROLE role) {
		this.role = role;
	}
	public SessionDto(String sessionId, String username, ROLE role) {
		super();
		this.sessionId = sessionId;
		this.username = username;
		this.role = role;
	}
	public SessionDto() {}
	
	
	
	}
	
	

