package com.bongmall.basic.review;

import java.time.LocalDateTime;
import java.util.List;

import com.bongmall.basic.admin.product.ProductVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewVO {

	
		private Long rev_code;
		private String mbsp_id;
		private Integer pro_num;
		private String rev_content;
		private int rev_rate;
		private LocalDateTime rev_date;
		
		/*상품 사용자 후기 목록에서 사용 안함
		  관리자 상품 후기 목록에서 사용됨*/
		private ProductVO product;
		
		/*어드민에서 리뷰에대한 답글 기능 / review_tbl 테이블 (1) review_replies_tbl테이블 (n)
		  left outer join / mybatis의 collection문법 사용*/
		private List<ReviewReply> replies;


}


