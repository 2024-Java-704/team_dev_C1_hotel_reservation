package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Administrator;


	public interface AdministratorRepository extends JpaRepository<Administrator, Integer>{
		List<Administrator> findByNameAndPassword(String name, String password);
	
}
