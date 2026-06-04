package com.example.blog_app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class BlogController {
    @GetMapping("/")
    public String blogs() {
        return "blogs";
    }
    
    @GetMapping("/blogs/new")
    public String newBlog() {
        return "blogs/new";
    }
    
    @PostMapping("/blogs")
    public String create(@ModelAttribute BlogForm form) {
        
        return "redirect:/blogs";
    }
    
}
