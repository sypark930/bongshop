package com.bongmall.basic.review;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bongmall.basic.common.utils.SearchCriteria;

public interface ReviewMapper {

	List<ReviewVO> rev_list(@Param("pro_num") Integer pro_num,@Param("cri") SearchCriteria cri);
	
	int getCountReviewByPro_num(Integer pro_num);
	
	void review_save(ReviewVO vo);
	
	ReviewVO review_info(Long rev_code);
	
	void review_modify(ReviewVO vo);
	void review_delete(Long rev_code);
	void reply_insert(ReviewReply vo);
}
