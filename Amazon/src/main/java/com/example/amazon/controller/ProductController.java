package com.example.amazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amazon.entity.ProductEntity;
import com.example.amazon.services.ProductServices;

@RestController
@RequestMapping("/amazon")
public class ProductController {
	@Autowired
	ProductServices productServices;
	@PostMapping("/product")
	public String insertProductDetails(@RequestBody List<ProductEntity>productentity) {
		productServices.insertProductDetails(productentity);
		return "insert product";

	}


}
