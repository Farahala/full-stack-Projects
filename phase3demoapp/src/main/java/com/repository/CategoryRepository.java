package com.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	//List<Category> findByPurchaseDateBetweenAndCategoryIgnoreCase(LocalDate startDate, LocalDate endDate, String category);
}
