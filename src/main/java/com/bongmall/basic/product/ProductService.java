package com.bongmall.basic.product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bongmall.basic.admin.product.ProductVO;
import com.bongmall.basic.common.utils.SearchCriteria;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductMapper productMapper;
	
	public List<ProductVO> getProductListBysecondCategory(SearchCriteria cri, Integer second_cate_code) {
		return productMapper.getProductListBysecondCategory(cri, second_cate_code);
	}
	
	public int getCountProductListBysecondCategory(Integer second_cate_code) {
		return productMapper.getCountProductListBysecondCategory(second_cate_code);
	}
	
	public ProductVO pro_info(Integer pro_num) {
		return productMapper.pro_info(pro_num);
	}
	
	public int review_count_pro_info(Integer pro_num) {
		return productMapper.review_count_pro_info(pro_num);
	}
	
}
