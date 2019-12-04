package com.example.hello.myBatis.po;

public class Blog {
    private int id;
    private String content;
    private int commentNum ;
    private int tranNum;
    private int zanNum;
    private int authorID;
    private String date;
    private String imageList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Blog(){

    }

    public Blog(String content, int commentNum, int tranNum, int zanNum, int authorID, String date, String imageList) {
        this.content = content;
        this.commentNum = commentNum;
        this.tranNum = tranNum;
        this.zanNum = zanNum;
        this.authorID = authorID;
        this.date = date;
        this.imageList = imageList;
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

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
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

    public void setImageList(String imageList) {
        this.imageList = imageList;
    }
}
