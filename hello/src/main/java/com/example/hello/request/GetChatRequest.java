package com.example.hello.request;

public class GetChatRequest {
    private int userIDSmall;
    private int userIDBig;

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
}
