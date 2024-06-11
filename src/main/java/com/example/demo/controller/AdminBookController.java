package com.example.demo.controller;

import java.util.Date;

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

	//	@GetMapping({ "/admin/index/book" })
	//	public String indexBook(
	//			@RequestParam(value = "id", defaultValue = "") Integer id,
	//			@RequestParam(value = "planId", defaultValue = "") Integer planId,
	//			@RequestParam(value = "userId", defaultValue = "") Integer userId,
	//			Model model) {
	//		List<Book> books = null;
	//		if (id == null && planId == null && userId == null) {
	//			books = bookRepository.findAllByOrderByasc();
	//		} else if (id != null && planId == null && userId == null) {
	//			books = bookRepository.findByIdByOrderByasc(id);
	//		} else if (id == null && planId != null && userId == null) {
	//			books = bookRepository.findByPlanId(planId);
	//		} else if (id == null && planId == null && userId != null) {
	//			books = bookRepository.findByUserId(userId);
	//		} else if (id != null && planId != null && userId == null) {
	//			books = bookRepository.findByIdAndPlanId(id, planId);
	//		} else if (id != null && planId == null && userId != null) {
	//			books = bookRepository.findByIdAndUserId(id, userId);
	//		} else if (id == null && planId != null && userId != null) {
	//			books = bookRepository.findByPlanIdAndUserId(planId, userId);
	//		} else {
	//			books = bookRepository.findByIdAndPlanIdAndUserId(id, planId, userId);
	//		}
	//		model.addAttribute("book", books);
	//		return "indexBook";
	//	}

	@GetMapping({ "/admin/edit/{id}/book" })
	public String editBook(
			@PathVariable("id") Integer id, Model model) {
		Book book = bookRepository.findById(id).get();
		model.addAttribute("book", book);
		return "editBook";
	}

	@PostMapping({ "/admin/edit/{id}/book" })
	public String updateBook(
			@PathVariable("id") Integer id,
			@RequestParam(value = "paymentId", defaultValue = "") Integer paymentId,
			@RequestParam(value = "userId", defaultValue = "") Integer userId,
			@RequestParam(value = "planId", defaultValue = "") Integer planId,
			@RequestParam(value = "adultNum", defaultValue = "") Integer adultNum,
			@RequestParam(value = "childNum", defaultValue = "") Integer childNum,
			@RequestParam(value = "bookingDate", defaultValue = "") Date bookingDate,
			@RequestParam(value = "inDate", defaultValue = "") Date inDate,
			@RequestParam(value = "outDate", defaultValue = "") Date outDate,
			@RequestParam(value = "innId", defaultValue = "") Integer innId,
			Model model) {
		Payment payment = paymentRepository.findById(paymentId).get();
		User user = userRepository.findById(userId).get();
		Plan plan = planRepository.findById(planId).get();
		Inn inn = innRepository.findById(innId).get();
		/*		model.addAttribute("userId", userId);
				model.addAttribute("paymentId", paymentId);
				model.addAttribute("planId", planId);
				model.addAttribute("bookingDate", bookingDate);
				model.addAttribute("inDate", inDate);
				model.addAttribute("outDate", outDate);*/
		//Book book = new Book(id, paymentId, userId, planId, adultNum, childNum, bookingDate, inDate, outDate, innId);
		Book book = new Book(id, payment, user, plan, adultNum, childNum, bookingDate, inDate, outDate, inn);
		bookRepository.save(book);
		return "updateBook";
	}

	@PostMapping({ "/admin/book/{id}/delete" })
	public String deleteBook(
			@PathVariable("id") Integer id) {
		bookRepository.deleteById(id);
		return "redirect:indexBook";
	}

}
