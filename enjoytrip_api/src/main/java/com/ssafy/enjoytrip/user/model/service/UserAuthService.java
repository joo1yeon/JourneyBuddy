package com.ssafy.enjoytrip.user.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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

	@Autowired
	public UserAuthService(UserMapper userMapper) {
		super();
		this.userMapper = userMapper;
	}

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		
		try {
			UserDto loginUser = userMapper.getUser(userId);
			UserDetailsImpl userDetailsImpl = new UserDetailsImpl(loginUser);
			
			List<String> authorities = userMapper.getUserAuthorities(userId);
			ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
			
			for (String auth : authorities) {
				grantedAuthorities.add(new SimpleGrantedAuthority(auth));
			}
			userDetailsImpl.setAuthorities(grantedAuthorities);
			
			return userDetailsImpl;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
