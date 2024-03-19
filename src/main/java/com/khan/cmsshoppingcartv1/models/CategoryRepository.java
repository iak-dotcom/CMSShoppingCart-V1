package com.khan.cmsshoppingcartv1.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khan.cmsshoppingcartv1.models.data.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // For the PostMethod
    Category findByName(String name);

    // For Sorting
    List<Category> findAllByOrderBySortingAsc();

    //For Categories Controller
    Category findBySlug(String slug);
    
}