package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Account;

import jakarta.servlet.http.HttpSession;

@Controller
public class AccountController {
	@Autowired
	HttpSession session;

	@Autowired
	Account account;

	@GetMapping({ "/login", "/logout" })
	public String index(String error, Model model) {
		session.invalidate();

		return "login";
	}

	@PostMapping("/login")
	public String login(String email, String password, Model model) {

		return "";
	}

	@GetMapping("/users/create")
	public String createUser() {
		return "";
	}

	@PostMapping("/users/create")
	public String addUser(String name, String adress, String tel, String email, String zipCode, String password,
			Model model) {
		return "";
	}

	@GetMapping("/mypage")
	public String menuUser() {
		return "";
	}

	@GetMapping("/mypage/users/{id}/edit")
	public String editUser(Integer id) {
		return "";
	}

	@PostMapping("/mypage/users/{id}/edit")
	public String updateUser(Integer id, String name, String adress, String tel, String email, String zipCode,
			String password, Model model) {
		return "";
	}

	@PostMapping("/mypage/users/{id}/delete")
	public String deleteUser(Integer id) {
		return "";
	}

	@GetMapping("/mypage/booked")
	public String detailBook() {
		return "";
	}

	@PostMapping("/mypage/booked/{id}/cancel")
	public String cancelBook(Integer id) {
		return "";
	}

	@GetMapping("/mypage/booked/history")
	public String logBook() {
		return "";
	}

}
