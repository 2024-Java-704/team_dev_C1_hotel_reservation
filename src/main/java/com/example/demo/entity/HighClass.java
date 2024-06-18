package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "high_classes")
public class HighClass {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "inn_id")
	private Integer innId;

	HighClass() {

	}

	HighClass(Integer id, Integer innId) {
		this.id = id;
		this.innId = innId;
	}

	public HighClass(Integer innId) {
		this.innId = innId;
	}

	public Integer getId() {
		return id;
	}

	public Integer getInnId() {
		return innId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setInnId(Integer innId) {
		this.innId = innId;
	}

}
