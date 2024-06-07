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
	
	@Column(name="inn_id")
	private Integer innId;
	
	@Column(name="photo_id")
	private Integer photoId;

	public Integer getId() {
		return id;
	}

	public Integer getInnId() {
		return innId;
	}

	public Integer getPhotoId() {
		return photoId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setInnId(Integer innId) {
		this.innId = innId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

}
