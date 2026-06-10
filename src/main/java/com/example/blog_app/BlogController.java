package com.example.blog_app;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    // 一覧表示
    @GetMapping("/blogs")
    public String blogs(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "blogs";
    }
    // 本の登録
    @PostMapping("/blogs")
    public String addBlog(@ModelAttribute BlogForm form) {
        blogService.add(form);
        return "redirect:/blogs";
    }
    // 詳細表示
    @GetMapping("/blogs/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Optional<Blog> blogOpt = blogService.findById(id);
        if(blogOpt.isEmpty()){
            return "redirect:/blogs";
        }
        model.addAttribute("blog", blogOpt.get());
        return "blogs/detail";
    }
    // ブログの編集
    @GetMapping("/blogs/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Optional<Blog> blogOpt = blogService.findById(id);
        if(blogOpt.isEmpty()){
            return "redirect:/blogs";
        }
        Blog blog = blogOpt.get();
        BlogForm form = new BlogForm(null, null);
        form.setTitle(blog.getTitle());
        form.setText(blog.getText());
        model.addAttribute("blogForm", form);
        model.addAttribute("blogId", id);
        return "blogs/edit";
    }
    // 編集の更新
    @PostMapping("/blogs/{id}")
    public String update(@PathVariable Long id, @ModelAttribute BlogForm form) {
        blogService.update(id, form);
        return "redirect:/blogs";
    }
    
}
