package com.example.hello.request;

import org.springframework.web.multipart.MultipartFile;

public class AddBlogRequest {
    private String content;
    private int commentNum ;
    private int tranNum;
    private int zanNum;
    private int authorID;
    private String date;
    private MultipartFile[] files;

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

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }
}
