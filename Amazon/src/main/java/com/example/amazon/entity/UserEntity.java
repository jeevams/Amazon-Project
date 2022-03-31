package com.example.amazon.entity;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "users")
public class UserEntity  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private Integer userid;

	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@Column(name = "phonenumber", nullable = false, unique = true)
	private Long phonenumber;


	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "user_orders", 
			joinColumns = @JoinColumn(name = "user_ids"), 
			inverseJoinColumns = @JoinColumn(name = "pro_ids"))
	private Set<ProductEntity> pro;



	public Set<ProductEntity> getPro() {
		return pro;
	}


	public void setPro(Set<ProductEntity> pro) {
		this.pro = pro;
	}


	public Long getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(Long phonenumber) {
		this.phonenumber = phonenumber;
	}


	public Integer getUserid() {
		return userid;
	}


	public void setUserid(Integer userid) {
		this.userid = userid;
	}








	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}




}   