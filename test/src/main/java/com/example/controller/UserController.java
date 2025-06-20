package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.UserService;
import com.example.vo.UserVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/register")
	public String register(UserVO userVO) {
//		System.out.println("register con : " + userVO.getUserID() + " " + userVO.getUserPW());

		userService.register(userVO);

		return "redirect:/login";

	}

	@GetMapping("/login")
	public String login(HttpSession session) {
		String result = (String) session.getAttribute("userID");
//		System.out.println("result get : " + result);

		if (result != null) {
			return "redirect:/boardlist";
		}
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam("userID") String userID, @RequestParam("userPW") String userPW,
			HttpSession session) {
//		System.out.println("login con : " + userID + " " + userPW);

		String result = userService.login(userID, userPW);

		// 로그인 안되어있으면
		if (result == null || !result.equals(userID)) {
			return "redirect:/login";
		}

		session.setAttribute("userID", result);
		System.out.println("result post : " + result);

		String sessionID = (String) session.getAttribute("userID");

		// 아이디확인 후 성공하면
		if (sessionID != null && sessionID.equals(userID)) {
			return "redirect:/boardlist";
		}

		return "redirect:/login";

	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

}
