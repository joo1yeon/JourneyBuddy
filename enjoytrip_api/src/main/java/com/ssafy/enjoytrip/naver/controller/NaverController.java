package com.ssafy.enjoytrip.naver.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.config.jwt.JwtToken;
import com.ssafy.enjoytrip.naver.model.service.NaverService;
import com.ssafy.enjoytrip.user.model.UserDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/login/oauth2/code/naver")
@RequiredArgsConstructor
@CrossOrigin("*")
public class NaverController {
	
	private NaverService naverService;

	public NaverController(NaverService naverService) {
		super();
		this.naverService = naverService;
	}
	


//	@PostMapping
//	public ResponseEntity<?> doSocialLogin(@RequestBody SocialLoginRequest request) {
//
//        return ResponseEntity.created(URI.create("/social-login"))
//                .body(userService.doSocialLogin(request));
//    }
	@GetMapping
	public ResponseEntity<?> loginNaver(@RequestBody UserDto userDto) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
		} catch (Exception e) {
			exceptionHandling(e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		System.out.println(resultMap.get("message"));
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}


	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
