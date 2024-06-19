package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Inn;

public interface InnRepository extends JpaRepository<Inn, Integer> {
	List<Inn> findByName(String name);

	List<Inn> findByCategoryId(Integer categoryId);

	List<Inn> findByPrefectureId(Integer prefectureId);

	List<Inn> findByNameAndCategoryId(String name, Integer categoryId);

	List<Inn> findByNameAndPrefectureId(String name, Integer prefectureId);

	List<Inn> findByCategoryIdAndPrefectureId(Integer categoryId, Integer prefectureId);

	List<Inn> findByNameAndCategoryIdAndPrefectureId(String name, Integer categoryId, Integer prefectureId);

	List<Inn> findAllByOrderByIdAsc();

	List<Inn> findByNameLike(String string);

	List<Inn> findByNameContainingOrAddressContaining(String keyword, String keyword2);

	@Query("SELECT e FROM Inn e WHERE e.id = (SELECT MAX(e2.id) FROM Inn e2)")
	Optional<Inn> findLastInserted();
}
