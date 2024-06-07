package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Review;

public interface ReviewRepository {
	public interface ReviewRepository extends JpaRepository<Review, Integer>{
		List<Review> findByInnId(Integer innId);
	}
}
