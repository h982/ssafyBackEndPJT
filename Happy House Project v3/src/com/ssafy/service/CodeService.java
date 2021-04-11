package com.ssafy.service;

import java.util.List;

import com.ssafy.dto.Code;

public interface CodeService {
	public List<Code> getCityList() throws Exception;
	
	public List<Code> getGuList() throws Exception;

	public List<Code> getDongList() throws Exception;

}
