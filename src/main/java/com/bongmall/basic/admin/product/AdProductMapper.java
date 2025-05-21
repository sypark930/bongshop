package com.bongmall.basic.admin.product;

import java.util.HashMap;
import java.util.List;

import com.bongmall.basic.common.utils.SearchCriteria;


public interface AdProductMapper {
	
	void pro_insert(ProductVO vo);
	
	List<ProductVO> pro_list(SearchCriteria cri);
	
	int getTotalCount(SearchCriteria cri);
	
	void pro_sel_delete_2(int[] pro_num_arr);
	
	void pro_sel_delete_3(HashMap<String, Object> map);
	
	ProductVO pro_edit_form(Integer pro_num);
	
	void pro_edit_ok(ProductVO vo);
	
	void pro_delete(Integer pro_num);
	
}
