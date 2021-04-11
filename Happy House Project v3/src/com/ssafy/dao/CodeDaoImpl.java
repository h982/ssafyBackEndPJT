package com.ssafy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.Code;
import com.ssafy.dto.MemberDto;
import com.ssafy.util.DBUtil;

public class CodeDaoImpl implements CodeDao {
	private static CodeDaoImpl instance;
	
	private CodeDaoImpl() {}
	
	public static CodeDaoImpl getInstance() {
		if(instance == null)
			instance = new CodeDaoImpl();
		return instance;
	}
	@Override
	public List<Code> getSidoList() throws SQLException {
		List<Code> cityList = new ArrayList<Code>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnect();
			String sql = "SELECT * \n";
			sql += "FROM sidocode \n";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Code city = new Code();
				city.setName(rs.getString("sido_name"));
				city.setDongCode(rs.getString("sido_code"));
				cityList.add(city);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, pstmt, conn);
		}
	
		return cityList;
	}

	@Override
	public List<Code> getGuList() throws SQLException {
		List<Code> guList = new ArrayList<Code>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnect();
			String sql = "SELECT * \n";
			sql += "FROM guguncode \n";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Code gu = new Code();
				gu.setName(rs.getString("gugun_name"));
				gu.setDongCode(rs.getString("gugun_code"));
				guList.add(gu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, pstmt, conn);
		}
	
		return guList;
	}
	

	@Override
	public List<Code> getDongList() throws SQLException {
		List<Code> dongList = new ArrayList<Code>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnect();
			String sql = "SELECT * \n";
			sql += "FROM dongcode \n";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Code gu = new Code();
				gu.setName(rs.getString("dong"));
				gu.setDongCode(rs.getString("dongcode"));
				dongList.add(gu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, pstmt, conn);
		}
	
		return dongList;
	}


}
