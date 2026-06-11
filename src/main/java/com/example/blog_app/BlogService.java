package com.example.blog_app;

import java.util.List;
import java.util.Optional;

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
    // 追加
    public void add(BlogForm form){
        if(StringUtils.isEmpty(form.getTitle())){
            throw new IllegalArgumentException();
        }else{
            blogRepository.save(new Blog(null, form.getTitle(), form.getText()));
        }
    }
    // id探索
    public Optional<Blog> findById(Long id){
        return blogRepository.findById(id);
    }
    // 更新
    public void update(Long id, BlogForm form){
        blogRepository.update(id, form.getTitle(), form.getText());
    }
}