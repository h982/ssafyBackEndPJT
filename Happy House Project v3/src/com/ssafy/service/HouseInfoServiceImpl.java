package com.ssafy.service;

import java.util.List;

import com.ssafy.dto.HouseDealDto;

public class HouseInfoServiceImpl implements HouseInfoService {
	private static HouseInfoServiceImpl instance;
	
	private HouseInfoServiceImpl() {}
	
	public static HouseInfoServiceImpl getInstance() {
		if(instance == null)
			instance = new HouseInfoServiceImpl();
		return instance;
	}
	@Override
	public List<HouseDealDto> searchAll(String type, String value) throws Exception {
		
		return null;
	}

	@Override
	public HouseDealDto search(int no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
