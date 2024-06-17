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
		//		if (!(password.equals(administrator.getPassword()))) {
		//			model.addAttribute("error", "パスワードが一致しませんでした");}
		// 名前又はパスワードが空の場合にエラーとする
		if (name.length() == 0 || password.length() == 0) {
			model.addAttribute("message", "入力してください");
			return "/adminlogin";
		}

		List<Administrator> userList = administratorRepository.findByNameAndPassword(name, password);
		if (userList == null || userList.size() == 0) {
			// 存在しなかった場合
			model.addAttribute("message", "パスワードが一致しませんでした");
			return "/adminlogin";
		}
		return "redirect:/adminTop";
		//		model.addAttribute("name", name);
	}

	@GetMapping("/adminTop")
	public String AdminTop() {

		return "adminTop";
	}

	@GetMapping("/admin/index/user")
	public String AdminIndexUser(
			@RequestParam(value = "id", defaultValue = "") Integer checkId,
			Model model) {
		List<User> users = null;
		List<User> checks = userRepository.findAll();
		Integer id = null;
		for (User check : checks) {
			if (check.getId() == checkId) {
				id = checkId;
			}
		}
		if (id == null) {
			users = userRepository.findAllByOrderByIdAsc();
			if (checkId != null) {
				model.addAttribute("message", "入力したIDと一致する会員が見つかりませんでした");
			}
		} else {
			users = new ArrayList<User>();

			User user = userRepository.findById(id).get();
			users.add(user);
		}

		/*		if(users.size()==0)
				{
					users=userRepository.findAllByOrderByIdAsc();
					model.addAttribute("massage","入力したIDと一致する会員が見つかりませんでした");
				}*/

		model.addAttribute("users", users);
		return "AdminIndexUser";
	}

	@GetMapping("/admin/edit/{id}/user")
	public String AdminEditUser(
			@PathVariable("id") Integer id, Model model) {
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
			@RequestParam(value = "password", defaultValue = "") String password,
			Model model) {
		User user = userRepository.findById(id).get();

		user.setName(name);
		user.setAddress(address);
		user.setTel(tel);
		user.setEmail(email);
		user.setZipCode(zipCode);
		user.setPassword(password);

		userRepository.save(user);
		return "redirect:/admin/index/user";
	}

	@PostMapping({ "/admin/user/{id}/delete" })
	public String AdeminDeleteUser(
			@PathVariable("id") Integer id, Model model) {
		userRepository.deleteById(id);
		return "redirect:/admin/index/user";
	}

}
