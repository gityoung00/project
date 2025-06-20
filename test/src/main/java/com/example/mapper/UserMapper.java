package com.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.vo.UserVO;

@Mapper
public interface UserMapper {
	@Insert("INSERT INTO user (USER_ID, USER_PW) VALUES (#{userID}, #{userPW})")
	void insertUser(UserVO userVO);

	@Select("SELECT * FROM user WHERE USER_ID = #{userID}")
	@Results({ @Result(property = "userID", column = "USER_ID"), @Result(property = "userPW", column = "USER_PW") })
	UserVO selectUser(String userID);

}
