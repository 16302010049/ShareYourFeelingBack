package com.example.hello.myBatis.po;

public class User {
    private Integer id;

    private String name;

    private String mailbox;

    private String sex;

    private String pass;

    private String birthday;

    private String signature;

    private String imageurl;

    private String tags;

    private int blogNum;

    private int guanNum;

    private int fansNum;

    private String backgroundUrl;

    public User(){

    }

    public User(String name, String mailbox, String sex, String pass, String birthday, String signature, String imageurl, String tags, int blogNum, int guanNum, int fansNum, String backgroundUrl) {
        this.name = name;
        this.mailbox = mailbox;
        this.sex = sex;
        this.pass = pass;
        this.birthday = birthday;
        this.signature = signature;
        this.imageurl = imageurl;
        this.tags = tags;
        this.blogNum = blogNum;
        this.guanNum = guanNum;
        this.fansNum = fansNum;
        this.backgroundUrl = backgroundUrl;
    }

    public int getBlogNum() {
        return blogNum;
    }

    public void setBlogNum(int blogNum) {
        this.blogNum = blogNum;
    }

    public int getGuanNum() {
        return guanNum;
    }

    public void setGuanNum(int guanNum) {
        this.guanNum = guanNum;
    }

    public int getFansNum() {
        return fansNum;
    }

    public void setFansNum(int fansNum) {
        this.fansNum = fansNum;
    }

    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}