package com.fk.dto;

import java.util.List;

public class ProductListResponseDTO {
	
	List<ProductDTO> prodList;
	String desc;
	Integer status;
	public List<ProductDTO> getProdList() {
		return prodList;
	}
	public void setProdList(List<ProductDTO> prodList) {
		this.prodList = prodList;
	}
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	
}
