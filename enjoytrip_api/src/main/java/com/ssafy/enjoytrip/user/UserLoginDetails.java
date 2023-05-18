package com.ssafy.enjoytrip.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserLoginDetails implements UserDetails {

    private final String username;
    private final String password;

    public UserLoginDetails(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 사용자의 권한을 반환하는 메소드 구현
        // 필요에 따라 사용자의 권한 정보를 설정해야 합니다.
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    // 아래의 메소드들은 필요에 따라 구현할 수 있습니다.
    // 일반적인 경우에는 구현할 필요가 없습니다.
    // 만약 추가적인 사용자 정보가 필요하다면 해당 정보를 반환하도록 구현할 수 있습니다.

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}