package com.example.hello.response;

import com.example.hello.myBatis.po.Comment;

import javax.activation.CommandMap;
import java.util.List;

public class PageCommentResponse {
    private int pageNum;
    private int pageSize;
    private long totalSize;
    private long totalPage;
    private List<Comment> content;

    public PageCommentResponse(int pageNum, int pageSize, long totalSize, long totalPage, List<Comment> content) {
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

    public List<Comment> getContent() {
        return content;
    }

    public void setContent(List<Comment> content) {
        this.content = content;
    }
}
