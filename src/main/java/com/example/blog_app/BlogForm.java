package com.example.blog_app;

public class BlogForm {
    private String title;
    private String text;

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
    public void setTitle(String title) {
        this.title = title;
    }
    public void setText(String text) {
        this.text = text;
    }
    // 改行変換
    public String formattedText(){
        String formattedText = text.replace("(\r\n|\r|\n)", "<br/>");
        return formattedText;
    }
}
