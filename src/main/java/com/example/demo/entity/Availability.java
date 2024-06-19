package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "availabilities")
public class Availability {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "inn_id")
	private Integer innId;

	private Integer num;

	Availability() {

	}

	Availability(Integer id, Integer innId, Integer num) {
		this.id = id;
		this.innId = innId;
		this.num = num;
	}

	Availability(Integer innId, Integer num) {
		this.innId = innId;
		this.num = num;
	}

	public Integer getId() {
		return id;
	}

	public Integer getInnId() {
		return innId;
	}

	public Integer getNum() {
		return num;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setInnId(Integer innId) {
		this.innId = innId;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

}
