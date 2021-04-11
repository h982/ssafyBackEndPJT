package com.ssafy.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.dto.HouseDealDto;

public interface HouseDealService {
	
	public List<HouseDealDto> searchAll(String dongcode) throws Exception;

	public HouseDealDto search(int no) throws Exception;
}
