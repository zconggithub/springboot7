package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.ConstantPages;
import com.example.demo.service.FriendService;

@Controller
@RequestMapping("/Friend")
public class FriendController {

	
	@Autowired
	private FriendService friendService;
	
	@RequestMapping("/login")
	public String login(){
		return ConstantPages.LOGIN;
	}
	
	/**
	 * 
	 * @return	返回的是一个模板即1.ftl====>对应的yml文件将配置此：spring.freemarker.suffix: .ftl
	 */
	@RequestMapping("/comment")
	public String login1(){
		return ConstantPages.COMMENT;
	}
}
