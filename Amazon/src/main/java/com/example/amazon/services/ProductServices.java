package com.example.amazon.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.amazon.entity.ProductEntity;
import com.example.amazon.entity.UserEntity;
import com.example.amazon.repository.ProductRepository;
import com.example.amazon.repository.RegisterRepository;


@Service
public class ProductServices {
	@Autowired
	ProductRepository productRepository;

	@Autowired
	RegisterRepository registerRepository;

	public void insertProductDetails(List<ProductEntity>productentity) {
		productRepository.saveAll(productentity);

	}

	public List<UserEntity> getOrdersDetailsByProductname(String productname) {

		return productRepository.getOrdersDetailsByProductname(productname);
	}

	
}
