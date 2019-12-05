package com.example.hello.request;

public class GetPageTagUserRequest {
     private int userID;
     private int pageNum;
     private int pageSize;
     private String tags;

     public int getUserID() {
          return userID;
     }

     public void setUserID(int userID) {
          this.userID = userID;
     }

     public int getPageNum() {
          return pageNum;
     }

     public void setPageNum(int pageNum) {
          this.pageNum = pageNum;
     }

     public int getPageSize() {
          return pageSize;
     }

     public void setPageSize(int pageSize) {
          this.pageSize = pageSize;
     }

     public String getTags() {
          return tags;
     }

     public void setTags(String tags) {
          this.tags = tags;
     }
}
