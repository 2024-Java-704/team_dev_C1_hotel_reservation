package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "photos")
public class Photo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "inn_id")
	private Integer innId;
	@Column(name = "photo_url")
	private String photoUrl;

	public Photo() {
	}

	public Photo(Integer id, Integer innId, String photoUrl) {
		this.id = id;
		this.innId = innId;
		this.photoUrl = photoUrl;
	}

	public Photo(Integer innId, String photoUrl) {
		this.innId = innId;
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

	public Integer getInnId() {
		return innId;
	}

	public void setInnId(Integer innId) {
		this.innId = innId;
	}
}
