package com.example.demo.repository;

import java.awt.print.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository {
	public interface BookRepository extends JpaRepository<Book, Integer>{
		List<Book> findByInnId(Integer innId);
		List<Book> findByPlanId(Integer planId);
		List<Book> findByUserId(Integer userId);
		List<Book> findByInnIdAndPlanId(Integer innId, Integer planId);
		List<Book> findByInnIdAndUserId(Integer innId, Integer userId);
		List<Book> findByPlanIdAndUserId(Integer planId, Integer userId);
		List<Book> findByInnIdAndPlanIdAndUserId(Integer innId, Integer planId, Integer userId);
	}
}
