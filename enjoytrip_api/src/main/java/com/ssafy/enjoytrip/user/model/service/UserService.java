package com.ssafy.enjoytrip.user.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.enjoytrip.config.jwt.JwtToken;
import com.ssafy.enjoytrip.user.model.UserDto;

public interface UserService {
	
	int joinUser(UserDto userDto) throws SQLException;
	JwtToken loginUser(UserDto userDto) throws SQLException;
	UserDto getUser(String userId) throws SQLException;
	int updateUser(UserDto userDto) throws SQLException;
	int deleteUser(String userId) throws SQLException;
	List<UserDto> getUserList() throws SQLException;
	String findBy(String userId) throws SQLException;
}
