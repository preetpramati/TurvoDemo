package com.fk.service.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fk.dao.impl.OrderDao;
import com.fk.dto.OrderDTO;
import com.fk.dto.OrderResponseDTO;
import com.fk.service.IOrderService;
import com.fk.task.InventoryUpdateTask;
import com.fk.utils.Publisher;

@Service
public class OrderService implements IOrderService {

	@Autowired
	Publisher publisher;
	
	@Autowired
	OrderDao orderDAO;
	ExecutorService pool = Executors.newFixedThreadPool(10); 
	
	public OrderResponseDTO makeOrder(OrderDTO order) {
		OrderResponseDTO reponse = new OrderResponseDTO();
          
        Runnable run = new InventoryUpdateTask(order.getProductId()); 
		pool.execute(run);
		
		queuePush(order.getMemberId(), order.getProductId());
		
		return reponse;
	}


	public void queuePush(Long memberID, Long productId)
	{
		StringBuilder msg = new StringBuilder("{");
		msg.append("\"memberID\":");
		msg.append(memberID);
		msg.append("\"productID\":");
		msg.append(productId);
		msg.append("}");
		publisher.produceMsg(msg.toString());
	}
	
}
