package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.BoardMapper;
import com.example.vo.BoardVO;

import jakarta.servlet.http.HttpSession;

@Service
public class BoardService {
	@Autowired
	private BoardMapper boardMapper;
	@Autowired
	HttpSession session;

	public List<BoardVO> boardList() {
		return boardMapper.boardList();
	}

	public BoardVO board(int boardID) {
		return boardMapper.board(boardID);
	}

	public void write(BoardVO boardVO) {
		boardMapper.insertBoard(boardVO);

	}

	public void delete(int boardID) {
		boardMapper.delete(boardID);

	}

	public void modify(BoardVO boardVO) {
		boardMapper.modify(boardVO);

	}

}
