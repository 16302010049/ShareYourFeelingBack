package com.example.hello.controller;

import com.example.hello.myBatis.SqlSessionLoader;
import com.example.hello.myBatis.po.Blog;
import com.example.hello.myBatis.po.User;
import com.example.hello.request.AddBlogRequest;
import com.example.hello.request.PageBlogRequest;
import com.example.hello.request.SearchPageBlogRequest;
import com.example.hello.response.BlogResponse;
import com.example.hello.response.CommonResponse;
import com.example.hello.response.PageBlogResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/blog")

public class BlogController {
    @RequestMapping(value = "/postBlog",method = RequestMethod.POST)
    public @ResponseBody CommonResponse postBlog(AddBlogRequest addBlogRequest) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        String[] imageUrls = new String[0];
        if(addBlogRequest.getFiles() != null) {
            imageUrls = new String[addBlogRequest.getFiles().length];
        }
        if(imageUrls.length>0){
            for(int i=0;i<imageUrls.length;i++){
                String fileName = addBlogRequest.getFiles()[i].getOriginalFilename();
                //获取文件后缀名
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                //重新生成文件名
                fileName = UUID.randomUUID()+suffixName;
                //指定本地文件夹存储图片
                String filePath = "D:/media/";
                try {
                    //将图片保存到static文件夹里
                    addBlogRequest.getFiles()[i].transferTo(new File(filePath+fileName));
                    imageUrls[i] ="http://localhost:8080/img/"+fileName;
                } catch (Exception e) {
                    e.printStackTrace();
                    return new CommonResponse("error");
                }
            }
        }
        Gson gson = new Gson();
        String imageList = gson.toJson(imageUrls);
        sqlSession.insert("hello.UserMapper.addBlog",new Blog(addBlogRequest.getContent(),addBlogRequest.getCommentNum(),addBlogRequest.getTranNum(),addBlogRequest.getZanNum(),addBlogRequest.getAuthorID(),addBlogRequest.getDate(),imageList));
        User user = sqlSession.selectOne("hello.UserMapper.findUserByID",addBlogRequest.getAuthorID());
        user.setBlogNum(user.getBlogNum()+1);
        sqlSession.update("hello.UserMapper.updateUserBlogNum",user);
        sqlSession.commit();
        sqlSession.close();
        return new CommonResponse("success");
    }

    @RequestMapping(value = "/getBlog",method = RequestMethod.POST)
    public @ResponseBody PageBlogResponse getBlogPage(@RequestBody PageBlogRequest pageBlogRequest) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        int pageNum = pageBlogRequest.getPageNum();
        int pageSize = pageBlogRequest.getPageSize();
        String orderBy = "date DESC";
        PageHelper.startPage(pageNum,pageSize,orderBy);
        List<BlogResponse> blogs = sqlSession.selectList("hello.UserMapper.selectBlogPage");
        PageInfo<BlogResponse> blogPageInfo = new PageInfo<>(blogs);
        PageBlogResponse pageBlogResponse = new PageBlogResponse(blogPageInfo.getPageNum(),blogPageInfo.getPageSize(),blogPageInfo.getTotal(),blogPageInfo.getPages(),blogPageInfo.getList());
        sqlSession.commit();
        sqlSession.close();
        return pageBlogResponse;
    }

    @RequestMapping(value = "/searchBlog",method = RequestMethod.POST)
    public @ResponseBody PageBlogResponse searchBlogbystr(@RequestBody SearchPageBlogRequest searchPageBlogRequest) throws IOException{
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        int pageNum = searchPageBlogRequest.getPageNum();
        int pageSize = searchPageBlogRequest.getPageSize();
        String orderBy = "date DESC";
        PageHelper.startPage(pageNum,pageSize,orderBy);
        List<BlogResponse> blogs = sqlSession.selectList("hello.UserMapper.searchBlogPage",searchPageBlogRequest.getSearchStr());
        PageInfo<BlogResponse> blogPageInfo = new PageInfo<>(blogs);
        PageBlogResponse pageBlogResponse = new PageBlogResponse(blogPageInfo.getPageNum(),blogPageInfo.getPageSize(),blogPageInfo.getTotal(),blogPageInfo.getPages(),blogPageInfo.getList());
        sqlSession.commit();
        sqlSession.close();
        return pageBlogResponse;
    }

    @RequestMapping(value = "/getSingleBlog",method = RequestMethod.GET)
    public @ResponseBody BlogResponse getSingleBlog(@RequestParam Integer blogID) throws IOException{
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        BlogResponse blogResponse = sqlSession.selectOne("hello.UserMapper.selectBlogPageByBlogID",blogID);
        sqlSession.commit();
        sqlSession.close();
        return blogResponse;
    }
}
