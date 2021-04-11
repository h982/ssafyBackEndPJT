package com.ssafy.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.dto.HouseDealDto;

public interface HouseInfoService {
	
	// 아파트 별, 동 별 다르게 
	public List<HouseDealDto> searchAll(String type, String value) throws Exception;

	public HouseDealDto search(int no) throws Exception;
}
