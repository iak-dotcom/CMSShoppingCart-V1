package com.khan.cmsshoppingcartv1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khan.cmsshoppingcartv1.models.CategoryRepository;
import com.khan.cmsshoppingcartv1.models.data.Category;

@Controller
@RequestMapping("/admin/categories")
public class AdminCategoriesController {
    
    @Autowired
    private CategoryRepository categoryRepo;
@GetMapping
    public String index(Model model) {
        
        List<Category> categories = categoryRepo.findAllByOrderBySortingAsc();

        model.addAttribute("categories", categories);

        return "admin/categories/index";
    }


}
