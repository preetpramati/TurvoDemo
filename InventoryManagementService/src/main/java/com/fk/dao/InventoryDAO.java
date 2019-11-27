package com.fk.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fk.dto.ProductDTO;

@Repository
public class InventoryDAO {

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
