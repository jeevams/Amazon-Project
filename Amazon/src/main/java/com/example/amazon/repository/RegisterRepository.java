package com.example.amazon.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.amazon.entity.UserEntity;

@Repository
public interface RegisterRepository extends JpaRepository<UserEntity, Integer> {

	

	@Query(value="select * from users inner join  products  on products.prodid=users.userid and users.username=?1",nativeQuery = true)
	UserEntity getOrdersDetails(String username);

	@Query(value="select * from users,products where products.prodid=users.userid and users.phonenumber=?1",nativeQuery = true)
	List<UserEntity> getOrdersDetailsByPhoneNumber(String phoneno);
	
	@Query(value="select * from users,products where  users.username=?1 and products.productname=?2",nativeQuery = true)
	List<UserEntity> getOrdersDetailsByPhoneNumberAndProductName(String username,String productname);
	
	Optional<UserEntity> findByPhonenumber(Long phonenumber);

	Optional<UserEntity> existsByusername(String username);

	//Optional<UserEntity> existsByusername(String username);
	
	
}
