package com.example.demo.entity;

public class Plan {
	private Integer id;
	private Integer innId;
	private String name;
	private Integer price;

	public Plan() {

	}

	public Plan(Integer innId, String name, Integer price) {
		this.innId = innId;
		this.name = name;
		this.price = price;
	}

	public Plan(Integer id, Integer innId, String name, Integer price) {
		this.id = id;
		this.innId = innId;
		this.name = name;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInnId() {
		return innId;
	}

	public void setInnId(Integer innId) {
		this.innId = innId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
