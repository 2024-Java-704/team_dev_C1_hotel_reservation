package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "inns")
public class Inn {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "category_id")
	private Integer categoryId;

	@Column(name = "zip_code")
	private String zipCode;

	private String name;

	private String address;

	private String tel;

	@Column(name = "prefecture_id")
	private Integer prefectureId;

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

	public Integer getCategoryId() {
		return categoryId;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public Integer getPrefectureId() {
		return prefectureId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPrefectureId(Integer prefectureId) {
		this.prefectureId = prefectureId;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
