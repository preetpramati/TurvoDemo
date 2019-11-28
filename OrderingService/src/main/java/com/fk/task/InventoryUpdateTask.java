package com.fk.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fk.dao.impl.OrderDao;

@Component
public class InventoryUpdateTask implements Runnable{

	
	@Autowired
	OrderDao orderDAO;
	
	Long prodID;
	
	public InventoryUpdateTask(Long prodID)
	{
		this.prodID = prodID;
	}
	
	@Override
	public void run() {
		checkAndUpdateInventory();
		
	}
	
	synchronized public void checkAndUpdateInventory()
	{
		int count = orderDAO.getCount(prodID);
		if(count > 0)
		{
			count--;
			orderDAO.updateCount(prodID, count);
		}
	}
	
}
