package com.fk.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fk.dao.IInventoryDAO;
import com.fk.dto.ProductDTO;

@Repository
public class InventoryDAO implements IInventoryDAO{

	@Autowired
    JdbcTemplate jdbcTemplate;
	

	public List<ProductDTO> findAll() {
		return jdbcTemplate.query(
                "select * from Inventory",
                (rs, rowNum) ->
                        new ProductDTO(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getString("s3URL"),
                                rs.getLong("availableCount")
                        )
        );
	}
	
	
}
