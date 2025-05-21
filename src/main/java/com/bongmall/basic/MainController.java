package com.bongmall.basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bongmall.basic.admin.category.AdCategoryService;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainController {
	
	private final AdCategoryService adCategoryService;
	
		@GetMapping("/")
		public String home(Model model) {
			
			//1차 카테고리 목록 보여주기
			model.addAttribute("cate_list", adCategoryService.getFirstCategoryList());
			
			return "index";
	
	}
}
