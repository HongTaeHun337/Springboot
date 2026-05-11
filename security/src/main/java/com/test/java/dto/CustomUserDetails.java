package com.test.java.dto;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.test.java.entity.Member;

import lombok.Getter;

//인증 사용자 정보 객체 > 인증 티켓
@Getter
public class CustomUserDetails implements UserDetails{
	
	//사용자 추가 정보
	//- 이전 수업(MemberDto)
	//- 현재 수업(MemberDto or Member)
	//private MemberDto dto;
	private Member member;
	
	public CustomUserDetails(Member member) {
		this.member = member;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		authorities.add(new GrantedAuthority() {
			@Override
			public String getAuthority() {
				return member.getRole();
			}
		});
		
		return authorities;
	}

	@Override
	public String getPassword() {

		return member.getPassword();
	}

	@Override
	public String getUsername() {
		
		return member.getUsername();
	}

}
