package com.example.amazon.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.amazon.entity.ProductEntity;
import com.example.amazon.entity.UserEntity;


@Repository
public interface  ProductRepository extends JpaRepository<ProductEntity, Integer> {


	//@Query(value="select * from products,orders where products.prodid=orders.orderid and products.productname=?1",nativeQuery = true)
	//List<ProductEntity> displaAll(String productname);

	Optional<ProductEntity> findByProductname(String productname);

	List<UserEntity> getOrdersDetailsByProductname(String productname);

	Optional<ProductEntity> existsByproductname(String productname);

	//Optional<ProductEntity> findByProductName(String productname);


}
