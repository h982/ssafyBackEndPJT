package com.ssafy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.dto.MemberDto;
import com.ssafy.util.DBUtil;

public class MemberDaoImpl implements MemberDao {
	private static MemberDaoImpl instance;
	
	private MemberDaoImpl() {}
	
	public static MemberDaoImpl getInstance() {
		if(instance == null)
			instance = new MemberDaoImpl();
		return instance;
	}
	
	@Override
	public void registerMember(MemberDto memberDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnect();
			String sql = "INSERT INTO ssafy_member (userid, userpwd, username, email, address) \n";
			sql += "VALUES(?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getUserId());
			pstmt.setString(2, memberDto.getUserPwd());
			pstmt.setString(3, memberDto.getUserName());
			pstmt.setString(4, memberDto.getEmail());
			pstmt.setString(5, memberDto.getAddress());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(pstmt, conn);
		}
	}

	@Override
	public MemberDto login(String userId, String userPwd) throws SQLException {
		MemberDto memberDto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnect();
			String sql = "SELECT username, email, address \n";
			sql += "FROM ssafy_member \n";
			sql += "WHERE userid = ? AND userpwd = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setUserName(rs.getString("username"));
				memberDto.setUserId(userId);
				memberDto.setUserPwd(userPwd);
				memberDto.setEmail(rs.getString("email"));
				memberDto.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, pstmt, conn);
		}
		
			
		return memberDto;
	}

	@Override
	public MemberDto getMember(String userId) throws SQLException {
		MemberDto memberDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnect();
			String sql = "SELECT userpwd, username, email, address \n";
			sql += "FROM ssafy_member \n";
			sql += "WHERE userid = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setUserId(userId);
				memberDto.setUserPwd(rs.getString("userpwd"));
				memberDto.setUserName(rs.getString("username"));
				memberDto.setEmail(rs.getString("email"));
				memberDto.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return memberDto;
	}

	@Override
	public void modifyMember(MemberDto memberDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnect();
			String sql = "UPDATE ssafy_member SET userpwd = ?, username = ?, email = ?, address =? \n";
			sql += "WHERE userid = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getUserPwd());
			pstmt.setString(2, memberDto.getUserName());
			pstmt.setString(3, memberDto.getEmail());
			pstmt.setString(4, memberDto.getAddress());
			pstmt.setString(5, memberDto.getUserId());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(pstmt, conn);
		}
	}

	@Override
	public void deleteMember(String userId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnect();
			String sql = "DELETE FROM ssafy_member \n";
			sql += "WHERE userid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(pstmt, conn);
		}

	}

}
