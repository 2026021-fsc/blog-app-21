package com.example.blog_app;

import java.util.List;

import org.springframework.stereotype.Service;

import io.micrometer.common.util.StringUtils;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }

    public List<Blog> findAll(){
        return blogRepository.findAll();
    }

    public void add(BlogForm form){
        if(StringUtils.isEmpty(form.getTitle())){
            throw new IllegalArgumentException();
        }else{
            blogRepository.save(new Blog(form.getTitle(), form.getText()));
        }
    }
}
