package com.example.amazon.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prodid")
	private Integer prodid;
	@Column(name = "productname", nullable = false)
	private String productname;
	@Column(name = "price", nullable = false)
	private Integer price;

	public Set<UserEntity> getUser() {
		return user;
	}
	public void setPro(Set<UserEntity> users) {
		this.user = users;
	}
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "pro")
	private Set<UserEntity> user;

	public Integer getProdid() {
		return prodid;
	}
	public void setProdid(Integer prodid) {
		this.prodid = prodid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}



}
