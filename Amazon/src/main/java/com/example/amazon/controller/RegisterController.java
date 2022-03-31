package com.example.amazon.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.amazon.entity.ProductEntity;
import com.example.amazon.entity.UserEntity;
import com.example.amazon.exception.BusinessException;
import com.example.amazon.services.RegisterServices;

@RestController
@RequestMapping("/amazon")
public class RegisterController {
	@Autowired
	RegisterServices registerServices;



	@PostMapping("/register/user/v1.0")
	public String registerUserDetails(@RequestBody  UserEntity userEntity) {
		registerServices.registerUserDetails(userEntity);
		return "insert successfully";
	}
	
	@PostMapping("/register/user/v1.1")
	public String registerUserDetailsNew(@RequestBody  UserEntity userEntity) throws BusinessException {
		registerServices.registerUserDetailsNew(userEntity);
		return "insert successfully";
	}

	@PostMapping("/register/product")
	public String registerProduct(@RequestBody ProductEntity productEntity) throws BusinessException {
		registerServices.registerProduct(productEntity);
		return "insert successfully";
	}

	@PostMapping("/register/order")
	public String placeOrder(@RequestParam long mobileNumber,@RequestParam String productName) {
		registerServices.placeOrder(productName,mobileNumber);
		return "insert successfully";
	}

	@PostMapping("/fetch/user")
	public Set<UserEntity> getProductData(@RequestParam String productName) {
		return registerServices.getProductData(productName);
	}
	@GetMapping("/username/{username}")
	public  UserEntity getOrdersDetailsByProductName(@PathVariable String username)
	{
		System.out.println(username);
		return registerServices.getOrdersDetails(username);	
	}
	@GetMapping("/phonenumber/{phonenumber}")
	public List<UserEntity> getOrdersDetailsByProductName(@PathVariable Long phonenumber)
	{
		return registerServices.getOrdersDetailsByPhoneNumber(phonenumber);	
	}
	@GetMapping("/userproduct/{username}/{productname}")
	public List<UserEntity> getOrdersDetailsByPhoneNumberAndProductName(@PathVariable String username,@PathVariable  String productname){
		return registerServices.getOrdersDetailsByPhoneNumberAndProductName(username,productname);
	}
	//	@GetMapping("/counts/{username}")
	//	public int getOrdersDetailsOrderCount(@PathVariable String username)
	//	{
	//	    return registerServices.getOrdersDetailsOrderCount(username);	
	//	}
}
