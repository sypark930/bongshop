package com.bongmall.basic.admin.review;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bongmall.basic.common.utils.SearchCriteria;
import com.bongmall.basic.review.ReviewReply;
import com.bongmall.basic.review.ReviewVO;

public interface AdReviewMapper {
	
List<ReviewVO> review_List(@Param("cri") SearchCriteria cri, @Param("rev_rate") String rev_rate,@Param("rev_content")String rev_content);

int review_count(@Param("cri") SearchCriteria cri, @Param("rev_reate") String rev_rate, @Param("rev_content")String rev_content);

ReviewReply reply_info(Long reply_id);

void reply_modify(@Param("reply_id") Long reply_id, @Param("reply_text") String reply_text);

void reply_delete(Long reply_id);
}
