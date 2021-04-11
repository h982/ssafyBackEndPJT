package com.ssafy.service;

import java.util.List;

import com.ssafy.dao.CodeDaoImpl;
import com.ssafy.dto.Code;

public class CodeServiceImpl implements CodeService {
	private static CodeServiceImpl instance;
	
	private CodeServiceImpl() {}
	
	public static CodeServiceImpl getInstance() {
		if(instance == null)
			instance = new CodeServiceImpl();
		return instance;
	}

	@Override
	public List<Code> getCityList() throws Exception {
		return CodeDaoImpl.getInstance().getSidoList();
	}

	@Override
	public List<Code> getGuList() throws Exception {
		return CodeDaoImpl.getInstance().getGuList();
	}

	@Override
	public List<Code> getDongList() throws Exception {
		return CodeDaoImpl.getInstance().getDongList();
	}

	

}
