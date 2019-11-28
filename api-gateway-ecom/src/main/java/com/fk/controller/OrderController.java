package com.fk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fk.dto.OrderDTO;
import com.fk.service.IOrderService;



@RestController
public class OrderController {
	
	@Autowired
	IOrderService orderService;
	
	@RequestMapping(value="/order", method = RequestMethod.POST)
    public OrderDTO validate(@RequestBody OrderDTO order) {
	 
		OrderDTO response = orderService.makeOrder(order);
	 
      return response;
    }

}
