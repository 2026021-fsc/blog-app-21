package com.example.blog_app;

public class BlogForm {
    private final String title;
    private final String text;
    public BlogForm(String title, String text){
        this.title = title;
        this.text = text;
    }
    public String getTitle() {
        return title;
    }
    public String getText() {
        return text;
    }

    // 改行変換
    public String formattedText(){
        String formattedText = text.replace("\n", "<br>");
        return formattedText;
    }
}
