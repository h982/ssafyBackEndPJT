package com.ssafy.dto;

public class Code {
	private String dongCode;
	private String name;

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Code [dongCode=" + dongCode + ", name=" + name + "]";
	}

}
