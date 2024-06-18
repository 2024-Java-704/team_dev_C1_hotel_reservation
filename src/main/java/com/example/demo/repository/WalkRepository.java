package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Walk;

public interface WalkRepository extends JpaRepository<Walk, Integer> {
	List<Walk> findByInnId(Integer id);

}
