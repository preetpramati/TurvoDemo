package com.fk.dto;

public class ProductDTO {

	
	Long id;
	String name;
	String s3URL;
	Long avaiableCount;
	

	public ProductDTO(Long id, String name, String s3URL, Long avaiableCount)
	{
		this.id = id;
		this.name = name;
		this.s3URL = s3URL;
		this.avaiableCount = avaiableCount;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getS3URL() {
		return s3URL;
	}


	public void setS3URL(String s3url) {
		s3URL = s3url;
	}


	public Long getAvaiableCount() {
		return avaiableCount;
	}


	public void setAvaiableCount(Long avaiableCount) {
		this.avaiableCount = avaiableCount;
	}
	
}
