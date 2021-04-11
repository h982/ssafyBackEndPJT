package com.ssafy.service;

import java.util.List;

import com.ssafy.dao.HouseDealDaoImpl;
import com.ssafy.dto.HouseDealDto;

public class HouseDealServiceImpl implements HouseDealService {
	private static HouseDealServiceImpl instance;
	
	private HouseDealServiceImpl() {}
	
	public static HouseDealServiceImpl getInstance() {
		if(instance == null)
			instance = new HouseDealServiceImpl();
		return instance;
	}
	
	@Override
	public List<HouseDealDto> searchAll(String dongCode) throws Exception {
		return HouseDealDaoImpl.getInstance().searchAll(dongCode);
	}

	@Override
	public HouseDealDto search(int no) throws Exception {
		return null;
	}

}
