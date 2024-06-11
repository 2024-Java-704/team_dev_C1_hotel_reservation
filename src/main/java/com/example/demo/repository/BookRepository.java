package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	//List<Book> findByIdByOrderByasc(Integer id);

	//List<Book> findByInnId(Integer innId);

	List<Book> findByPlanId(Integer planId);

	List<Book> findByUserId(Integer userId);

	//	List<Book> findByInnIdAndPlanId(Integer innId, Integer planId);

	//	List<Book> findByInnIdAndUserId(Integer innId, Integer userId);

	List<Book> findByPlanIdAndUserId(Integer planId, Integer userId);

	//	List<Book> findByInnIdAndPlanIdAndUserId(Integer innId, Integer planId, Integer userId);

	List<Book> findAllByOrderByIdAsc();

	List<Book> findByIdAndPlanId(Integer id, Integer planId);

	List<Book> findByIdAndUserId(Integer id, Integer userId);

	List<Book> findByIdAndPlanIdAndUserId(Integer Id, Integer planId, Integer userId);
}
