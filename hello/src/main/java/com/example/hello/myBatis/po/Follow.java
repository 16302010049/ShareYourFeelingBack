package com.example.hello.myBatis.po;

public class Follow {
    private int id;
    private int followerID;
    private int followID;
    private String time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
