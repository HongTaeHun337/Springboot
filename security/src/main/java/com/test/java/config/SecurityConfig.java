package com.test.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		//<security:http> 설정
		
		//7. URL 허가하기
		//- requestMatchers() 주의점. 같은 URL를 2번이상 정의하면 처음 정의만 적용
		http.authorizeHttpRequests(auth -> auth
			//.requestMatchers("/").permitAll()
			//.requestMatchers("/login").permitAll()
			//.requestMatchers("/join").permitAll()
			//.requestMatchers("/joinok").permitAll()
			.requestMatchers("/", "/login", "/join", "joinok").permitAll()
			//.requestMatchers("/member").hasRole("MEMBER") //ROLE_MEMBER
			//.requestMatchers("/member").hasRole("ADMIN")
			.requestMatchers("/member").hasAnyRole("MEMBER", "ADMIN")
			.requestMatchers("/admin").hasRole("ADMIN")
			.anyRequest().authenticated()
			
			//.requestMatchers("/info").authenticated()
			//.requestMatchers("intro").anonymous()
			
		);
		
		//개발 > CSRF 비활성화
		//http.csrf(auth -> auth.disable());
		
		//커스텀 로그인 페이지
		http.formLogin(auth -> auth
				.loginPage("/login")  //내가 만든 로그인 페이지
				.loginProcessingUrl("/loginok")
				);
				
		//예외 처리 핸들러
		http.exceptionHandling(auth -> auth 
			.authenticationEntryPoint((request, response, exception) ->{
				//401
				//- 익명 사용자 접근 > 로그인 페이지로 강제 이동
				response.sendRedirect("/login");
			})
			.accessDeniedHandler((request, respinse, exception) -> {
				//403
				//- 인증 유저 + 권한 없음
				respinse.sendRedirect("/denied");
			})
		);
		
		
		return http.build();
		
		
	}
	
	
	
	
	
	@Bean
	BCryptPasswordEncoder encoder() {
		
		return new BCryptPasswordEncoder();
	}

}
