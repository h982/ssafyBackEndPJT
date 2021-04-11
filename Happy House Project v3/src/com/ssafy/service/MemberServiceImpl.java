package com.ssafy.service;

import com.ssafy.dao.MemberDaoImpl;
import com.ssafy.dto.MemberDto;

public class MemberServiceImpl implements MemberService {
	private static MemberServiceImpl instance;
	
	private MemberServiceImpl() {}
	
	public static MemberServiceImpl getInstance() {
		if(instance == null)
			instance = new MemberServiceImpl();
		return instance;
	}
	
	@Override
	public void registerMember(MemberDto memberDto) throws Exception {
		MemberDaoImpl.getInstance().registerMember(memberDto);
	}
	
	@Override
	public MemberDto login(String userId, String userPwd) throws Exception {
		return MemberDaoImpl.getInstance().login(userId, userPwd);
	}

	@Override
	public MemberDto getMember(String userId) throws Exception {
		return MemberDaoImpl.getInstance().getMember(userId);
	}

	@Override
	public void modifyMember(MemberDto memberDto) throws Exception {
		MemberDaoImpl.getInstance().modifyMember(memberDto);
	}

	@Override
	public void deleteMember(String userId) throws Exception {
		MemberDaoImpl.getInstance().deleteMember(userId);
	}

}
