package member.service;

import member.model.Member;

public class MemberData {
	
	private Member member;

	public MemberData(Member member) {
		super();
		this.member = member;
	}

	public Member getMember() {
		return member;
	}
	
	
}
