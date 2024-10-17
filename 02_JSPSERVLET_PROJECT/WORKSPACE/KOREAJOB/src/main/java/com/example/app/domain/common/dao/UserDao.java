package com.example.app.domain.common.dao;

import java.util.List;

import com.example.app.domain.common.dto.SessionDto;
import com.example.app.domain.common.dto.UserDto;

public interface UserDao {

	//INSERT
		boolean Insert(UserDto dto) throws Exception;

		UserDto Select(String username) throws Exception;

		List<UserDto> SelectAll() throws Exception;

		boolean Delete(String userid) throws Exception;

		boolean Update(String userid) throws Exception;
}
