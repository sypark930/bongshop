package com.bongmall.basic.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//pom.xml 에서 스프링 시큐리티 의존성 구문이 존재해야 함
@Configuration
public class SecurityConfig {

	
	// 스프링부트가 시작되면 빈 어노테이션의 기능때문에 아래 매서드가 자동으로 호출, 객체가 생성되는데 그 객체를 bean이라함
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

