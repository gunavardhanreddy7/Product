package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@RestController
public class CategoryController {
	
	@Autowired
	LoadBalancerClient lb;
	
	
	
	public List<Category> getAllTopics() {
		return Arrays.asList(
				new Category("C1","Electronics","Holds the electronic gadgets like phone - tablets"),
				new Category("C2","Clothing","Holds the men and women clothing"),
				new Category("C3","Accessories", "Holds the men and women accessories"),
				new Category("C4","Books", "Holds various genres of books"),
				new Category("C5","Motor vehicles"," Holds the various kinds of motor vechicles")
				
				);
	}
	@RequestMapping("/categories")
	public List<Category> returnAllTopics() {
		
		List<Category> category=getAllTopics();
		/*String s="Department Categories ";
		for(int i=0;i<category.size();i++) {
			Category c=category.get(i);
			System.out.println(c);
			s=s+c;
		}
		*/
		return category;
		
		
	}
	
	
	@RequestMapping("/products")
public Product[] get() throws RestClientException, IOException {
		
		ServiceInstance serviceInstance=lb.choose("PRODUCTS");
		
		System.out.println(serviceInstance.getUri());
		
		String baseUrl=serviceInstance.getUri().toString();
		
		baseUrl=baseUrl+"/products";
		
		RestTemplate restTemplate = new RestTemplate();
		String c = restTemplate.getForObject(baseUrl, String.class);
		Gson gson = new Gson();
		Product[] nameList = gson.fromJson(c, Product[].class);

		//List<Product> list = nameList.getProducts();
		return nameList;
	}
	
	@RequestMapping("/productsdetails/{category}")
	public List<Product> getdeatils(@PathVariable String category) throws RestClientException, IOException {
			List<Product> lp=new ArrayList<>();
			Product[] p=get();
			for(int i=0;i<p.length;i++) {
				if(p[i].getCid().equals(category)) {
					lp.add(p[i]);
				}
			}
			return lp;
			
			
			
			
		}

}
