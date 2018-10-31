package com.example.demo.service;



import java.util.Map;

import com.example.demo.model.Product;

public interface ProductService {
	public abstract Map<Integer, Product>  getProduct();
}
