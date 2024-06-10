package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Date birthday;
	private String address;
	private String tel;
	private String email;
	@Column(name = "zip_code")
	private String zipCode;
	private String password;
	private Date registration;

	public User() {

	}

	public User(Integer id, String name, Date birthday,
			String address, String tel, String email, String zipCode, String password) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.zipCode = zipCode;
		this.password = password;
		setRegistration(registration);

	}

	public User(String name, Date birthday, String address, String tel, String email,
			String zipCode, String password, Date registration) {
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.zipCode = zipCode;
		this.password = password;
		this.registration = registration;
	}
	public User(Integer id,String name, Date birthday, String address, String tel, String email,
			String zipCode,  Date registration) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.zipCode = zipCode;
		this.registration = registration;
	}
	public User(Integer id,String name, Date birthday, String address, String tel, String email,
			String zipCode,  Date registration,String password) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.zipCode = zipCode;
		this.registration = registration;
		this.password=password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegistration() {
		return registration;
	}

	public void setRegistration(Date registration) {
		this.registration = registration;
	}

}
