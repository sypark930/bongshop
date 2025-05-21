package com.bongmall.basic.admin;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin/*")
@Controller
public class AdminController {
	
	
		private final AdminService adminService;
		private final PasswordEncoder passwordEncoder;
		
		@GetMapping("/")
		public String admin_login() {
			return "admin/ad_login";			
		}
		
		@PostMapping("/admin_ok")
		public String admin_ok(AdminDto dto, HttpSession session, RedirectAttributes rttr) throws Exception {
			AdminDto db_vo = adminService.admin_ok(dto.getAd_userid());
			
			String url = "";
			String msg = "";
			
			if(db_vo != null) {
				if(passwordEncoder.matches(dto.getAd_passwd(), db_vo.getAd_passwd()) ) {
					session.setAttribute("admin_auth", db_vo);
					url = "/admin/ad_menu";
				}else {
					url = "/admin/";
					msg = "pwfail";
				}
			}else {
				url = "/admin/";
				msg = "idfail";
			}
			
			rttr.addFlashAttribute("msg",msg);
			
			return "redirect:" + url;
		}
		@GetMapping("/ad_menu")
		public String menu() {
			
			return "admin/ad_menu";
		}
		
	
}
