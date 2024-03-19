package com.khan.cmsshoppingcartv1;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.khan.cmsshoppingcartv1.models.CategoryRepository;
import com.khan.cmsshoppingcartv1.models.PageRepository;
import com.khan.cmsshoppingcartv1.models.data.Category;
import com.khan.cmsshoppingcartv1.models.data.Page;

@ControllerAdvice
public class Common {
    @Autowired
    private PageRepository pageRepo;
    
    @ModelAttribute
    public void sharedData(Model model){
     

        List<Page> pages = pageRepo.findAllByOrderBySortingAsc();
        model.addAttribute("cpages",pages);
    }
}
