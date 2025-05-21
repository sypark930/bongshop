package com.bongmall.basic.member;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //생성자 주입
@Service
public class MemberService {
	
	private final MemberMapper memberMapper;
	
	
	public String idCheck(String mbsp_id) {
		return memberMapper.idCheck(mbsp_id);
	}
	
	public void join(MemberVO vo) {
		memberMapper.join(vo);
	}
	
	public MemberVO login(String mbsp_id) {
		return memberMapper.login(mbsp_id);
	}
	
	public MemberVO modify(String mbsp_id) {
		return memberMapper.modify(mbsp_id);
	}
	
	public void modify_save(MemberVO vo) {
		memberMapper.modify_save(vo);
	}
	
	public void pwchange(String mbsp_id, String mbsp_password) {
		memberMapper.pwchange(mbsp_id, mbsp_password);
	}
	
	public String idsearch(String mbsp_name, String mbsp_email) {
		return memberMapper.idsearch(mbsp_name, mbsp_email);
	}
	
	public String pwtemp_confirm(String mbsp_id, String mbsp_email) {
		return memberMapper.pwtemp_confirm(mbsp_id, mbsp_email);
	}
}
