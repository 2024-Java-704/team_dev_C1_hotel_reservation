package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminAccountController {
	@Autowired
	HttpSession session;

	@GetMapping({ "/admin/login", "/admin/logout" })
	public String index() {
		session.invalidate();
		return "adominlogin";
	}

	@PostMapping({ "/admin/login" })
	public String login(
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "password", defaultValue = "") String password,
			Model model) {
		//		administrator.setName(name);
		return "redirect:/login";
	}

	@GetMapping({ "/admin/index/user" })
	public String AdminIndexUser(
			@PathVariable("id") Integer id,
			Model model) {
		model.addAttribute(id);
		return "AdminIndexUser";
	}

	@GetMapping({ "/admin/edit/{id}/user" })
	public String AdminEditUser(
			@PathVariable("id") Integer id,
			Model model) {
		model.addAttribute(id);
		return "AdminEditUser";
	}

	@PostMapping("/admin/edit/{id}/user")
	public String AdminUpdateUser(
			@PathVariable("id") Integer id,
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "adress", defaultValue = "") String adress,
			@RequestParam(value = "tel", defaultValue = "") String tel,
			@RequestParam(value = "email", defaultValue = "") String email,
			@RequestParam(value = "zipCode", defaultValue = "") String zipCode,
			@RequestParam(value = "password", defaultValue = "") String password,
			Model model) {
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		model.addAttribute("adress", adress);
		model.addAttribute("tel", tel);
		model.addAttribute("email", email);
		model.addAttribute("zipCode", zipCode);
		model.addAttribute("password", password);
		return "AdminUpdateUser";
	}

	@PostMapping({ "/admin/user/{id}/delete" })
	public String AdeminDeleteUser(
			@PathVariable("id") Integer id, Model model) {
		//		userRepository.deleteById(id);
		return "redirect:AdminIndexUser";
	}

}
