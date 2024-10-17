package com.example.app.domain.common.service;

import com.example.app.domain.common.dto.UserDto;

public interface UserService {

	UserDto getUser(String username) throws Exception;

}
