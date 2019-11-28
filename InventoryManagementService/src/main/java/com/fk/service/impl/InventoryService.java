package com.fk.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fk.dao.IInventoryDAO;
import com.fk.dto.MemberDTO;
import com.fk.dto.ProductDTO;
import com.fk.dto.ProductListResponseDTO;
import com.fk.service.IInventoryService;
import com.fk.utils.FKUtils;

@Service
public class InventoryService implements IInventoryService{

	String DETAILS_URL="http://oauth-service:8084/getDetails/";
	@Autowired
	IInventoryDAO inventoryDAO;


	public ProductListResponseDTO getAllProducts(Long id) {
		// TODO Auto-generated method stub
		ProductListResponseDTO response = new ProductListResponseDTO();
		try {
			
			String getResponse = FKUtils.sendGet(DETAILS_URL+id);
			ObjectMapper mapper = new ObjectMapper();
			MemberDTO member = mapper.readValue(getResponse, MemberDTO.class);
			if(member.isRegisteredForSale())
			{
				
				response.setProdList( inventoryDAO.findAll());
				response.setStatus(1);
				response.setDesc("Sucess");
			}else {
				response.setStatus(2);
				response.setDesc("Member not registered for sale.");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setStatus(0);
			response.setDesc("Cant ful fill request at the moment.");
		}
		return response;
	}
	
	
	
}
