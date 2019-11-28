package com.fk.utils;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

@Component
public class FKUtils {
	
	public static String sendPost(String url, String body) throws IOException {

		String result = "";
        HttpPost post = new HttpPost(url);


        // send a JSON data
        post.setEntity(new StringEntity(body));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            result = EntityUtils.toString(response.getEntity());
        }

        return result;
	}
	
	public static String sendGet(String url) throws IOException {

		String result = "";
        HttpGet get = new HttpGet(url);


        // send a JSON data
       // post.setEntity(new StringEntity(body));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(get)) {

            result = EntityUtils.toString(response.getEntity());
        }

        return result;
	}

}
