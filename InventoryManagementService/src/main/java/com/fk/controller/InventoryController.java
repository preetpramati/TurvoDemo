package com.fk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fk.dto.ProductDTO;
import com.fk.service.InventoryService;

@RestController
public class InventoryController {
	
	
	@Autowired
	InventoryService inventoryService;

	
	 
	 @RequestMapping(value="/getProducts", method = RequestMethod.GET )
	    public List<ProductDTO> getMember() {
		 
		 return inventoryService.getAllProducts();
		 
	    }
}
