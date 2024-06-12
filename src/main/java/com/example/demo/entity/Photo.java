package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "photos")
public class Photo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "inn_id")
	private Inn inn;
	@Column(name = "photo_url")
	private String photoUrl;

	public Photo() {
	}

	public Photo(Inn inn, String photoUrl) {
		this.inn = inn;
		this.photoUrl = photoUrl;
	}

	public Integer getId() {
		return id;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Inn getInn() {
		return inn;
	}

	public void setInn(Inn inn) {
		this.inn = inn;
	}
}
