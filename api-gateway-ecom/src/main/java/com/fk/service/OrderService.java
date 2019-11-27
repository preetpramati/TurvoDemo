package com.fk.service;

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
import com.fk.utils.FKUtils;

@Service
public class OrderService {

	String OAUTH_URL="http://10.105.183.168:8084/validate";
	
	@Autowired
	FKUtils util;
	
	public Boolean validate(OrderDTO order) {
		// TODO Auto-generated method stub
		ObjectMapper Obj = new ObjectMapper();
		try {
			String isValid = util.sendPost(OAUTH_URL,Obj.writeValueAsString(order));
			System.out.println("isValid: "+isValid);
			if(Boolean.valueOf(isValid))
			{
				// call ordering service
				
				return true;
			}else
			{
				return false;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	
	
	
}
