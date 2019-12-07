package com.example.hello.request;

public class AddMessageRequest {
    private int userIDSmall;
    private int userIDBig;
    private String content;

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
