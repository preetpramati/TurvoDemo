package com.fk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fk.dto.ProductDTO;
import com.fk.dto.ProductListResponseDTO;
import com.fk.service.IInventoryService;

@RestController
public class InventoryController {
	
	
	@Autowired
	IInventoryService inventoryService;

	
	 @RequestMapping(value="/getProducts/{memberid}", method = RequestMethod.GET )
	    public ProductListResponseDTO getMember(@PathVariable("memberid") Long id) {
		 ProductListResponseDTO response = inventoryService.getAllProducts(id);
		 return response;
		 
	    }
}
