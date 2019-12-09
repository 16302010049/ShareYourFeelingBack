package com.example.hello.controller;

import com.example.hello.myBatis.SqlSessionLoader;
import com.example.hello.myBatis.po.GeoHashes;
import com.example.hello.myBatis.po.Other;
import com.example.hello.request.AddGeoRequest;
import com.example.hello.request.GetNearByRequest;
import com.example.hello.response.CommonResponse;
import com.example.hello.response.PageUserResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/geo")
public class GeoController {
    @RequestMapping(value = "addGeo", method = RequestMethod.POST)
    public @ResponseBody
    CommonResponse addGeo(@RequestBody AddGeoRequest addGeoRequest) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        GeoHash geohash = new GeoHash();
        String s = geohash.encode(addGeoRequest.getLat(), addGeoRequest.getLng());
        GeoHashes geoHashes = sqlSession.selectOne("hello.UserMapper.selectGeoByID", addGeoRequest.getUserID());
        if (geoHashes == null) {
            geoHashes = new GeoHashes(addGeoRequest.getUserID(), s);
            sqlSession.insert("hello.UserMapper.insertGeo", geoHashes);
        } else {
            geoHashes.setGeoString(s);
            sqlSession.update("hello.UserMapper.updateGeo", geoHashes);
        }
        sqlSession.commit();
        sqlSession.close();
        return new CommonResponse("success");
    }

    @RequestMapping(value = "getNearBy", method = RequestMethod.POST)
    public @ResponseBody
    PageUserResponse getNearBy(@RequestBody GetNearByRequest getNearByRequest) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        GeoHashes geoHashes = sqlSession.selectOne("hello.UserMapper.selectGeoByID", getNearByRequest.getUserID());
        if (geoHashes == null) {
            sqlSession.commit();
            sqlSession.close();
            return null;
        } else {
            int pageNum = getNearByRequest.getPageNum();
            int pageSize = getNearByRequest.getPageSize();
            PageHelper.startPage(pageNum, pageSize);
            List<Other> others = sqlSession.selectList("hello.UserMapper.getUserByGeo", geoHashes);
            PageInfo<Other> userPageInfo = new PageInfo<>(others);
            PageUserResponse pageUserResponse = new PageUserResponse(userPageInfo.getPageNum(), userPageInfo.getPageSize(), userPageInfo.getTotal(), userPageInfo.getPages(), userPageInfo.getList());
            sqlSession.commit();
            sqlSession.close();
            return pageUserResponse;
        }
    }

}
