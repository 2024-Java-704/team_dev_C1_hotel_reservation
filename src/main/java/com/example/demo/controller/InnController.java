package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Inn;
import com.example.demo.entity.Review;
import com.example.demo.repository.InnRepository;

@Controller
public class InnController {
	@Autowired
	InnRepository innRepository;

	@GetMapping("/")
	public String index(
			@RequestParam(name = "keyword", defaultValue = "") String keyword,
			Model model) {
		List<Inn> inns = null;

		if (!keyword.equals("")) {
			inns = innRepository.findByName("%" + keyword + "%");
		} else {
			inns = innRepository.findAll();
		}

		model.addAttribute("keyword", keyword);
		model.addAttribute("inns", inns);

		return "";
	}

	@GetMapping("/detail/{id}")
	public String detailInn(Integer id, Model model) {
		Inn inn = innRepository.findById(id).get();

		model.addAttribute("inn", inn);

		return "";
	}

	@PostMapping("/review/add/{id}")
	public String addReview(@PathVariable("id") Integer id, @RequestParam("content") String content,
			@RequestParam("rank_id") Integer rank_id) {
		Review review = new Review(content, rank_id, id);

		return "";
	}

}
