package com.example.demo.controller;

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
import com.example.demo.repository.BookRepository;

@Controller
public class AdminBookController {
	@Autowired
	BookRepository bookRepository;

	@GetMapping({ "/admin/index/book" })
	public String indexBook(
			@RequestParam(value = "id", defaultValue = "") Integer id,
			@RequestParam(value = "planId", defaultValue = "") Integer planId,
			Model model) {
		List<Book> books = null;
		if (id == null && planId == null) {
			books = bookRepository.findAllByOrderByasc();
		} else if (id != null && planId == null) {
			books = bookRepository.findByUserId(id);
		} else if (id == null && planId != null) {
			books = bookRepository.findByPlanId(planId);
		} else {
			books = bookRepository.findByPlanIdAndUserId(id, planId);
		}
		model.addAttribute("book",books);
		return "indexBook";
	}

	@GetMapping({ "/admin/edit/{id}/book" })
	public String editBook(
			@PathVariable("id") Integer id, Model model) {
		model.addAttribute("id", id);
		return "editBook";
	}

	@PostMapping({ "/admin/edit/{id}/book" })
	public String updateBook(
			//			@PathVariable("id")Integer id,
			@RequestParam(value = "paymentId", defaultValue = "") Integer paymentId,
			@RequestParam(value = "userId", defaultValue = "") Integer userId,
			@RequestParam(value = "planId", defaultValue = "") Integer planId,
			@RequestParam(value = "bookingDate", defaultValue = "") Date bookingDate,
			@RequestParam(value = "inDate", defaultValue = "") Date inDate,
			@RequestParam(value = "outDate", defaultValue = "") Date outDate,
			Model model) {
		model.addAttribute("userId", userId);
		model.addAttribute("paymentId", paymentId);
		model.addAttribute("planId", planId);
		model.addAttribute("bookingDate", bookingDate);
		model.addAttribute("inDate", inDate);
		model.addAttribute("outDate", outDate);
		return "updateBook";
	}
	
	@PostMapping({"/admin/book/{id}/delete"})
	public String deleteBook(
			@PathVariable("id")Integer id
			) {
		bookRepository.deleteById(id);
		return "redirect:indexBook";
	}

}
