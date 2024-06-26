package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String content;
	@Column(name = "rank_id")
	private Integer rankId;
	@Column(name = "inn_id")
	private Integer innId;

	public Review() {

	}

	public Review(String content, Integer rankId, Integer innId) {
		this.content = content;
		this.rankId = rankId;
		this.innId = innId;
	}

	public Review(Integer id, String content, Integer rankId, Integer innId) {
		this.id = id;
		this.content = content;
		this.rankId = rankId;
		this.innId = innId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getRankId() {
		return rankId;
	}

	public void setRankId(Integer rankId) {
		this.rankId = rankId;
	}

	public Integer getInnId() {
		return innId;
	}

	public void setInnId(Integer innId) {
		this.innId = innId;
	}

}
