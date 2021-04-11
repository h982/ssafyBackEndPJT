package com.ssafy.dao;

import java.sql.SQLException;

import com.ssafy.dto.MemberDto;

public interface MemberDao {
//	회원가입
	void registerMember(MemberDto memberDto)throws SQLException;
	
//	로그인
	MemberDto login(String userId, String userPwd)throws SQLException;
	
//	회원정보 수정을 위한 회원의 모든 정보 얻기
	MemberDto getMember(String userId)throws SQLException;
	
//	회원정보 수정
	void modifyMember(MemberDto memberDto)throws SQLException;
	
//	회원탈퇴
	void deleteMember(String userId)throws SQLException;
}
