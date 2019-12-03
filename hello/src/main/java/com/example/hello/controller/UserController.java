package com.example.hello.controller;

import com.example.hello.myBatis.SqlSessionLoader;
import com.example.hello.myBatis.po.User;
import com.example.hello.request.UserLoginRequest;
import com.example.hello.request.UserRegisterRequest;
import com.example.hello.response.ErrorResponse;
import com.example.hello.response.LoginResponse;
import com.example.hello.response.RegisterResponse;
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
            sqlSession.insert("hello.UserMapper.addUser", new User(request.getName(),request.getMailbox(),request.getSex(),request.getPass(),request.getBirthday(),request.getSignature(),"http://localhost:8080/img/"+fileName,request.getTags()));
            sqlSession.commit();
            sqlSession.close();
            return new RegisterResponse("success"); // use your generated token here.
        }
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public @ResponseBody LoginResponse login(@RequestBody UserLoginRequest userLoginRequest) throws IOException{
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        User user = sqlSession.selectOne("hello.UserMapper.findUserByUsername", userLoginRequest.getUsername());
        sqlSession.close();
        if(user==null){
            return new LoginResponse("用户名或密码错误",null);
        }
        else {
            if(user.getPass().equals(userLoginRequest.getPassword())){
                return new LoginResponse("success",user);
            }
            else {
                return new LoginResponse("用户名或密码错误",null);
            }
        }
    }

}
