package com.example.blog_app;

import java.util.List;
import java.util.Optional;

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
    // 保存
    public void save(Blog blog){
        jdbcClient.sql("INSERT INTO blogs(title, text) VALUES (:title, :text)")
            .param("title", blog.getTitle())
            .param("text", blog.getText())
            .update();
    }
    // idで見つける
    public Optional<Blog> findById(Long id){
        return jdbcClient.sql("SELECT * FROM blogs WHERE id = :id")
            .param("id", id)
            .query(Blog.class)
            .optional();
    }
    // 更新
    public void update(Long id, String title, String text){
        jdbcClient.sql("UPDATE blogs SET title = :title, text = :text WHERE id = :id")
            .param("title", title)
            .param("text", text)
            .param("id", id)
            .update();
    }

}
