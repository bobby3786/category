package com.bobby.category.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.bobby.category.entity.Category;

import jakarta.transaction.Transactional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	Optional<Category> findByName(String name);
	
	@Transactional
	@Modifying
	void deleteByName(String name);

}
