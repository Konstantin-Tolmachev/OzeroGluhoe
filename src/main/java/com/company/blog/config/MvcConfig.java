package com.company.blog.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class MvcConfig implements WebMvcConfigurer {

public void addViewControllers(ViewControllerRegistry registry) {

  registry.addViewController("/Authorization").setViewName("HomeHTML/authorization");
  registry.addViewController("/AdminHome").setViewName("AdminHTML/adminHome");
  registry.addViewController("/StaffAccount").setViewName("StaffHTML/staffAccount");
  registry.addViewController("/MyAccount").setViewName("ClientHTML/myAccount");





    }

}


/*

 */


/*

package com.company.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/news").setViewName("news");
    }
}


 */
