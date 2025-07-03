package com.gn.service;

import com.gn.dao.MemberDao;
import com.gn.dto.Member;

public class MemberService {
	
	private MemberDao dao = new MemberDao();
	
	public int insertMember(String id, String pw) {
		Member member = new Member();
		// 새롭게 만들어줄 바구니가 필요
		member.setMemberId(id);
		member.setMemberPw(pw);
		
		return dao.insert(member);
	}
	
	public Member selectMember(String memberId, String memberPw) {
		Member param = new Member();
		param.setMemberId(memberId);
		param.setMemberPw(memberPw);
		
		Member result = dao.selectMember(param);
		return result;
	}
}
