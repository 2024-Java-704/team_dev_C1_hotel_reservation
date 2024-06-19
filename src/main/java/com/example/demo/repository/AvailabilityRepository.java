package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Availability;

public interface AvailabilityRepository extends JpaRepository<Availability, Integer> {
	List<Availability> findByInnId(Integer innId);

	List<Availability> findByNum(Integer num);

	List<Availability> findByInnIdAndNum(Integer innId, Integer num);

}
