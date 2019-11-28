package com.fk.dao;

import com.fk.entity.Order;

public interface IOrderDAO {
	
	public Integer saveOrder(Order order);
	public Integer getCount(Long prodID);
	public Integer updateCount(Long prodID, int count);
}
