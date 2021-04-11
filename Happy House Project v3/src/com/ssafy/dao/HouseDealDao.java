package com.ssafy.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.dto.HouseDealDto;

public interface HouseDealDao {
	public List<HouseDealDto> searchAll(String dongCode) throws SQLException;

	public HouseDealDto search(int no) throws SQLException;
}
