package com.ssafy.enjoytrip.user.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.config.security.UserDetailsImpl;
import com.ssafy.enjoytrip.user.model.UserDto;
import com.ssafy.enjoytrip.user.model.mapper.UserMapper;

@Service
public class UserAuthService implements UserDetailsService {

	private final UserMapper userMapper;

	public UserAuthService(UserMapper userMapper) {
		super();
		this.userMapper = userMapper;
	}

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		
		try {
			UserDto loginUser = userMapper.getUser(userId);
			return new UserDetailsImpl(loginUser);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
