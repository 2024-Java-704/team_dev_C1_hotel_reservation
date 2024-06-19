package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.HotSpring;

public interface HotSpringRepository extends JpaRepository<HotSpring, Integer> {
	List<HotSpring> findByInnId(Integer id);

}
