package com.bongmall.basic.mail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController  // @Controller + @ResponseBody
@RequestMapping("/email/*")
public class EmailController {

	private final EmailService emailService;
	
	// 메일 인증코드발급
	@GetMapping("/authcode") // string type 은 메일을 발송할때 용도를 구분해서 용도에 맞는 파일을 보냄
	public ResponseEntity<String> authcode(String type, EmailDTO dto, HttpSession session) {
		
		ResponseEntity<String> entity = null;
		
		// type : 메일 템플릿파일명.  "authcode"
		type = "mail/" + type; //"mail/authcode"
		
		String authcode = emailService.createAuthCode();
		// 메일 발송하기 전에 메일인증코드를 세션에 저장. 
		session.setAttribute("authcode", authcode);
		
		//메일 인증코드 발송!
		emailService.sendMail(type, dto, authcode);
		
		entity = new ResponseEntity<String>("success", HttpStatus.OK);
		
		
		return entity;
	}
	
	// 인증코드 확인
	@GetMapping("/confirm_authcode")
	public ResponseEntity<String> confirm_authcode(String authcode, HttpSession session) {
		
		ResponseEntity<String> entity = null;
		// 인증확인을 위하여 서버측에 저장했던 인증코드를 읽어오는 작업.
		String au_code = (String)session.getAttribute("authcode");
		
		String result = "";
		
		// 사용자가 입력한 인증코드와 세션으로 저장했던 발급해준 인증코드를 비교
		if(authcode.equals(au_code)) {
			result = "success";
			// 세션제거.(서버측의 사용한 메모리소멸)
			session.removeAttribute("authcode");
			
		}else {
			result = "fail";
		}
		
		entity = new ResponseEntity<String>(result, HttpStatus.OK);
	
		return entity;
	}
	
}