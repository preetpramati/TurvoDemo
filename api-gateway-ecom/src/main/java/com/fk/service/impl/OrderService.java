package com.fk.service.impl;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fk.dto.OrderDTO;
import com.fk.dto.OrderResponseDTO;
import com.fk.service.IOrderService;
import com.fk.utils.FKUtils;

@Service
public class OrderService implements IOrderService {

	String OAUTH_URL="http://oauth-service:8084/validate";
	String ORDER_SERVICE_URL = "http://ordering-service:8085/order";
	
	@Autowired
	FKUtils util;
	
	public OrderDTO makeOrder(OrderDTO order) {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		OrderDTO response = new OrderDTO();
		try {
			String isValid = util.sendPost(OAUTH_URL,mapper.writeValueAsString(order));
			System.out.println("isValid: "+isValid);
			if(Boolean.valueOf(isValid))
			{
				// call ordering service
				String orderResponse = util.sendPost(ORDER_SERVICE_URL,mapper.writeValueAsString(order));
				OrderResponseDTO orderResponseDTO = mapper.readValue(orderResponse, OrderResponseDTO.class);
				if(orderResponseDTO.getStatus() == 1)
				{
					response.setDescription("Order Sucessfull");
					response.setStatus(1);
				}else {
					response.setDescription(orderResponseDTO.getDesc());
					response.setStatus(2);

				}
			}else
			{
				response.setDescription("Member token invalid or not registered to Flash Sale");
				response.setStatus(2);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setDescription("Cant full fill request at the moment");
			response.setStatus(0);
		}
		return response;

	}
	
}
