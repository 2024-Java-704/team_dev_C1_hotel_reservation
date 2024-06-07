package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminInnController {
	@GetMapping({"/admin/index/Inn"})
	public String indexInn(
			@RequestParam(value="id",defaultValue="")Integer id,
			@RequestParam(value="categoryId",defaultValue="")Integer categoryId,
			Model model
			) {
		if(id==null) {
			
		}
		return "";
	}
}
