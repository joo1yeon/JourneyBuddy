package com.ssafy.enjoytrip.config;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ssafy.enjoytrip.user.model.UserDto;
import com.ssafy.enjoytrip.user.model.mapper.UserMapper;
import com.ssafy.enjoytrip.user.model.service.UserServiceImpl;


public class UserAuthService implements UserDetailsService {

	private final UserMapper userMapper;

	public UserAuthService(UserMapper userMapper) {
		super();
		this.userMapper = userMapper;
	}


	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		
		UserDetailsImpl userDetailsImpl = new UserDetailsImpl();
		try {
			UserDto loginUser = userMapper.getUser(userId);
			userDetailsImpl.setUsername(loginUser.getUserId());
			userDetailsImpl.setPassword(loginUser.getUserPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userDetailsImpl;
	}
	
}
