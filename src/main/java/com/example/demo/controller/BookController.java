package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.example.demo.model.Account;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.InnRepository;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.repository.PlanRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class BookController {
	@Autowired
	Account account;

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
	public String createBook(@PathVariable("id") Integer id,
	        @DateTimeFormat(pattern = "yyyy年MM月dd日") @RequestParam(name = "inDate", defaultValue = "") LocalDate inDate,
	        @DateTimeFormat(pattern = "yyyy年MM月dd日") @RequestParam(name = "outDate", defaultValue = "") LocalDate outDate,
	        @RequestParam(name = "adultNum", defaultValue = "1") Integer adultNum,
	        @RequestParam(name = "childNum", defaultValue = "0") Integer childNum,
	        @RequestParam(name = "paymentId", defaultValue = "1") Integer paymentId,
	        Model model) {
		
	
		
	    Plan plan = planRepository.findById(id).orElseThrow();
	    Inn inn = innRepository.findById(plan.getInnId()).orElseThrow();
	    Payment payment = paymentRepository.findById(paymentId).orElseThrow();

	    model.addAttribute("InDate", inDate);
	    model.addAttribute("OutDate", outDate);
	    model.addAttribute("inn", inn);
	    model.addAttribute("plan", plan);
	    model.addAttribute("adultNum", adultNum);
	    model.addAttribute("childNum", childNum);
	    model.addAttribute("payment", payment);
	  
	    return "book";
	}


	@GetMapping("/book/confirm")
	public String confirmBook(
			@RequestParam("innId") Integer innId,
			@RequestParam("planId") Integer planId,
			@RequestParam("adultNum") Integer adultNum,
			@RequestParam("childNum") Integer childNum,

			
			@RequestParam("inDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date inDateData,
			@RequestParam("outDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date outDateData,
			@RequestParam("paymentId") Integer paymentId,
			Model model) {
		Inn inn = innRepository.findById(innId).get();
		Plan plan = planRepository.findById(planId).get();
		Payment payment = paymentRepository.findById(paymentId).get();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
		String inDate = dateFormat.format(inDateData);
		String outDate = dateFormat.format(outDateData);

		model.addAttribute("inn", inn);
		model.addAttribute("plan", plan);
		model.addAttribute("adultNum", adultNum);
		model.addAttribute("childNum", childNum);
		model.addAttribute("inDate", inDate);
		model.addAttribute("outDate", outDate);
		model.addAttribute("payment", payment);

		return "bookDetail";
	}

	@PostMapping("/book/confirm")
	public String addBook(
			@RequestParam("innId") Integer innId,
			@RequestParam("planId") Integer planId,
			@RequestParam("adultNum") Integer adultNum,
			@RequestParam("childNum") Integer childNum,
			@RequestParam("inDate") String inDateStr,
			@RequestParam("outDate") String outDateStr,
			@RequestParam("paymentId") Integer paymentId,
			Model model) throws ParseException {
		Inn inn = innRepository.findById(innId).get();
		Plan plan = planRepository.findById(planId).get();
		Payment payment = paymentRepository.findById(paymentId).get();
		User user = userRepository.findById(account.getId()).get();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
		Date inDate = dateFormat.parse(inDateStr);
		Date outDate = dateFormat.parse(outDateStr);

		Integer totalPrice = plan.getPrice();
		java.util.Date bookingDate = new java.util.Date();

		Book book = new Book(user, inn, plan, adultNum, childNum, totalPrice, payment, inDate, outDate,
				bookingDate);

		bookRepository.save(book);

		return "redirect:/book/finish";
	}

	@GetMapping("/book/finish")
	public String finishBook() {
		return "bookFinish";
	}
}
