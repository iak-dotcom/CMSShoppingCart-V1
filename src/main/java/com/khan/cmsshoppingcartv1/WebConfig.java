package com.khan.cmsshoppingcartv1;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    // If you want to specify/override the path
    // @Override
    // public void addViewControllers(ViewControllerRegistry registry) {
    //     registry.addViewController("/").setViewName("home");
    // }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
            .addResourceHandler("/media/**")
            .addResourceLocations("file:/Users/imrankhan/Desktop/CMS Shopping cart-Spring/CMSShoppingCart-v1/cms-shoppingcart-v1/src/main/resources/static/media/");
    }
}
