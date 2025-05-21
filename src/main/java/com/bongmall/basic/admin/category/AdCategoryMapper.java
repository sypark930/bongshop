package com.bongmall.basic.admin.category;

import java.util.List;

public interface AdCategoryMapper {

	List<CategoryVO> getFirstCategoryList();
	
	List<CategoryVO> getSecondCategoryList(Integer cate_prt_code);
	
	CategoryVO getFirstCategoryBySecondCategory(int secondCategory);
	
}
