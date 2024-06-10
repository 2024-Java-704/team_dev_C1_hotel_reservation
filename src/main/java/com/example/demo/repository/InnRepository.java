package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Inn;

public interface InnRepository extends JpaRepository<Inn, Integer> {
	List<Inn> findByName(String name);

	List<Inn> findByCategoryId(Integer categoryId);

	List<Inn> findByPrefectureId(Integer prefectureId);

	List<Inn> findByNameAndCategoryId(String name, Integer categoryId);

	List<Inn> findByNameAndPrefectureId(String name, Integer prefectureId);

	List<Inn> findByCategoryIdAndPrefectureId(Integer categoryId, Integer prefectureId);

	List<Inn> findByNameAndCategoryIdAndPrefectureId(String name, Integer categoryId, Integer prefectureId);

	List<Inn> findByIdByOrderByasc(Integer id);

	List<Inn> findAllByOrderByasc();
}
