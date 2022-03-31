package com.example.amazon.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.amazon.entity.ProductEntity;
import com.example.amazon.entity.UserEntity;
import com.example.amazon.exception.BusinessException;
import com.example.amazon.exception.BusinessExceptionReason;
import com.example.amazon.repository.ProductRepository;
import com.example.amazon.repository.RegisterRepository;

@Service
public class RegisterServices {
	//private static final BusinessExceptionReason "" = null;

	@Autowired
	RegisterRepository registerRepository;

	@Autowired
	ProductRepository productRepository;
	
	public void registerUserDetails(UserEntity userEntity) {
		registerRepository.save(userEntity);
		
	}


	public void registerUserDetailsNew(UserEntity userEntity)throws BusinessException {
		String username=userEntity.getUsername();
		Optional<UserEntity>op=registerRepository.existsByusername(username);
		if(op.isPresent()) {
			throw new BusinessException(BusinessExceptionReason.USER_NAME_ALREADY_REGSITER.name(),
					
					BusinessExceptionReason.USER_NAME_ALREADY_REGSITER);
			

		}
		else {
			registerRepository.save(userEntity);
		}

	}

	public void registerProduct(ProductEntity productEntity)throws BusinessException {
		String productname=productEntity.getProductname();
		Optional<ProductEntity>op=productRepository.existsByproductname(productname);
		System.out.println(productname);
		
		System.out.println(op.isPresent());
		if(op.isPresent()==true) {
			
			throw new BusinessException(BusinessExceptionReason.PRODUCT_NAME_ALREADY_REGSITER.name(),
					BusinessExceptionReason.PRODUCT_NAME_ALREADY_REGSITER);
		
		}
		else {
		  productRepository.save(productEntity);
		}

	}

	public Set<UserEntity> getProductData(String productName) {
		Optional<ProductEntity> productOpt = productRepository.findByProductname(productName);
		if(productOpt.isPresent()) {
			ProductEntity productEntity = productOpt.get();
			return productEntity.getUser();
		}
		return null;
	}

	public void placeOrder(String productName,long mobileNumber) {
		Optional<UserEntity> userOpt = registerRepository.findByPhonenumber(mobileNumber);
		if(userOpt.isPresent()) {
			UserEntity userEntity = userOpt.get();

			Optional<ProductEntity> productOpt = productRepository.findByProductname(productName);

			if(productOpt.isPresent()) {

				ProductEntity productEntity = productOpt.get();


				Set<ProductEntity> productSet = userEntity.getPro();

				productSet.add(productEntity);

				userEntity.setPro(productSet);

				productRepository.save(productEntity);
			}
		}
	}

	public  UserEntity getOrdersDetails(String username) {
		// TODO Auto-generated method stub
		return registerRepository.getOrdersDetails(username);
	}

	public List<UserEntity>  getOrdersDetailsByPhoneNumber(Long phonenumber) {
		String phoneno=phonenumber.toString();
		return registerRepository.getOrdersDetailsByPhoneNumber(phoneno);
	}
	public List<UserEntity> getOrdersDetailsByPhoneNumberAndProductName(String username,String productname){
		return registerRepository.getOrdersDetailsByPhoneNumberAndProductName(username,productname);
	}


	//	public int  getOrdersDetailsOrderCount(String username) {
	//		// TODO Auto-generated method stub
	//		UserEntity al=registerRepository.getOrdersDetails(username);
	//		int  count=al.getPro().size();
	//
	//		return count;
	//	}


	// TODO Auto-generated method stub



	/*	public void registerUserDetails(UserEntity userEntity) {
		String key = 
		String password = "password";

		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword(password);
		String encrypted= encryptor.encrypt(key);
         userEntity.setPassword(encrypted);

         String seed = "password";
        // String pass = userEntity.getPassword();

         StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
         encryptor.setPassword(seed);
         String encrypted= encryptor.encrypt(pass);
         System.out.println("encoding="+encrypted);
       //  userEntity.setPassword(encrypted);

         String seeds = "password";
         StandardPBEStringEncryptor encryptors = new StandardPBEStringEncryptor();
         encryptors.setPassword(seeds);

       //  String decrypted = encryptors.decrypt(userEntity.getPassword());

         System.out.println("decoding"+decrypted);
        registerRepository.save(userEntity);

	}*/

	//public List<UserEntity> getOrdersDetailsByPhoneNumber(String phonenumber) {
	//return registerRepository.getOrdersDetailsByPhoneNumber(phonenumber);
	//	}



}

