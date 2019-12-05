package com.example.hello.request;

import org.springframework.web.multipart.MultipartFile;

public class ModifyBackgroundRequest {
    private int userID;
    private MultipartFile file;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
