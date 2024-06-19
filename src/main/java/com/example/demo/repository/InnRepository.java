package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Inn;

public interface InnRepository extends JpaRepository<Inn, Integer> {

	List<Inn> findAllByOrderByIdAsc();

	List<Inn> findByNameContainingOrAddressContaining(String keyword, String keyword2);

	List<Inn> findByPrefectureId(Integer peruIntegerId);

	List<Inn> findByCategoryId(Integer categoryId);

	List<Inn> findByPrefectureIdAndCategoryId(Integer prefectureId, Integer categoryId);

	List<Inn> findByNameContainingOrAddressContainingAndPrefectureId(String keyword, String keyword2,
			Integer prefectureId);

	List<Inn> findByNameContainingOrAddressContainingAndCategoryId(String keyword, String keyword2,
			Integer categoryId);

	List<Inn> findByNameContainingOrAddressContainingAndPrefectureIdAndCategoryId(String keyword, String keyword2,
			Integer prefectureId, Integer categoryId);

	@Query("SELECT e FROM Inn e WHERE e.id = (SELECT MAX(e2.id) FROM Inn e2)")
	Optional<Inn> findLastInserted();
}
