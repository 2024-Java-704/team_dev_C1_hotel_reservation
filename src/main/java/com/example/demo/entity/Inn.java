package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "inns")
public class Inn {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "category_id")
	private Integer categoryId;
	private String name;
	@Column(name = "zip_code")
	private String zipCode;
	private String address;
	private String tel;
	@Column(name = "prefectureId")
	private Integer prefectureId;
	@Transient
	private Double rank = 0.0;

	public Inn() {
	}

	public Inn(Integer categoryId, String name, String zipCode, String address, String tel, Integer prefectureId) {
		this.categoryId = categoryId;
		this.name = name;
		this.zipCode = zipCode;
		this.address = address;
		this.tel = tel;
		this.prefectureId = prefectureId;
	}

	public Inn(Integer id, Integer categoryId, String name, String zipCode, String address, String tel,
			Integer prefectureId) {
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.zipCode = zipCode;
		this.address = address;
		this.tel = tel;
		this.prefectureId = prefectureId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
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

	public Integer getPrefectureId() {
		return prefectureId;
	}

	public void setPrefectureId(Integer prefectureId) {
		this.prefectureId = prefectureId;
	}

	public Double getRank() {
		return rank;
	}

	public void setRank(Double rank) {
		this.rank = rank;
	}

}