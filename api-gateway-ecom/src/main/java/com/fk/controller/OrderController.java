package com.fk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fk.dto.OrderDTO;
import com.fk.service.OrderService;



@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value="/order", method = RequestMethod.POST)
    public Boolean validate(@RequestBody OrderDTO order) {
	 
	 Boolean isValid = orderService.validate(order);
	 
      return isValid;
    }

}
