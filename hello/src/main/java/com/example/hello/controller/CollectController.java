package com.example.hello.controller;

import com.example.hello.myBatis.SqlSessionLoader;
import com.example.hello.myBatis.po.Collect;
import com.example.hello.request.AddCollectRequest;
import com.example.hello.request.CheckCollectRequest;
import com.example.hello.request.DelectCollectRequest;
import com.example.hello.response.CommentResponse;
import com.example.hello.response.CommonResponse;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

import javax.imageio.IIOException;
import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/collect")
public class CollectController {
    @RequestMapping(value = "/addCollect",method = RequestMethod.POST)
    public @ResponseBody CommonResponse addCollect(@RequestBody AddCollectRequest addCollectRequest) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        sqlSession.insert("hello.UserMapper.addCollect",addCollectRequest);
        sqlSession.commit();
        sqlSession.close();
        return new CommonResponse("success");
    }

    @RequestMapping(value = "/checkCollect",method = RequestMethod.POST)
    public @ResponseBody CommonResponse checkCollect(@RequestBody CheckCollectRequest checkCollectRequest) throws IOException{
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        Collect collect = sqlSession.selectOne("hello.UserMapper.checkCollect",checkCollectRequest);
        sqlSession.commit();
        sqlSession.close();
        if(collect==null){
            return new CommonResponse("No");
        }
        else {
            return  new CommonResponse("Yes");
        }
    }

    @RequestMapping(value = "/deleteCollect",method = RequestMethod.POST)
    public @ResponseBody CommonResponse deleteCollect(@RequestBody DelectCollectRequest delectCollectRequest) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        sqlSession.delete("hello.UserMapper.deleteCollect",delectCollectRequest);
        sqlSession.commit();
        sqlSession.close();
        return new CommonResponse("success");
    }
}
