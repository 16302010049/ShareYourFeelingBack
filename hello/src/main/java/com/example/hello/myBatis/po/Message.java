package com.example.hello.myBatis.po;

public class Message {
    private int id;
    private int userIDSmall;
    private int userIDBig;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserIDSmall() {
        return userIDSmall;
    }

    public void setUserIDSmall(int userIDSmall) {
        this.userIDSmall = userIDSmall;
    }

    public int getUserIDBig() {
        return userIDBig;
    }

    public void setUserIDBig(int userIDBig) {
        this.userIDBig = userIDBig;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
