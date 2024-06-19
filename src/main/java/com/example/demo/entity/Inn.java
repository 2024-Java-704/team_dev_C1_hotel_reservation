package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "inns")
public class Inn {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	private String name;
	@Column(name = "zip_code")
	private String zipCode;
	private String address;
	private String tel;
	@ManyToOne
	@JoinColumn(name = "prefecture_id")
	private Prefecture prefecture;
	@Transient
	private Double rank = 0.0;

	public Inn() {
	}

	public Inn(Category category, String name, String zipCode, String address, String tel, Prefecture prefecture) {
		this.category = category;
		this.name = name;
		this.zipCode = zipCode;
		this.address = address;
		this.tel = tel;
		this.prefecture = prefecture;
	}

	public Inn(Integer id, Category category, String name, String zipCode, String address, String tel,
			Prefecture prefecture) {
		this.id = id;
		this.category = category;
		this.name = name;
		this.zipCode = zipCode;
		this.address = address;
		this.tel = tel;
		this.prefecture = prefecture;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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

	public Prefecture getPrefecture() {
		return prefecture;
	}

	public void setPrefecture(Prefecture prefecture) {
		this.prefecture = prefecture;
	}

	public Double getRank() {
		return rank;
	}

	public void setRank(Double rank) {
		this.rank = rank;
	}

}