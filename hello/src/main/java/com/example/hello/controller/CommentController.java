package com.example.hello.controller;

import com.example.hello.myBatis.SqlSessionLoader;
import com.example.hello.myBatis.po.Blog;
import com.example.hello.myBatis.po.Comment;
import com.example.hello.request.AddCommentRequest;
import com.example.hello.request.DeleteCommentRequest;
import com.example.hello.request.GetPageCommentRequest;
import com.example.hello.response.CommentResponse;
import com.example.hello.response.CommonResponse;
import com.example.hello.response.PageCommentResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/comment")

public class CommentController {
   @RequestMapping(value = "/addComment",method = RequestMethod.POST)
    public @ResponseBody CommonResponse addComment(@RequestBody AddCommentRequest addCommentRequest) throws IOException {
       SqlSession sqlSession = SqlSessionLoader.getSqlSession();
       sqlSession.insert("hello.UserMapper.addComment",addCommentRequest);
       Blog blog = sqlSession.selectOne("hello.UserMapper.getBlogByID",addCommentRequest.getBlogId());
       blog.setCommentNum(blog.getCommentNum()+1);
       sqlSession.update("hello.UserMapper.updateBlog",blog);
       sqlSession.commit();
       sqlSession.close();
       return new CommonResponse("success");
   }

   @RequestMapping(value = "/getComment",method = RequestMethod.POST)
    public @ResponseBody PageCommentResponse getPageComment(@RequestBody GetPageCommentRequest getPageCommentRequest)throws IOException{
       SqlSession sqlSession = SqlSessionLoader.getSqlSession();
       int pageNum = getPageCommentRequest.getPageNum();
       int pageSize = getPageCommentRequest.getPageSize();
       String orderBy = "time DESC";
       PageHelper.startPage(pageNum,pageSize,orderBy);
       List<CommentResponse> comments = sqlSession.selectList("hello.UserMapper.getPageComment",getPageCommentRequest.getBlogId());
       PageInfo<CommentResponse> commentPageInfo = new PageInfo<>(comments);
       sqlSession.commit();
       sqlSession.close();
       return new PageCommentResponse(commentPageInfo.getPageNum(),commentPageInfo.getPageSize(),commentPageInfo.getTotal(),commentPageInfo.getPages(),commentPageInfo.getList());
   }

   @RequestMapping(value = "/deleteComment",method = RequestMethod.POST)
    public @ResponseBody CommonResponse deleteComment(@RequestBody DeleteCommentRequest deleteCommentRequest) throws IOException{
       SqlSession sqlSession = SqlSessionLoader.getSqlSession();
       sqlSession.delete("hello.UserMapper.deleteComment",deleteCommentRequest.getCommentID());
       Blog blog = sqlSession.selectOne("hello.UserMapper.getBlogByID",deleteCommentRequest.getBlogID());
       blog.setCommentNum(blog.getCommentNum()-1);
       sqlSession.update("hello.UserMapper.updateBlog",blog);
       sqlSession.commit();
       sqlSession.close();
       return new CommonResponse("success");
   }
}
