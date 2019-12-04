package com.example.hello.response;

import com.example.hello.myBatis.po.Other;
import com.example.hello.myBatis.po.User;

import java.util.List;

public class PageUserResponse {
    private int pageNum;
    private int pageSize;
    private long totalSize;
    private long totalPage;
    private List<Other> content;

    public PageUserResponse(int pageNum, int pageSize, long totalSize, long totalPage, List<Other> content) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalSize = totalSize;
        this.totalPage = totalPage;
        this.content = content;
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

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public List<Other> getContent() {
        return content;
    }

    public void setContent(List<Other> content) {
        this.content = content;
    }
}
