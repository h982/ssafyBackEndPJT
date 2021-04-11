package com.ssafy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.HouseDealDto;
import com.ssafy.dto.MemberDto;
import com.ssafy.service.HouseDealServiceImpl;
import com.ssafy.util.DBUtil;

public class HouseDealDaoImpl implements HouseDealDao {
	private static HouseDealDaoImpl instance;
	
	private HouseDealDaoImpl() {}
	
	public static HouseDealDaoImpl getInstance() {
		if(instance == null)
			instance = new HouseDealDaoImpl();
		return instance;
	}
	
	@Override
	public List<HouseDealDto> searchAll(String dongCode) throws SQLException {
		List<HouseDealDto> list = new ArrayList<HouseDealDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnect();
			String sql = "SELECT AptName, dong, dealAmount, area, floor, buildYear, jibun, dealYear, dealMonth, dealDay \n";
			sql += "FROM housedeal ";
			sql += "WHERE dong like ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dongCode);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				HouseDealDto houseDeal= new HouseDealDto();
				houseDeal.setAptName(rs.getString("AptName"));
				houseDeal.setDong(rs.getString("dong"));
				houseDeal.setDealAmount(rs.getString("dealAmount"));
				houseDeal.setArea(rs.getString("area"));
				houseDeal.setFloor(rs.getString("floor"));
				houseDeal.setDealYear(rs.getString("dealYear"));
				houseDeal.setDealMonth(rs.getString("dealMonth"));
				houseDeal.setDealDay(rs.getString("dealDay"));
				houseDeal.setJibun(rs.getString("jibun"));
				
				list.add(houseDeal);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public HouseDealDto search(int no) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
