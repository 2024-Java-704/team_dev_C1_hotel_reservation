package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Administrator;
import com.example.demo.entity.User;
import com.example.demo.repository.AdministratorRepository;
import com.example.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminAccountController {
	@Autowired
	HttpSession session;

	@Autowired
	UserRepository userRepository;

	@Autowired
	AdministratorRepository administratorRepository;

	Administrator administrator = new Administrator();

	@GetMapping({ "/admin/login", "/admin/logout" })
	public String index() {
		session.invalidate();
		return "adminlogin";
	}

	@PostMapping({ "/admin/login" })
	public String login(
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "password", defaultValue = "") String password,
			Model model) {
		if (!(password.equals(administrator.getPassword()))) {
			model.addAttribute("error", "パスワードが一致しませんでした");
			return "redirect:/adminlogin";
		}
		model.addAttribute("name", name);
		return "adminTop";
	}

	@GetMapping("/admin/index/user")
	public String AdminIndexUser(
			@RequestParam(value = "id", defaultValue = "") Integer id,
			Model model) {
		List<User> users = null;
		if (id == null) {
			users = userRepository.findAllByOrderByIdAsc();
		} else {
			users = new ArrayList<User>();

			User user = userRepository.findById(id).get();
			users.add(user);
		}

		model.addAttribute("user", users);
		return "AdminIndexUser";
	}

	@GetMapping("/admin/edit/{id}/user")
	public String AdminEditUser(@PathVariable("id") Integer id, Model model) {
		User user = userRepository.findById(id).get();

		model.addAttribute("user", user);

		return "AdminEditUser";
	}

	@PostMapping("/admin/edit/{id}/user")
	public String AdminUpdateUser(
			@PathVariable("id") Integer id,
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "address", defaultValue = "") String address,
			@RequestParam(value = "tel", defaultValue = "") String tel,
			@RequestParam(value = "email", defaultValue = "") String email,
			@RequestParam(value = "zipCode", defaultValue = "") String zipCode,
			@RequestParam(value = "birthday", defaultValue = "") Date birthday,
			@RequestParam(value = "registration", defaultValue = "") Date registration,
			@RequestParam(value = "password", defaultValue = "") String password,
			Model model) {
		//		model.addAttribute("id", id);
		//		model.addAttribute("name", name);
		//		model.addAttribute("address", address);
		//		model.addAttribute("tel", tel);
		//		model.addAttribute("email", email);
		//		model.addAttribute("zipCode", zipCode);
		//		model.addAttribute("birthday", birthday);
		//		model.addAttribute("registration", registration);
		User user = new User(id, name, birthday, address, tel, email, zipCode, registration, password);
		userRepository.save(user);
		return "AdminIndexUser";
	}

	@PostMapping({ "/admin/user/{id}/delete" })
	public String AdeminDeleteUser(
			@PathVariable("id") Integer id, Model model) {
		userRepository.deleteById(id);
		return "redirect:AdminIndexUser";
	}

}
