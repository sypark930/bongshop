package com.bongmall.basic.admin.category;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/admin/category/*")
@RequiredArgsConstructor
@Slf4j
@Controller
public class AdCategoryController {

	private final AdCategoryService adCategoryService;
	
	
	@GetMapping("/secondcategory/{cate_prt_code}")
	public ResponseEntity<List<CategoryVO>> getSecondCategoryList(@PathVariable("cate_prt_code") Integer cate_prt_code){
		log.info("1차 카테고리코드 : " + cate_prt_code);
		
		ResponseEntity<List<CategoryVO>> entity = null;
			
		entity = new ResponseEntity<List<CategoryVO>>(adCategoryService.getSecondCategoryList(cate_prt_code), HttpStatus.OK);
		
		return entity;
	}
}
