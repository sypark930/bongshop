package com.bongmall.basic.review;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bongmall.basic.common.utils.SearchCriteria;
import com.bongmall.basic.product.ProductMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReviewService {

	
		private final ReviewMapper reviewMapper;
		private final ProductMapper productMapper;
		
		public List<ReviewVO> rev_list(Integer pro_num, SearchCriteria cri) {
			return reviewMapper.rev_list(pro_num, cri);
		}
		
		public int getCountReviewByPro_num(Integer pro_num) {
			return reviewMapper.getCountReviewByPro_num(pro_num);
		}
	
		@Transactional
		public void review_save(ReviewVO vo) {
			reviewMapper.review_save(vo);
			productMapper.review_count(vo.getPro_num());
		}
		
		public ReviewVO review_info(Long rev_code) {
			return reviewMapper.review_info(rev_code);
		}
	
		public void review_modify(ReviewVO vo) {
			reviewMapper.review_modify(vo);
		}
		
		public void review_delete(Long rev_code) {
			reviewMapper.review_delete(rev_code);
		}
		
		public void reply_insert(ReviewReply vo) {
			reviewMapper.reply_insert(vo);
		}
}
