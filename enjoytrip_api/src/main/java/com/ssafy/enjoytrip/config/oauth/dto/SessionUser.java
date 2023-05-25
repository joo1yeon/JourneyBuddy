//package com.ssafy.enjoytrip.config.oauth.dto;
//
//import com.ssafy.enjoytrip.user.model.UserDto;
//
//import lombok.Getter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//@Getter
//public class SessionUser implements UserDetails {
//	
//    private UserDto userDto;
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Collection<GrantedAuthority> collections = new ArrayList<>();
//
//        collections.add(() -> {
//            return "ROLE_" + user.getRole();
//        });
//
//        return collections;
//    }
//
//    @Override
//    public String getPassword() {
//        return user.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getName();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//	public SessionUser(UserDto userDto) {
//		super();
//		this.userDto = userDto;
//	}
//
//	public SessionUser(UserDto userDto) {
//		super();
//		this.userDto = userDto;
//	}
//}
