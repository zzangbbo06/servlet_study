package com.gn.service;

import com.gn.dao.MemberDao;
import com.gn.dto.Member;

public class MemberService {
	
	private MemberDao dao = new MemberDao();
	
	public int insertMember(String id, String pw) {
		Member member = new Member();
		member.setMemberId(id);
		member.setMemberPw(pw);
		
		return dao.insert(member);
	}
}
