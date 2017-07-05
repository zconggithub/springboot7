package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.Friend;

public interface FriendMapper {


    int insert(Friend record);

    int insertSelective(Friend record);
    
    Friend selectByFtel(String ftel);
    
    List<Friend> getAllFriend();
    
    @Select("select fname,sex,age,ftel from friend")
    List<Map<String,Object>> searchAllByAnnotaion();

}