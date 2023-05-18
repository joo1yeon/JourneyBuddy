package com.ssafy.enjoytrip.user.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.config.jwt.JwtToken;
import com.ssafy.enjoytrip.user.model.UserDto;

@Mapper
public interface UserMapper {

	int joinUser(UserDto userDto) throws SQLException;
	UserDto loginUser(UserDto userDto) throws SQLException;
	UserDto getUser(String userId) throws SQLException;
	int updateUser(UserDto userDto) throws SQLException;
	int deleteUser(String userId) throws SQLException;
	List<UserDto> getUserList() throws SQLException;
	int updateRefreshToken(UserDto userDto) throws SQLException;
	int deleteRefreshToken(String userId) throws SQLException;
	
}
