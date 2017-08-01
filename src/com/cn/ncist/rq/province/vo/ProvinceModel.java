package com.cn.ncist.rq.province.vo;

public class ProvinceModel {
	private Integer province_id ;
	private String province_name ;
	private Integer nation_id ;
	
	private String nation_name ;
	
	public Integer getProvince_id() {
		return province_id;
	}
	public void setProvince_id(Integer provinceId) {
		province_id = provinceId;
	}
	public String getProvince_name() {
		return province_name;
	}
	public void setProvince_name(String provinceName) {
		province_name = provinceName;
	}
	public Integer getNation_id() {
		return nation_id;
	}
	public void setNation_id(Integer nationId) {
		nation_id = nationId;
	}
	public String getNation_name() {
		return nation_name;
	}
	public void setNation_name(String nationName) {
		nation_name = nationName;
	}
	
}