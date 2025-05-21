package com.bongmall.basic.common.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

// 지메일설정정보가 application.properties 파일에 존재하면 스프링부트에서는 직접 참조가 가능하다.
@Configuration
@PropertySource("classpath:mail/email.properties")
public class EmailConfig {

	@Value("${spring.mail.transport.protocol}")
	private String protocol;
	
	@Value("${spring.mail.debug}")
	private boolean debug;
	
	@Value("${spring.mail.properties.mail.smtp.auth}")
	private boolean auth;
	
	@Value("${spring.mail.properties.mail.smtp.starttls.enable}")
	private boolean starttls;
	
	@Value("${spring.mail.host}")
	private String host;
	
	@Value("${spring.mail.port}")
	private int port;
	
	@Value("${spring.mail.username}")
	private String username;
	
	@Value("${spring.mail.password}")
	private String password;
	
	@Value("${spring.mail.default-encoding}")
	private String encoding;
	
	
	// JavaMailSenderImpl : 메일발송을 하는 기능제공
	// 준비내용: 메일(SMTP)서버 정보
	@Bean
	public JavaMailSender javaMailSender() {
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
				
		// setter메서드 사용
		mailSender.setHost(host);
		mailSender.setUsername(username);
		mailSender.setPassword(password);
		mailSender.setPort(port);
		mailSender.setDefaultEncoding(encoding);
		
		// Map 인터페이스를 구현한 컬렉션기능을 제공하는 클래스.
		// 파일의 확장자가 properties파일 정보를 읽고쓰는 기능제공.
		Properties properties = new Properties();
				
		// properties클래스 매개변수를 사용하여 정보제공
		properties.put("mail.smtp.auth", auth); //(key , 변수)
		properties.put("mail.smtp.starttls.enable", starttls);
		
		mailSender.setJavaMailProperties(properties);
		
		return mailSender;
				
	}
		
}
