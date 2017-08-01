package com.cn.ncist.rq.destination.vo;

public class DestinationModel {
	private Integer destination_id ;
	private String destination_name ;
	private String destination_pinyin ;
	private Integer destination_number ;
	private Integer nation_id ;
	private Integer province_id ;
	private String destination_img ;
	private String destination_imgarr ;
	private String destination_desc ;
	
	private String province_name ;
	private String nation_name ;
	
	public Integer getDestination_id() {
		return destination_id;
	}
	public void setDestination_id(Integer destinationId) {
		destination_id = destinationId;
	}
	public String getDestination_name() {
		return destination_name;
	}
	public void setDestination_name(String destinationName) {
		destination_name = destinationName;
	}
	public String getDestination_pinyin() {
		return destination_pinyin;
	}
	public void setDestination_pinyin(String destinationPinyin) {
		destination_pinyin = destinationPinyin;
	}
	public Integer getDestination_number() {
		return destination_number;
	}
	public void setDestination_number(Integer destinationNumber) {
		destination_number = destinationNumber;
	}
	public String getDestination_img() {
		return destination_img;
	}
	public void setDestination_img(String destinationImg) {
		destination_img = destinationImg;
	}
	public String getDestination_imgarr() {
		return destination_imgarr;
	}
	public void setDestination_imgarr(String destinationImgarr) {
		destination_imgarr = destinationImgarr;
	}
	public String getDestination_desc() {
		return destination_desc;
	}
	public void setDestination_desc(String destinationDesc) {
		destination_desc = destinationDesc;
	}
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
