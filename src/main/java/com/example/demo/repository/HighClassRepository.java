package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.HighClass;

public interface HighClassRepository extends JpaRepository<HighClass, Integer> {
	List<HighClass> findByInnId(Integer id);

}
