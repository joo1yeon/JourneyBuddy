package com.ssafy.enjoytrip.user.model.mapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.GrantedAuthority;

import com.ssafy.enjoytrip.config.jwt.JwtToken;
import com.ssafy.enjoytrip.user.model.FileInfoDto;
import com.ssafy.enjoytrip.user.model.UserDto;

@Mapper
public interface UserMapper {

	int joinUser(UserDto userDto) throws SQLException;
	int registerUserId(String userId) throws SQLException;
	int registerAuthority(String userId) throws SQLException;
	UserDto loginUser(UserDto userDto) throws SQLException;
	UserDto getUser(String userId) throws SQLException;
	int updateUser(UserDto userDto) throws SQLException;
	int deleteUser(String userId) throws SQLException;
	List<UserDto> getUserList() throws SQLException;
	int updateFile(UserDto userDto) throws SQLException;
	int updateRefreshToken(UserDto userDto) throws SQLException;
	int deleteRefreshToken(String userId) throws SQLException;
	List<String> getUserAuthorities(String userId) throws SQLException;
	FileInfoDto getUserFileInfo(String userId) throws SQLException;
	
}
