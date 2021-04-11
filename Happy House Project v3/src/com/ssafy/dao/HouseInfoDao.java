package com.ssafy.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.dto.HouseDealDto;

public interface HouseInfoDao {
	public List<HouseDealDto> searchAll(String type, String value) throws SQLException;

	public HouseDealDto search(int no) throws SQLException;
}
