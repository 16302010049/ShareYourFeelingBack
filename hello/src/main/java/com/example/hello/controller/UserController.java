package com.example.hello.controller;

import com.example.hello.myBatis.SqlSessionLoader;
import com.example.hello.myBatis.po.Other;
import com.example.hello.myBatis.po.User;
import com.example.hello.request.*;
import com.example.hello.response.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody Object register( UserRegisterRequest request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        User user = sqlSession.selectOne("hello.UserMapper.findUserByUsername", request.getName());
        if (user != null) {
            sqlSession.close();
            return new ErrorResponse("The username is already used");
        } else {
            String fileName = request.getFile().getOriginalFilename();
            //获取文件后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            //重新生成文件名
            fileName = UUID.randomUUID()+suffixName;
            //指定本地文件夹存储图片
            String filePath = "D:/media/";
            try {
                //将图片保存到static文件夹里
                request.getFile().transferTo(new File(filePath+fileName));
            } catch (Exception e) {
                e.printStackTrace();
            }
            sqlSession.insert("hello.UserMapper.addUser", new User(request.getName(),request.getMailbox(),request.getSex(),request.getPass(),request.getBirthday(),request.getSignature(),"http://localhost:8080/img/"+fileName,request.getTags()
            ,request.getBlogNum(),request.getGuanNum(),request.getFansNum(),request.getBackgroundUrl()));
            sqlSession.commit();
            sqlSession.close();
            return new RegisterResponse("success"); // use your generated token here.
        }
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public @ResponseBody LoginResponse login(@RequestBody UserLoginRequest userLoginRequest) throws IOException{
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        User user = sqlSession.selectOne("hello.UserMapper.findUserByUsername", userLoginRequest.getUsername());
        sqlSession.commit();
        sqlSession.close();
        if(user==null){
            return new LoginResponse("用户名或密码错误",null);
        }
        else {
            if(user.getPass().equals(userLoginRequest.getPassword())){
                return new LoginResponse("success",user);
            }
            else {
                return new LoginResponse("用户名或密码错误", null);
            }
        }
    }

    @RequestMapping(value = "/getPageUser",method = RequestMethod.POST)
    public @ResponseBody PageUserResponse getPageUser(@RequestBody GetPageUserRequest getPageUserRequest) throws IOException{
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        int pageNum = getPageUserRequest.getPageNum();
        int pageSize = getPageUserRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        List<Other> users = sqlSession.selectList("hello.UserMapper.getPageUser",getPageUserRequest.getUserID());
        PageInfo<Other> userPageInfo = new PageInfo<>(users);
        PageUserResponse pageUserResponse = new PageUserResponse(userPageInfo.getPageNum(),userPageInfo.getPageSize(),userPageInfo.getTotal(),userPageInfo.getPages(),userPageInfo.getList());
        sqlSession.commit();
        sqlSession.close();
        return pageUserResponse;
    }

   @RequestMapping(value = "/getPageUserTags",method = RequestMethod.POST)
    public @ResponseBody PageUserResponse getPageTagsUser(@RequestBody GetPageTagUserRequest getPageTagUserRequest) throws IOException{
       SqlSession sqlSession = SqlSessionLoader.getSqlSession();
       int pageNum = getPageTagUserRequest.getPageNum();
       int pageSize = getPageTagUserRequest.getPageSize();
       PageHelper.startPage(pageNum,pageSize);
       List<Other> users = sqlSession.selectList("hello.UserMapper.getPageUserByTags",getPageTagUserRequest);
       PageInfo<Other> userPageInfo = new PageInfo<>(users);
       PageUserResponse pageUserResponse = new PageUserResponse(userPageInfo.getPageNum(),userPageInfo.getPageSize(),userPageInfo.getTotal(),userPageInfo.getPages(),userPageInfo.getList());
       sqlSession.commit();
       sqlSession.close();
       return pageUserResponse;
   }

   @RequestMapping(value = "/getOther",method = RequestMethod.GET)
    public @ResponseBody Other getOther(@RequestParam int userID) throws IOException{
       SqlSession sqlSession = SqlSessionLoader.getSqlSession();
       Other other = sqlSession.selectOne("hello.UserMapper.findOtherByID",userID);
       sqlSession.commit();
       sqlSession.close();
       return other;
   }

   @RequestMapping(value = "/modifyBackground", method = RequestMethod.POST)
    public @ResponseBody User modifyBackground ( ModifyBackgroundRequest modifyBackgroundRequest) throws IOException{
       SqlSession sqlSession = SqlSessionLoader.getSqlSession();
       String fileName = modifyBackgroundRequest.getFile().getOriginalFilename();
       //获取文件后缀名
       String suffixName = fileName.substring(fileName.lastIndexOf("."));
       //重新生成文件名
       fileName = UUID.randomUUID()+suffixName;
       //指定本地文件夹存储图片
       String filePath = "D:/media/";
       try {
           //将图片保存到static文件夹里
           modifyBackgroundRequest.getFile().transferTo(new File(filePath+fileName));
       } catch (Exception e) {
           e.printStackTrace();
       }
       User user = sqlSession.selectOne("hello.UserMapper.findUserByID",modifyBackgroundRequest.getUserID());
       user.setBackgroundUrl("http://localhost:8080/img/"+fileName);
       sqlSession.update("hello.UserMapper.updateUserBackgroundUrl",user);
       sqlSession.commit();
       sqlSession.close();
       return user;
   }

   @RequestMapping(value = "/getUserBlogPage",method = RequestMethod.POST)
    public @ResponseBody PageBlogResponse getUserBlogPage(@RequestBody GetUserBlogRequest getUserBlogRequest) throws IOException{
       SqlSession sqlSession = SqlSessionLoader.getSqlSession();
       int pageNum = getUserBlogRequest.getPageNum();
       int pageSize = getUserBlogRequest.getPageSize();
       String orderBy = "date DESC";
       PageHelper.startPage(pageNum,pageSize,orderBy);
       List<BlogResponse> blogResponses;
       if(getUserBlogRequest.getRequire().equals("")){
           blogResponses = sqlSession.selectList("hello.UserMapper.selectUserBlog",getUserBlogRequest);
       }
       else {
           blogResponses = sqlSession.selectList("hello.UserMapper.selectUserBlogReq",getUserBlogRequest);
       }
       PageInfo<BlogResponse> blogPageInfo = new PageInfo<>(blogResponses);
       PageBlogResponse pageBlogResponse = new PageBlogResponse(blogPageInfo.getPageNum(),blogPageInfo.getPageSize(),blogPageInfo.getTotal(),blogPageInfo.getPages(),blogPageInfo.getList());
       sqlSession.commit();
       sqlSession.close();
       return pageBlogResponse;
   }

   @RequestMapping(value = "/getMyInfo",method = RequestMethod.GET)
    public @ResponseBody User getMyInfo(@RequestParam int userID) throws IOException{
       SqlSession sqlSession = SqlSessionLoader.getSqlSession();
       User me = sqlSession.selectOne("hello.UserMapper.findUserByID",userID);
       sqlSession.commit();
       sqlSession.close();
       return me;
   }

   @RequestMapping(value = "/editMyInfo", method = RequestMethod.POST)
    public @ResponseBody CommonResponse editMyInfo( EditMyInfoRequest editMyInfoRequest) throws IOException{
       SqlSession sqlSession = SqlSessionLoader.getSqlSession();
       User user1 = sqlSession.selectOne("hello.UserMapper.findUserByUsername", editMyInfoRequest.getName());
       User user = sqlSession.selectOne("hello.UserMapper.findUserByID",editMyInfoRequest.getId());
       if (user1 != null&& !user.getId().equals(user1.getId())) {
           sqlSession.commit();
           sqlSession.close();
           return  new CommonResponse("用户名已存在");
       }
       user.setName(editMyInfoRequest.getName());
       user.setMailbox(editMyInfoRequest.getMailbox());
       user.setSex(editMyInfoRequest.getSex());
       user.setPass(editMyInfoRequest.getPass());
       user.setBirthday(editMyInfoRequest.getBirthday());
       user.setSignature(editMyInfoRequest.getSignature());
       user.setTags(editMyInfoRequest.getTags());
       if(editMyInfoRequest.getFile()!=null) {
           String fileName = editMyInfoRequest.getFile().getOriginalFilename();
           String suffixName = fileName.substring(fileName.lastIndexOf("."));
           //重新生成文件名
           fileName = UUID.randomUUID() + suffixName;
           //指定本地文件夹存储图片
           String filePath = "D:/media/";
           try {
               //将图片保存到static文件夹里
               editMyInfoRequest.getFile().transferTo(new File(filePath + fileName));
               user.setImageurl("http://localhost:8080/img/"+fileName);
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
       sqlSession.update("editMyInfo",user);
       sqlSession.commit();
       sqlSession.close();
       return new CommonResponse("success");
   }

   @RequestMapping(value = "/getFollow",method = RequestMethod.POST)
    public @ResponseBody PageUserResponse getFollow(@RequestBody GetFollowPageRequest getFollowPageRequest) throws IOException{
       SqlSession sqlSession = SqlSessionLoader.getSqlSession();
       int pageNum = getFollowPageRequest.getPageNum();
       int pageSize = getFollowPageRequest.getPageSize();
       String orderBy = "time DESC";
       PageHelper.startPage(pageNum,pageSize,orderBy);
       List<Other> others;
       if(getFollowPageRequest.getStr().equals("")) {
           others = sqlSession.selectList("hello.UserMapper.getFollow", getFollowPageRequest.getUserID());
       }
       else{
           others = sqlSession.selectList("hello.UserMapper.getFollowStr",getFollowPageRequest);
       }
       PageInfo<Other> userPageInfo = new PageInfo<>(others);
       PageUserResponse pageUserResponse = new PageUserResponse(userPageInfo.getPageNum(),userPageInfo.getPageSize(),userPageInfo.getTotal(),userPageInfo.getPages(),userPageInfo.getList());
       sqlSession.commit();
       sqlSession.close();
       return pageUserResponse;
   }

    @RequestMapping(value = "/getFans",method = RequestMethod.POST)
    public @ResponseBody PageUserResponse getFollow(@RequestBody GetFansPageRequest getFansPageRequest) throws IOException{
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        int pageNum = getFansPageRequest.getPageNum();
        int pageSize = getFansPageRequest.getPageSize();
        String orderBy = "time DESC";
        PageHelper.startPage(pageNum,pageSize,orderBy);
        List<Other> others;
        if(getFansPageRequest.getStr().equals("")) {
            others = sqlSession.selectList("hello.UserMapper.getFans", getFansPageRequest.getUserID());
        }
        else{
            others = sqlSession.selectList("hello.UserMapper.getFansStr",getFansPageRequest);
        }
        PageInfo<Other> userPageInfo = new PageInfo<>(others);
        PageUserResponse pageUserResponse = new PageUserResponse(userPageInfo.getPageNum(),userPageInfo.getPageSize(),userPageInfo.getTotal(),userPageInfo.getPages(),userPageInfo.getList());
        sqlSession.commit();
        sqlSession.close();
        return pageUserResponse;
    }

    @RequestMapping(value ="/getCollect",method = RequestMethod.POST)
    public @ResponseBody PageBlogResponse getCollect(@RequestBody GetCollectRequest getCollectRequest) throws IOException{
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        int pageNum = getCollectRequest.getPageNum();
        int pageSize = getCollectRequest.getPageSize();
        String orderBy = "time DESC";
        PageHelper.startPage(pageNum,pageSize,orderBy);
        List<BlogResponse> blogResponses;
        if(getCollectRequest.getStr().equals("")){
            blogResponses = sqlSession.selectList("hello.UserMapper.getCollect",getCollectRequest);
        }
        else{
            blogResponses = sqlSession.selectList("hello.UserMapper.getCollectStr",getCollectRequest);
        }
        PageInfo<BlogResponse> blogPageInfo = new PageInfo<>(blogResponses);
        PageBlogResponse pageBlogResponse = new PageBlogResponse(blogPageInfo.getPageNum(),blogPageInfo.getPageSize(),blogPageInfo.getTotal(),blogPageInfo.getPages(),blogPageInfo.getList());
        sqlSession.commit();
        sqlSession.close();
        return pageBlogResponse;
    }

    @RequestMapping(value = "getChatList",method = RequestMethod.POST)
    public @ResponseBody List<Other> getChatList(@RequestBody GetCollectRequest getCollectRequest) throws IOException{
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        List<Other> others;
        if(getCollectRequest.getStr().equals("")) {
            others = sqlSession.selectList("hello.UserMapper.getChatList", getCollectRequest);
        }
        else {
            others = sqlSession.selectList("hello.UserMapper.getChatListStr", getCollectRequest);
        }
        return others;
    }

}
