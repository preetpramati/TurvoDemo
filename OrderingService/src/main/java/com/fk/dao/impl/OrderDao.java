package com.fk.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fk.dao.IOrderDAO;
import com.fk.entity.Order;

@Repository
public class OrderDao implements IOrderDAO {

	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@Override
	public Integer saveOrder(Order order)
	{
		return 0;
	}

	@Override
	public Integer getCount(Long prodID) {

		return jdbcTemplate.queryForObject("select availableCount from Inventory where id = ?",
                new Object[]{prodID}, Integer.class);
		
	    }
		
		
	@Override
	public Integer updateCount(Long prodID, int count) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(
                "update Inventory set availableCount = ? where id = ?",
                count, prodID);
	}
	

}
