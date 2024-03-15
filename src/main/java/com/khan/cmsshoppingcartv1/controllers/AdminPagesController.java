package com.khan.cmsshoppingcartv1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khan.cmsshoppingcartv1.models.PageRepository;
import com.khan.cmsshoppingcartv1.models.data.Page;

@Controller
@RequestMapping("/admin/pages")
public class AdminPagesController {

@Autowired
private PageRepository pageRepo;

    @GetMapping
    public String index(Model model){
        List<Page> pages= pageRepo.findAll();
        model.addAttribute("pages", pages);
        return "admin/pages/index";
    }
}
