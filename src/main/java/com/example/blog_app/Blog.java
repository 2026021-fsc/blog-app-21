package com.example.blog_app;

public class Blog {
    private final Long id;
    private final String title;
    private final String text;
    public Blog(Long id, String title, String text){
        this.id = id;
        this.title = title;
        this.text = text;
    }
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getText() {
        return text;
    }
}
