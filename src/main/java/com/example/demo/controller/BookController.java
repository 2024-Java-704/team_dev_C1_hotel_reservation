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
public class BookController {
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

	@GetMapping("/book/{id}")
	public String createBook(@PathVariable("id") Integer id, Model model) {
		Plan plan = planRepository.findById(id).get();

		Inn inn = innRepository.findById(plan.getInn().getId()).get();

		model.addAttribute("inn", inn);
		model.addAttribute("plan", plan);

		return "";
	}

	@GetMapping("/book/{id}")
	public String confirmBook(
			@PathVariable("id") Integer id,
			@RequestParam("paymentId") Integer paymentId,
			@RequestParam("userId") Integer userId,
			@RequestParam("planId") Integer planId,
			@RequestParam("adultNum") Integer adultNum,
			@RequestParam("childNum") Integer childNum,
			@RequestParam("bookingDate") Date bookingDate,
			@RequestParam("inDate") Date inDate,
			@RequestParam("outDate") Date outDate,
			@RequestParam("innId") Integer innId,
			Model model) {
		model.addAttribute("id", id);
		model.addAttribute("paymentId", paymentId);
		model.addAttribute("userId", userId);
		model.addAttribute("planId", planId);
		model.addAttribute("adultNum", adultNum);
		model.addAttribute("childNum", childNum);
		model.addAttribute("bookingDate", bookingDate);
		model.addAttribute("inDate", inDate);
		model.addAttribute("outDate", outDate);
		model.addAttribute("innId", innId);

		return "";
	}

	@PostMapping("/book/{id}/confirm")
	public String addBook(
			@PathVariable("id") Integer id,
			@RequestParam("paymentId") Integer paymentId,
			@RequestParam("userId") Integer userId,
			@RequestParam("planId") Integer planId,
			@RequestParam("adultNum") Integer adultNum,
			@RequestParam("childNum") Integer childNum,
			@RequestParam("bookingDate") Date bookingDate,
			@RequestParam("inDate") Date inDate,
			@RequestParam("outDate") Date outDate,
			@RequestParam("innId") Integer innId,
			Model model) {
		Payment payment = paymentRepository.findById(paymentId).get();
		User user = userRepository.findById(userId).get();
		Plan plan = planRepository.findById(planId).get();
		Inn inn = innRepository.findById(innId).get();

		Book book = new Book(payment, user, plan, adultNum, childNum, bookingDate, inDate, outDate, inn);

		bookRepository.save(book);

		return "";
	}

	@GetMapping("/book/finish")
	public String finishBook() {
		return "";
	}
}
