package com.fk.service;

import org.springframework.stereotype.Service;

import com.fk.dto.OrderDTO;
import com.fk.dto.OrderResponseDTO;

public interface IOrderService {

	public OrderResponseDTO makeOrder(OrderDTO order);
	
}
