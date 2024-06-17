package com.example.demo.controller;

import java.sql.Date;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Book;
import com.example.demo.entity.History;
import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.HistoryRepository;
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
	
	@Autowired
	HistoryRepository historyRepository;

	@GetMapping({ "/login", "/logout" })
	public String index(String error, Model model) {
		session.invalidate();

		return "login";
	}

	@PostMapping("/login")
	public String login(
			@RequestParam("email") String email,
			@RequestParam("password") String password, Model model) {
		if (email.length() == 0 || password.length() == 0) {
			model.addAttribute("message", "入力してください");
			model.addAttribute("email", email);
			return "login";
		}

		List<User> userList = userRepository.findByEmailAndPassword(email, password);

		if (userList == null || userList.size() == 0) {
			model.addAttribute("message", "メールアドレスとパスワードが一致しませんでした");
			return "login";
		}
		User user = userList.get(0);

		account.setId(user.getId());
		account.setName(user.getName());
		account.setBirthday(user.getBirthday());
		account.setAddress(user.getAddress());
		account.setTel(user.getTel());
		account.setEmail(user.getEmail());
		account.setZipCode(user.getZipCode());

		return "redirect:/";
	}

	@GetMapping("/users/create")
	public String createUser(
	/*	@RequestParam(name = "name", defaultValue = "") String name,
		@RequestParam(name = "birthday", defaultValue = "") Date birthday,
		@RquestParam(name = "address", defaultValue = "") String address,
		@RequestParam(name = "tel", defaultValue = "") String tel,
		@RequestParam(name = "email", defaultValue = "") String email,
		@RequestParam(name = "zipCode", defaultValue = "") String zipCode,
		Model model*/) {
		/*	model.addAttribute("name", name);
			model.addAttribute("birthday", birthday);
			model.addAttribute("tel", address);
			model.addAttribute("tel", tel);
			model.addAttribute("email", email);
			model.addAttribute("zipCode", zipCode);*/

		return "createUser";
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

			return "redirect:/users/create";
		}

		java.util.Date registration = new java.util.Date();

		User user = new User(name, birthday, address, tel, email, zipCode, password, registration);

		userRepository.save(user);

		account.setId(user.getId());
		account.setName(user.getName());
		account.setBirthday(user.getBirthday());
		account.setAddress(user.getAddress());
		account.setTel(user.getTel());
		account.setEmail(user.getEmail());
		account.setZipCode(user.getZipCode());

		return "redirect:/";
	}

	@GetMapping("/mypage")
	public String menuUser() {
		return "menuUser";
	}

	@GetMapping("/mypage/users/edit")
	public String editUser(Model model) {
		User user = userRepository.findById(account.getId()).get();
		System.out.println(user.getName());
		model.addAttribute("user", user);

		return "updateUser";
	}

	@PostMapping("/mypage/users/edit")
	public String updateUser(
			@RequestParam("name") String name,
			@RequestParam("address") String address,
			@RequestParam("tel") String tel,
			@RequestParam("email") String email,
			@RequestParam("zipCode") String zipCode,
			@RequestParam("password") String password,
			Model model) {
		User user = userRepository.findById(account.getId()).get();

		user.setName(name);
		user.setAddress(address);
		user.setTel(tel);
		user.setEmail(email);
		user.setZipCode(zipCode);
		user.setPassword(password);

		userRepository.save(user);

		return "menuUser";
	}

	@PostMapping("/mypage/users/delete")
	public String deleteUser() {
		if (account == null || account.getId() == null) {
			return "menuUser";
		}

		List<Book> bookList = bookRepository.findByUserId(account.getId());

		for (Book book : bookList) {
			if (book.getId() == account.getId()) {
				bookRepository.deleteById(book.getId());
			}
		}

		userRepository.deleteById(account.getId());

		session.invalidate();

		return "redirect:/";
	}

	@GetMapping("/mypage/booked")
	public String detailBook(Model model) {
		List<Book> bookList = bookRepository.findByUserId(account.getId());
		List<Book> books = new ArrayList<Book>();

		java.util.Date date = new java.util.Date();

		for (Book book : bookList) {
			if ((book.getOutDate().compareTo(date)) >= 0) {
				books.add(book);
			}
		}

		model.addAttribute("books", books);

		return "detailBook";
	}

	@PostMapping("/mypage/booked/{id}/cancel")
	public String cancelBook(@PathVariable("id") Integer id) {
		bookRepository.deleteById(id);

		return "redirect:/mypage/booked";
	}

	@GetMapping("/mypage/booked/history")
	public String logBook(Model model) {
		List<Book> bookList = bookRepository.findByUserId(account.getId());
		List<Book> books = new ArrayList<Book>();

		java.util.Date date = new java.util.Date();

		for (Book book : bookList) {
			if ((book.getOutDate().compareTo(date)) < 0) {
				books.add(book);
			}
		}

		model.addAttribute("books", books);

		return "logBook";
	}

	@GetMapping("/mypage/history")
	public String viewHistory(Model model) {
		List<History> historyList = historyRepository.findByUserId(account.getId());
		List<History> histories = new ArrayList<History>();

		for (History history : historyList) {
			histories.add(history);

		}
		model.addAttribute("histories" , histories);
		
		return "viewHistory";
	}

}
