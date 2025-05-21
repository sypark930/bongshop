package com.bongmall.basic.payment;

import org.apache.ibatis.annotations.Param;

public interface PaymentMapper {
	void payment_insert(PaymentVO vo);
	
	void payment_status(@Param("payment_id") Integer payment_id, @Param("payment_status") String payment_status);
}
