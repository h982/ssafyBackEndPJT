package com.ssafy.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.dto.Code;

public interface CodeDao {
	public List<Code> getSidoList() throws SQLException;
	
	public List<Code> getGuList() throws SQLException;

	public List<Code> getDongList() throws SQLException;
}