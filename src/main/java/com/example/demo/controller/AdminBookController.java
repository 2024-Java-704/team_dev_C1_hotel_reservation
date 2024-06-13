package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Book;
import com.example.demo.entity.Inn;
import com.example.demo.entity.Payment;
import com.example.demo.entity.Plan;
import com.example.demo.entity.User;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.InnRepository;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.repository.PlanRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class AdminBookController {
	@Autowired
	UserRepository userRepository;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	InnRepository innRepository;

	@Autowired
	PlanRepository planRepository;

	@Autowired
	PaymentRepository paymentRepository;

	@GetMapping({ "/admin/index/book" })
	public String indexBook(
			@RequestParam(value = "id", defaultValue = "") Integer id,
			@RequestParam(value = "planId", defaultValue = "") Integer planId,
			@RequestParam(value = "userId", defaultValue = "") Integer userId,
			Model model) {
		List<Book> books = null;
		if (id == null && planId == null && userId == null) {
			books = bookRepository.findAllByOrderByIdAsc();
		} else if (id != null && planId == null && userId == null) {
			Book hotel = bookRepository.findById(id).get();
			books = new ArrayList<Book>();
			books.add(hotel);
		} else if (id == null && planId != null && userId == null) {
			books = bookRepository.findByPlanId(planId);
		} else if (id == null && planId == null && userId != null) {
			books = bookRepository.findByUserId(userId);
		} else if (id != null && planId != null && userId == null) {
			books = bookRepository.findByIdAndPlanId(id, planId);
		} else if (id != null && planId == null && userId != null) {
			books = bookRepository.findByIdAndUserId(id, userId);
		} else if (id == null && planId != null && userId != null) {
			books = bookRepository.findByPlanIdAndUserId(planId, userId);
		} else {
			books = bookRepository.findByIdAndPlanIdAndUserId(id, planId, userId);
		}
		model.addAttribute("books", books);
		return "adminBookIndex";
	}

	@GetMapping({ "/admin/edit/{id}/book" })
	public String editBook(
			@PathVariable("id") Integer id, Model model) {
		Book book = bookRepository.findById(id).get();
		model.addAttribute("book", book);
		return "updateBook";
	}

	@PostMapping({ "/admin/edit/{id}/book" })
	public String updateBook(
			@PathVariable("id") Integer id,
			@RequestParam(value = "paymentId") Integer paymentId,
			@RequestParam(value = "userId") Integer userId,
			@RequestParam(value = "planId") Integer planId,
			@RequestParam(value = "adultNum") Integer adultNum,
			@RequestParam(value = "childNum") Integer childNum,
			@RequestParam(value = "bookingDate") Date bookingDate,
			@RequestParam(value = "inDate") Date inDate,
			@RequestParam(value = "outDate") Date outDate,
			@RequestParam(value = "innId") Integer innId,
			Model model) {
		System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkk"+paymentId);
		Payment payment = paymentRepository.findById(paymentId).get();
		User user = userRepository.findById(userId).get();
		Plan plan = planRepository.findById(planId).get();
		Inn inn = innRepository.findById(innId).get();

		Integer totalPrice = plan.getPrice();

		Book book = new Book(id, user, inn, plan, adultNum, childNum, totalPrice, payment, inDate, outDate,
				bookingDate);

		bookRepository.save(book);

		return "redirect:/admin/index/book";
	}

	@PostMapping({ "/admin/book/{id}/delete" })
	public String deleteBook(
			@PathVariable("id") Integer id) {
		bookRepository.deleteById(id);
		return "redirect:/admin/index/book";
	}

}
