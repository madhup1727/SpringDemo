package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;


import org.springframework.stereotype.Service;

import com.example.demo.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	private static Map<Integer, Product> productRepo = new HashMap<>();
	
	static {
		Product p1 = new Product();
		p1.setId(1);
		p1.setDisplayName("1");
		productRepo.put(p1.getId(), p1);
		
		Product p2 = new Product();
		p2.setId(2);
		p2.setDisplayName("2");
		productRepo.put(p2.getId(), p2);
	}
	
	
	
	@Override
	public Map<Integer, Product>  getProduct() {
		return productRepo;
	}

}
