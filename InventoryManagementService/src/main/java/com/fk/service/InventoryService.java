package com.fk.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fk.dao.InventoryDAO;
import com.fk.dto.ProductDTO;

@Service
public class InventoryService {

	@Autowired
	InventoryDAO inventoryDAO;


	public List<ProductDTO> getAllProducts() {
		// TODO Auto-generated method stub
		return inventoryDAO.findAll();
	}
	
	
	
}
