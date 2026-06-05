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

    // 改行変換　登録
    public String formattedText(){
        String formattedText = text.replace("(\r\n|\r|\n)", "<br>");
        return formattedText;
    }
    // 改行変換　編集
    public String returnText(){
        String returnText = text.replace("<br>", "\n");
        return returnText;
    }
}
