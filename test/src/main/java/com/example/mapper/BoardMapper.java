package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.vo.BoardVO;

@Mapper
public interface BoardMapper {

	@Insert("INSERT INTO board (TITLE, CONTENT, USER_ID, FILENAME, FILE) VALUES (#{title}, #{content}, #{userID}, #{filename}, #{filedir})")
	void insertBoard(BoardVO boardVO);

	@Select("SELECT * FROM board ORDER BY B_ID DESC")
	@Results({ @Result(property = "userID", column = "USER_ID"), @Result(property = "boardID", column = "B_ID"),
			@Result(property = "content", column = "CONTENT"), @Result(property = "title", column = "TITLE"),
			@Result(property = "filename", column = "FILENAME"), @Result(property = "filedir", column = "FILE") })
	List<BoardVO> boardList();

	@Select("SELECT * FROM board WHERE B_ID = #{boardID}")
	@Results({ @Result(property = "userID", column = "USER_ID"), @Result(property = "boardID", column = "B_ID"),
			@Result(property = "content", column = "CONTENT"), @Result(property = "title", column = "TITLE"),
			@Result(property = "filename", column = "FILENAME"), @Result(property = "filedir", column = "FILE") })
	BoardVO board(int boardID);

	@Delete("DELETE FROM board WHERE B_ID = #{boardID}")
	@Results({ @Result(property = "boardID", column = "B_ID") })
	void delete(int boardID);

	@Update("UPDATE board SET TITLE = #{title}, CONTENT = #{content} WHERE b_id = #{boardID}")
	@Results({ @Result(property = "content", column = "CONTENT"), @Result(property = "title", column = "TITLE"),
			@Result(property = "boardID", column = "B_ID") })
	void modify(BoardVO boardVO);

}
