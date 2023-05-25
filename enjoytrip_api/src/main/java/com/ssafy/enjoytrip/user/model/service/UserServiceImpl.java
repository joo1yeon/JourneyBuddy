package com.ssafy.enjoytrip.user.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.config.jwt.JwtToken;
import com.ssafy.enjoytrip.config.jwt.JwtTokenProvider;
import com.ssafy.enjoytrip.config.security.UserDetailsImpl;
import com.ssafy.enjoytrip.user.model.FileInfoDto;
import com.ssafy.enjoytrip.user.model.UserDto;
import com.ssafy.enjoytrip.user.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	
	private final UserMapper userMapper;
	
	// Spring Security, JWT 를 이용한 로그인 관련
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;
    
    @Autowired
	public UserServiceImpl(UserMapper userMapper, BCryptPasswordEncoder passwordEncoder,
			AuthenticationManagerBuilder authenticationManagerBuilder, JwtTokenProvider jwtTokenProvider) {
		super();
		this.userMapper = userMapper;
		this.passwordEncoder = passwordEncoder;
		this.authenticationManagerBuilder = authenticationManagerBuilder;
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@Override
	public int joinUser(UserDto userDto) throws SQLException {
		userDto.setUserPassword(passwordEncoder.encode(userDto.getUserPassword()));		
		userMapper.joinUser(userDto);
		userMapper.registerUserId(userDto.getUserId());
		return userMapper.registerAuthority(userDto.getUserId());
	}
	
	@Override
	public JwtToken loginUser(UserDto userDto) throws SQLException {
		UserDto loginUserDto = userMapper.loginUser(userDto);

		JwtToken token = null;
		if (passwordEncoder.matches(userDto.getUserPassword(), loginUserDto.getUserPassword())) {
			
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDto.getUserId(), userDto.getUserPassword());
			// Authentication 객체 생성
			Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
			// 검증된 인증 정보로 JWT 토큰 생성
			token = jwtTokenProvider.generateToken(authentication);
			
			loginUserDto.setToken(token.getRefreshToken());
			// DB에 refreshToken 저장
			userMapper.updateRefreshToken(loginUserDto);
		}
        
        return token;
	}
	
	@Override
	public UserDto getUser(String userId) throws SQLException {
		return userMapper.getUser(userId);
	}
	
	@Override
	public int updateUser(UserDto userDto) throws SQLException {
		FileInfoDto fileInfoDto = userDto.getFileInfo();
		if (fileInfoDto != null) {
			updateFile(userDto);
		}

		return userMapper.updateUser(userDto);
	}
	
	@Override
	public int deleteUser(String userId) throws SQLException {
		return userMapper.deleteUser(userId);
	}
	
	@Override
	public List<UserDto> getUserList() throws SQLException {
		return userMapper.getUserList();
	}
	
	@Override
	public int deleteRefreshToken(String userId) throws SQLException {
		return userMapper.deleteRefreshToken(userId);
	}
	
	@Override
	public int updateFile(UserDto userDto) throws SQLException {
		return userMapper.updateFile(userDto);
	}
	
	@Override
	public FileInfoDto getUserFileInfo(String userId) throws SQLException {
		return userMapper.getUserFileInfo(userId);
	}
	
	public ArrayList<GrantedAuthority> getUserAuthorities(String userId) throws SQLException {
        List<String> authorities = userMapper.getUserAuthorities(userId);
        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for (String auth: authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(auth));
        }

        return grantedAuthorities;
	}

}
