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

	private String name;

	private String address;

	@Column(name = "prefecture_id")
	private Integer prefectureId;

	Inn() {

	}

	Inn(Integer categoryId, String name, String address, Integer prefectureId) {
		this.categoryId = categoryId;
		this.name = name;
		this.address = address;
		this.prefectureId = prefectureId;
	}

	Inn(Integer id, Integer categoryId, String name, String address, Integer prefectureId) {
		this.id=id;
		this.categoryId = categoryId;
		this.name = name;
		this.address = address;
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

}
