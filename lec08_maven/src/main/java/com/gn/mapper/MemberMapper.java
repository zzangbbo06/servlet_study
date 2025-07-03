package com.gn.mapper;

import com.gn.dto.Member;

public interface MemberMapper {
	
	int insert(Member member);
	Member selectMember(Member param);
}
