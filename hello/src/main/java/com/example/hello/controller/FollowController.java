package com.example.hello.controller;

import com.example.hello.myBatis.SqlSessionLoader;
import com.example.hello.myBatis.po.Follow;
import com.example.hello.myBatis.po.User;
import com.example.hello.request.AddFollowRequest;
import com.example.hello.request.CheckFollowRequest;
import com.example.hello.request.DeleteFollowRequest;
import com.example.hello.response.CommonResponse;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/follow")

public class FollowController {
    @RequestMapping(value = "checkFollow",method = RequestMethod.POST)
    public @ResponseBody CommonResponse checkFollow(CheckFollowRequest checkFollowRequest) throws IOException{
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        Follow follow = sqlSession.selectOne("hello.UserMapper.checkFollow",checkFollowRequest);
        sqlSession.commit();
        sqlSession.close();
        if(follow == null){
            return new CommonResponse("No");
        }
        else {
            return new CommonResponse("Yes");
        }
    }

    @RequestMapping(value = "addFollow",method = RequestMethod.POST)
    public @ResponseBody CommonResponse addFollow(@RequestBody AddFollowRequest addFollowRequest) throws IOException{
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        sqlSession.insert("hello.UserMapper.addFollow",addFollowRequest);
        User follower = sqlSession.selectOne("hello.UserMapper.findUserByID",addFollowRequest.getFollowerID());
        follower.setGuanNum(follower.getGuanNum()+1);
        sqlSession.update("hello.UserMapper.updateUserBlogNum",follower);
        User follow = sqlSession.selectOne("hello.UserMapper.findUserByID",addFollowRequest.getFollowID());
        follow.setFansNum(follow.getFansNum()+1);
        sqlSession.update("hello.UserMapper.updateUserBlogNum",follow);
        sqlSession.commit();
        sqlSession.close();
        return new CommonResponse("success");
    }

    @RequestMapping(value = "deleteFollow",method = RequestMethod.POST)
    public @ResponseBody CommonResponse deleteFollow(@RequestBody DeleteFollowRequest deleteFollowRequest) throws IOException{
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        sqlSession.delete("hello.UserMapper.deleteFollow",deleteFollowRequest);
        User follower = sqlSession.selectOne("hello.UserMapper.findUserByID",deleteFollowRequest.getFollowerID());
        follower.setGuanNum(follower.getGuanNum()-1);
        sqlSession.update("hello.UserMapper.updateUserBlogNum",follower);
        User follow = sqlSession.selectOne("hello.UserMapper.findUserByID",deleteFollowRequest.getFollowID());
        follow.setFansNum(follow.getFansNum()-1);
        sqlSession.update("hello.UserMapper.updateUserBlogNum",follow);
        sqlSession.commit();
        sqlSession.close();
        return new CommonResponse("success");
    }
}
