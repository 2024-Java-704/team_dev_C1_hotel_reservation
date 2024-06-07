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
import com.example.demo.repository.InnRepository;

@Controller
public class AdminInnController {
	@Autowired
	InnRepository innRepository;
	
	
	@GetMapping({ "/admin/index/Inn" })
	public String indexInn(
			@RequestParam(value = "id", defaultValue = "") Integer id,
			@RequestParam(value = "categoryId", defaultValue = "") Integer categoryId,
			Model model) {
		List<Inn> inns = null;
		if (id == null) {
			inns=innRepository.findAll();
		}
		if(id!=null){
			inns=innRepository.findByIdByOrderByasc(id);
		}
		if(categoryId!=null) {
			inns=innRepository.findByCategoryId(categoryId);
		}
		model.addAttribute("inn",inns);
		model.addAttribute("id",id);
		model.addAttribute("categoryId",categoryId);
		return "indexInn";
	}
	
	@GetMapping ({"/admin/newinn"})
	public String newInn() {
		return "newInn";
	}
	
	@PostMapping({"/admin/update"})
	public String createInn(
			@RequestParam(value="name",defaultValue="")String name,
			@RequestParam(value="categoryId",defaultValue="")Integer categoryId,
			@RequestParam(value="adress",defaultValue="")String adress,
			@RequestParam(value="prefectureId",defaultValue="")Integer prefectureId,
			Model model) {
		model.addAttribute("name",name);
		model.addAttribute("categoruId",categoryId);
		model.addAttribute("adress",adress);
		model.addAttribute("prefectureId",prefectureId);
		return "createInn";
	}
	
	@GetMapping({"/admin/edit/{id}/inn"})
	public String editInn(
			@PathVariable("id")Integer id,
			Model model
			) {
		model.addAttribute("id",id);
			return "editInn";
	}
	
	@PostMapping({"/admin/edit/{id}/inn"})
	public String updateInn(
			@PathVariable("id")Integer id,
			@RequestParam(value="name",defaultValue="")String name,
			@RequestParam(value="categoryId",defaultValue="")Integer categoryId,
			@RequestParam(value="adress",defaultValue="")String adress,
			@RequestParam(value="prefectureId",defaultValue="")Integer prefectureId,
			Model model
			) {
		model.addAttribute("id",id);
		model.addAttribute("name",name);
		model.addAttribute("categoryId",categoryId);
		model.addAttribute("adress",adress);
		model.addAttribute("prefectureId",prefectureId);
		return "updateInn";
	}
	
	@PostMapping({"/admin/inn/{id}/delete"})
	public String deleteInn(
			@PathVariable("id")Integer id,Model model
			) {
		innRepository.deleteById(id);
		return "redirect:/indexInn";
	}
}
