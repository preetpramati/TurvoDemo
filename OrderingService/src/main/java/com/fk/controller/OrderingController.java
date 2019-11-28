package com.fk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fk.dto.OrderDTO;
import com.fk.dto.OrderResponseDTO;
import com.fk.service.IOrderService;


@Controller
public class OrderingController {

	@Autowired
	IOrderService orderService;
	
	@RequestMapping(value="/order", method = RequestMethod.POST)
    public OrderResponseDTO validate(@RequestBody OrderDTO order) {
	 
	OrderResponseDTO  response = orderService.makeOrder(order);
	 
      return response;
    }
}
