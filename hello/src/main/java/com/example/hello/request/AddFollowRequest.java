package com.example.hello.request;

public class AddFollowRequest {
    private int followerID;
    private int followID;
    private String time;

    public int getFollowerID() {
        return followerID;
    }

    public void setFollowerID(int followerID) {
        this.followerID = followerID;
    }

    public int getFollowID() {
        return followID;
    }

    public void setFollowID(int followID) {
        this.followID = followID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
