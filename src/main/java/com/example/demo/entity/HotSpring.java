package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hot_springs")
public class HotSpring {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "inn_id")
	private Integer innId;
	
	public HotSpring() {
	}
	
	public HotSpring(Integer id, Integer innId) {
		this.id=id;
		this.innId=innId;
	}
	
	public HotSpring(Integer innId) {
		this.innId=innId;
	}

	public Integer getId() {
		return id;
	}

	public Integer getInn() {
		return innId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setInn(Integer innId) {
		this.innId = innId;
	}
	
	

}
