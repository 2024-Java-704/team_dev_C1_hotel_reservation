package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AccountController {
	@Autowired
	HttpSession session;

	@Autowired
	Account account;

	@Autowired
	UserRepository userRepository;

	@Autowired
	BookRepository bookRepository;

	@GetMapping({ "/login", "/logout" })
	public String index(String error, Model model) {
		session.invalidate();

		return "";
	}

	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
		List<User> users = userRepository.findByEmailAndPassword(email, password);

		if (users.size() == 0) {
			//メアドとパスワードの不一致

			model.addAttribute("email", email);

			return "";
		}

		account.setId(users.get(0).getId());

		return "";
	}

	@GetMapping("/users/create")
	public String createUser(
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "birthday", defaultValue = "") Date birthday,
			@RequestParam(name = "address", defaultValue = "") String address,
			@RequestParam(name = "tel", defaultValue = "") String tel,
			@RequestParam(name = "email", defaultValue = "") String email,
			@RequestParam(name = "zipCode", defaultValue = "") String zipCode,
			Model model) {
		model.addAttribute("name", name);
		model.addAttribute("birthday", birthday);
		model.addAttribute("tel", address);
		model.addAttribute("tel", tel);
		model.addAttribute("email", email);
		model.addAttribute("zipCode", zipCode);

		return "";
	}

	@PostMapping("/users/create")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("birthday") Date birthday,
			@RequestParam("address") String address,
			@RequestParam("tel") String tel,
			@RequestParam("email") String email,
			@RequestParam("zipCode") String zipCode,
			@RequestParam("password") String password,
			Model model) {
		List<User> users = userRepository.findByEmail(email);

		if (users.size() != 0) {
			//メアドが既に存在

			return "";
		}

		Date registration = new Date();
		User user = new User(name, birthday, address, tel, email, zipCode, password, registration);

		userRepository.save(user);

		return "";
	}

	@GetMapping("/mypage")
	public String menuUser() {
		return "";
	}

	@GetMapping("/mypage/users/edit")
	public String editUser(Model model) {
		User user = userRepository.findById(account.getId()).get();

		model.addAttribute("user", user);

		return "";
	}

	@PostMapping("/mypage/users/edit")
	public String updateUser(
			@RequestParam("name") String name,
			@RequestParam("birthday") Date birthday,
			@RequestParam("address") String address,
			@RequestParam("tel") String tel,
			@RequestParam("email") String email,
			@RequestParam("zipCode") String zipCode,
			@RequestParam("password") String password,
			Model model) {
		User user = new User(account.getId(), name, birthday, address, tel, email, zipCode, password);

		userRepository.save(user);

		return "";
	}

	@PostMapping("/mypage/users/delete")
	public String deleteUser() {
		if (account == null || account.getId() == null) {
			return "";
		}

		//アカウントに紐づいた情報の削除処理

		session.invalidate();
		userRepository.deleteById(account.getId());

		return "";
	}

	@GetMapping("/mypage/booked")
	public String detailBook(Model model) {
		List<Book> bookList = bookRepository.findByUserId(account.getId());
		List<Book> books = new ArrayList<Book>();

		Date date = new Date();

		for (Book book : bookList) {
			if ((book.getOutDate().compareTo(date)) >= 0) {
				books.add(book);
			}
		}

		model.addAttribute("books", books);

		return "";
	}

	@PostMapping("/mypage/booked/{id}/cancel")
	public String cancelBook(Integer id) {
		bookRepository.deleteById(id);

		return "";
	}

	@GetMapping("/mypage/booked/history")
	public String logBook(Model model) {
		List<Book> bookList = bookRepository.findByUserId(account.getId());
		List<Book> books = new ArrayList<Book>();

		Date date = new Date();

		for (Book book : bookList) {
			if ((book.getOutDate().compareTo(date)) != 0) {
				books.add(book);
			}
		}

		model.addAttribute("books", books);

		return "";
	}

}
