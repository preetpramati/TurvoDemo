package com.fk.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fk.dao.IInventoryDAO;
import com.fk.dto.ProductDTO;
import com.fk.dto.ProductListResponseDTO;


public interface IInventoryService {
	
	public ProductListResponseDTO getAllProducts(Long id);
	
}
