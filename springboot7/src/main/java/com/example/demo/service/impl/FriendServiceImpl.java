package com.example.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.FriendMapper;
import com.example.demo.entity.Friend;
import com.example.demo.service.*;
/**
 * 
 * @author zhoucong(QQ:2632652610)
 *
 */
@Service
public class FriendServiceImpl implements FriendService{

	 private final Logger logger = LoggerFactory.getLogger(this.getClass());  
	 
	@Autowired
	private FriendMapper friendMapper;

	@Override
	public int insert(Friend friend) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Friend selectByFtel(String ftel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Friend> getAllFriendTask() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> searchAllByAnnotaion() {
		// TODO Auto-generated method stub
		return null;
	}
	


}
