package com.example.blog_app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;






@Controller
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService){
        this.blogService = blogService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/blogs";
    }
    
    @GetMapping("/blogs/new")
    public String newBlog() {
        return "blogs/new";
    }
    
    @GetMapping("/blogs")
    public String blogs(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "blogs";
    }
    
    @PostMapping("/blogs")
    public String addBlog(@ModelAttribute BlogForm form) {
        blogService.add(form);
        return "redirect:/blogs";
    }
    
}
