package com.khan.cmsshoppingcartv1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khan.cmsshoppingcartv1.models.PageRepository;
import com.khan.cmsshoppingcartv1.models.data.Page;


@Controller
 @RequestMapping("/")
public class PagesController {

    @Autowired
    private PageRepository pageRepo;

    @GetMapping
    public String home(Model model) {
        
        Page page = pageRepo.findBySlug("home");
        model.addAttribute("page", page);
        
        return "page";
    }
// For login page
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    // This would show the pages in navbar which were created in Admin mode
    @GetMapping("/{slug}")
    public String page(@PathVariable String slug, Model model) {
        
        Page page = pageRepo.findBySlug(slug);

        if (page == null) {
            return "redirect:/";
        }
        
        model.addAttribute("page", page);
        
        return "page";
    }
    
}