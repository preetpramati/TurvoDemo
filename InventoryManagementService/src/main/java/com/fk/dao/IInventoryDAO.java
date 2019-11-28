package com.fk.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fk.dto.ProductDTO;

public interface IInventoryDAO {

	public List<ProductDTO> findAll();
	
	
}
