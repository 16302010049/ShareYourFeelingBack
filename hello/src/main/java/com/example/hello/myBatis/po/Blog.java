package com.example.hello.myBatis.po;

public class Blog {
    private int id;
    private String content;
    private int commentNum ;
    private int tranNum;
    private int zanNum;
    private String author;
    private String date;
    private String imageList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String avatarUrl;

    public Blog(){

    }

    public Blog(String content, int commentNum, int tranNum, int zanNum, String author, String date, String imagelist, String avatarUrl) {
        this.content = content;
        this.commentNum = commentNum;
        this.tranNum = tranNum;
        this.zanNum = zanNum;
        this.author = author;
        this.date = date;
        this.imageList = imagelist;
        this.avatarUrl = avatarUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public int getTranNum() {
        return tranNum;
    }

    public void setTranNum(int tranNum) {
        this.tranNum = tranNum;
    }

    public int getZanNum() {
        return zanNum;
    }

    public void setZanNum(int zanNum) {
        this.zanNum = zanNum;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImageList() {
        return imageList;
    }

    public void setImageList(String imagelist) {
        this.imageList = imagelist;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
