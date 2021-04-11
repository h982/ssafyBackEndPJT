package com.ssafy.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.dto.HouseDealDto;

public class HouseInfoDaoImpl implements HouseInfoDao {
	private static HouseInfoDaoImpl instance;
	
	private HouseInfoDaoImpl() {}
	
	public static HouseInfoDaoImpl getInstance() {
		if(instance == null)
			instance = new HouseInfoDaoImpl();
		return instance;
	}
	
	@Override
	public List<HouseDealDto> searchAll(String type, String value) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HouseDealDto search(int no) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
