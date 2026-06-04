package com.example.blog_app;

import java.util.List;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class BlogRepository {
    private final JdbcClient jdbcClient;

    public BlogRepository(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    public List<Blog> findAll(){
        return jdbcClient.sql("SELECT * FROM blogs")
            .query(Blog.class)
            .list();
    }

    public void save(Blog blog){
        jdbcClient.sql("INSERT INTO blogs(title, text) VALUES (:title, :text)")
            .param("title", blog.getTitle())
            .param("text", blog.formattedText())
            .update();
    }
}
