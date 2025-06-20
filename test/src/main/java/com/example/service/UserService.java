package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.UserMapper;
import com.example.vo.UserVO;

import jakarta.servlet.http.HttpSession;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	HttpSession session;

	public void register(UserVO userVO) {
		userMapper.insertUser(userVO);
	}

	public String login(String userID, String userPW) {
		System.out.println("login ser : " + userID + " " + userPW);
		UserVO userVO = userMapper.selectUser(userID);

		// 데이터 안넣음
		if (userVO == null || userVO.getUserPW() == null) {
			return null;
		}

		// 비밀번호 확인
		if (userVO.getUserPW().equals(userPW)) {
			return userVO.getUserID();
		}

		return null;
	}

}
