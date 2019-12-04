package com.example.hello.controller;

import com.example.hello.myBatis.SqlSessionLoader;
import com.example.hello.myBatis.po.Blog;
import com.example.hello.myBatis.po.ThumbsUp;
import com.example.hello.request.AddThumbsUpRequest;
import com.example.hello.request.CheckThumbsUpRequest;
import com.example.hello.request.DeleteThumbsUpRequest;
import com.example.hello.response.CommonResponse;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/thumbsup")
public class ThumbsUpController {
    @RequestMapping(value = "/addThumbsUp",method = RequestMethod.POST)
    public @ResponseBody CommonResponse addThumbsUp(@RequestBody AddThumbsUpRequest addThumbsUpRequest) throws IOException{
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        sqlSession.insert("hello.UserMapper.addThumbsUp",addThumbsUpRequest);
        Blog blog = sqlSession.selectOne("hello.UserMapper.getBlogByID",addThumbsUpRequest.getBlogID());
        blog.setZanNum(blog.getZanNum()+1);
        sqlSession.update("hello.UserMapper.updateBlog",blog);
        sqlSession.commit();
        sqlSession.close();
        return new CommonResponse("success");
    }

    @RequestMapping(value = "/checkThumbsUp",method = RequestMethod.POST)
    public @ResponseBody CommonResponse checkThumbsUp(@RequestBody CheckThumbsUpRequest checkThumbsUpRequest) throws IOException{
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        ThumbsUp thumbsUp = sqlSession.selectOne("hello.UserMapper.checkThumbsUp",checkThumbsUpRequest);
        sqlSession.commit();
        sqlSession.close();
        if(thumbsUp==null){
            return new CommonResponse("No");
        }
        else {
            return new CommonResponse("Yes");
        }
    }

    @RequestMapping(value = "/deleteThumbsUp",method = RequestMethod.POST)
    public @ResponseBody CommonResponse deleteThumbsUp(@RequestBody DeleteThumbsUpRequest deleteThumbsUpRequest) throws IOException{
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        sqlSession.delete("hello.UserMapper.deleteThumbsUp",deleteThumbsUpRequest);
        Blog blog = sqlSession.selectOne("hello.UserMapper.getBlogByID",deleteThumbsUpRequest.getBlogID());
        blog.setZanNum(blog.getZanNum()-1);
        sqlSession.update("hello.UserMapper.updateBlog",blog);
        sqlSession.commit();
        sqlSession.close();
        return new CommonResponse("success");
    }
}
