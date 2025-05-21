package com.bongmall.basic.review;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewReply {

	
		private Long reply_id;
		private Long rev_code;
		private String manager_id;
		private String reply_text;
		private LocalDateTime reply_date;
}
