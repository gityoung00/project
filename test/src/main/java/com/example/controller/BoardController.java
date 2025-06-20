package com.example.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.service.BoardService;
import com.example.vo.BoardVO;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;

	@GetMapping("/boardlist")
	public String boardlist(Model model, HttpSession session) {
		String result = (String) session.getAttribute("userID");
		System.out.println("boardlist : " + result);

		// 로그인 여부 확인
		if (result == null) {
			return "redirect:/login";
		}

		// 데이터불러오기
		List<BoardVO> boardlist = boardService.boardList();
		model.addAttribute("boardList", boardlist); // boardList이름으로 jsp에 데이터 전달

		return "boardlist";
	}

	@GetMapping("/board")
	public String board(@RequestParam("boardID") int boardID, Model model, HttpSession session) {
		String result = (String) session.getAttribute("userID");
//		System.out.println("board : " + result);

		// 로그인 여부 확인
		if (result == null) {
			return "redirect:/login";
		}

		// 데이터불러오기
		BoardVO board = boardService.board(boardID);
		model.addAttribute("board", board); // boardList이름으로 jsp에 데이터 전달

		return "board";
	}

	@GetMapping("/write")
	public String write() {
		return "write";
	}

	@PostMapping("/write")
	public String write(BoardVO boardVO, @RequestParam("file") MultipartFile file, HttpSession session)
			throws IOException {
		String userID = (String) session.getAttribute("userID");

		if (userID == null) {
			return "redirect:/login";
		}
		boardVO.setUserID(userID);

		// 파일 업로드
		if (!file.isEmpty()) {
			String filename = file.getOriginalFilename();
			boardVO.setFilename(filename);

			// 경로
			String uploaddir = "C:/upload/";

			File folder = new File(uploaddir);

			// upload파일 없으면 만들어주기
			if (!folder.exists()) {
				folder.mkdirs();
			}

			// 파일 저장 경로 설정
			String filePath = folder + "/" + filename;
			file.transferTo(new File(filePath));

			boardVO.setFiledir(filePath);
		}

		boardService.write(boardVO);

		return "redirect:/boardlist";

	}

	@GetMapping("/board/download")
	public void file(@RequestParam("filename") String filename,
			@RequestParam(value = "file", required = false) String file, HttpServletResponse response)
			throws Exception {
		String filePath = "C:/upload/" + filename;

		File files = new File(filePath);
		if (files.exists()) {
			response.setContentType("application/octet-stream");

			// file null이면 name 사용
			String downloadName = (file != null && !file.isEmpty()) ? file : filename;

			response.setHeader("Content-Disposition",
					"attachment; filename=\"" + URLEncoder.encode(downloadName, "UTF-8") + "\"");

			Files.copy(files.toPath(), response.getOutputStream());
			response.getOutputStream().flush();
		}
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("boardID") int boardID, HttpSession session) {
		String result = (String) session.getAttribute("userID");

		// 로그인 여부 확인
		if (result == null) {
			return "redirect:/login";
		}
		boardService.delete(boardID);
		return "redirect:/boardlist";
	}

	@GetMapping("/modify")
	public String modify(@RequestParam("boardID") int boardID, Model model, HttpSession session) {
		String result = (String) session.getAttribute("userID");

		// 로그인 여부 확인
		if (result == null) {
			return "redirect:/login";
		}
		BoardVO board = boardService.board(boardID);
		model.addAttribute("board", board);

		return "modify";
	}

	@PostMapping("/modify")
	public String modify(BoardVO boardVO, HttpSession session) {
		String result = (String) session.getAttribute("userID");
		System.out.println("boardid : " + boardVO.getBoardID());
		System.out.println("boardid : " + boardVO.getTitle());
		System.out.println("boardid : " + boardVO.getContent());

		// 로그인 여부 확인
		if (result == null) {
			return "redirect:/login";
		}

		// 게시글 확인
		if (!result.equals(boardVO.getUserID())) {
			return "redirect:/board?boardID=" + boardVO.getBoardID();
		}

		boardService.modify(boardVO);

		return "redirect:/board";
	}

}
