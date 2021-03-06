package com.example.demo;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
  
	public List<Product> getAllTopics() {
		return Arrays.asList(
				new Product("C1","P1","Apple "," Mobile device"),
				new Product("C1","P2","Samsung "," Mobile device"),
				new Product("C1","P3","One plus "," Mobile device"),
				new Product("C2","P2","Gap Shirt"," Men shirt"),
				new Product("C2","P1","Banana Republic Shirt"," Men shirt"),
				new Product("C3","P3"," Apple Watch " , " Men watch"),
				new Product("C3","P4"," Samsung Watch " , " Men watch"),
				new Product("C4","P4"," Harry Porter ", " Drama book"),
				new Product("C4","P5"," Physics ", " class book"),
				new Product("C5","P5", " Tesla car "," Electric Car"),
				new Product("C5","P6", " Audi car "," Fuel Car")
				
				);
	}
	@RequestMapping(value="/products",produces="application/json")
	public List<Product> returnAllTopics() {
		
		List<Product> category=getAllTopics();
	/*	String s="    Products         ";
		for(int i=0;i<category.size();i++) {
			Product c=category.get(i);
			System.out.println(c);
			s=s+c;
		}
	*/	return category;
		
		
	}
	@RequestMapping(value="/productsdetails",produces="application/json")
	public Product returnTopics() {
		
		List<Product> category=getAllTopics();
	/*	String s="    Products         ";
		*/for(int i=0;i<category.size();i++) {
			Product c=category.get(i);
			
		}
		return category.get(0);
		
		
	}
}

