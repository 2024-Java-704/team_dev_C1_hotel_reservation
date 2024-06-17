package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Inn;
import com.example.demo.entity.Photo;
import com.example.demo.entity.Plan;
import com.example.demo.repository.InnRepository;
import com.example.demo.repository.PhotoRepository;
import com.example.demo.repository.PlanRepository;

@Controller
public class AdminInnController {
	@Autowired
	InnRepository innRepository;

	@Autowired
	PhotoRepository photoRepository;

	@Autowired
	PlanRepository planRepository;

	@GetMapping({ "/admin/index/Inn" })
	public String indexInn(
			@RequestParam(value = "id", defaultValue = "") Integer checkId,
			@RequestParam(value = "categoryId", defaultValue = "") Integer checkCategoryId,
			Model model) {
		List<Inn> inns = null;
		List<Inn> checks = innRepository.findAll();
		Integer id = null;
		Integer categoryId = null;

		for (Inn check : checks) {
			if (check.getId() == checkId) {
				id = checkId;
			}

			if (check.getCategoryId() == checkCategoryId) {
				categoryId = checkCategoryId;
			}
		}

		if (id != null) {
			Inn hotel = innRepository.findById(id).get();
			inns = new ArrayList<Inn>();
			inns.add(hotel);
		} else if (categoryId != null) {
			inns = innRepository.findByCategoryId(categoryId);

		} else {
			inns = innRepository.findAllByOrderByIdAsc();
			if (checkId != null || checkCategoryId != null) {
				model.addAttribute("message", "入力した条件に合う宿情報が存在しません");
			}
		}
		model.addAttribute("inns", inns);
		model.addAttribute("id", id);
		model.addAttribute("categoryId", categoryId);
		return "adminInnIndex";
	}

	@GetMapping({ "/admin/newinn" })
	public String newInn() {
		return "newInn";
	}

	@PostMapping({ "/admin/update" })
	public String createInn(
			@RequestParam("name") String name,
			@RequestParam("categoryId") Integer categoryId,
			@RequestParam("zipCode") String zipCode,
			@RequestParam("address") String address,
			@RequestParam("tel") String tel,
			@RequestParam(value = "prefectureId", defaultValue = "0") Integer prefectureId,
			@RequestParam(value = "photo1", defaultValue = "https://x.gd/Pa1vo") String photo1,
			@RequestParam(value = "photo2", defaultValue = "https://x.gd/Pa1vo") String photo2,
			@RequestParam(value = "photo3", defaultValue = "https://x.gd/Pa1vo") String photo3,
			@RequestParam("planName") String planName,
			@RequestParam("price") Integer price,
			Model model) {
		Inn inn = new Inn(categoryId, name, zipCode, address, tel, prefectureId);

		innRepository.save(inn);

		Photo newPhoto1 = new Photo(inn.getId(), photo1);
		Photo newPhoto2 = new Photo(inn.getId(), photo2);
		Photo newPhoto3 = new Photo(inn.getId(), photo3);

		photoRepository.save(newPhoto1);
		photoRepository.save(newPhoto2);
		photoRepository.save(newPhoto3);

		Plan plan = new Plan(inn.getId(), planName, price);

		planRepository.save(plan);

		return "redirect:/admin/index/Inn";
	}

	@GetMapping({ "/admin/edit/{id}/inn" })
	public String editInn(
			@PathVariable("id") Integer id,
			Model model) {
		Inn inn = innRepository.findById(id).get();
		List<Plan> plan = planRepository.findByInnId(inn.getId());

		model.addAttribute("inn", inn);
		model.addAttribute("plans", plan);

		//		List<Photo> photos = photoRepository.findByInnId(inn.getId());
		Photo photo1 = photoRepository.findByInnId(inn.getId()).get(0);
		Photo photo2 = photoRepository.findByInnId(inn.getId()).get(1);
		Photo photo3 = photoRepository.findByInnId(inn.getId()).get(2);

		//		model.addAttribute("photos", photos);
		model.addAttribute("photo1", photo1);
		model.addAttribute("photo2", photo2);
		model.addAttribute("photo3", photo3);

		return "editInn";
	}

	@PostMapping({ "/admin/edit/{id}/inn" })
	public String updateInn(
			@PathVariable("id") Integer id,
			@RequestParam("name") String name,
			@RequestParam("categoryId") Integer categoryId,
			@RequestParam("zipCode") String zipCode,
			@RequestParam("address") String address,
			@RequestParam("tel") String tel,
			@RequestParam(value = "prefectureId", defaultValue = "0") Integer prefectureId,
			@RequestParam(value = "photo1", defaultValue = "https://x.gd/Pa1vo") String photo1,
			@RequestParam(value = "photo2", defaultValue = "https://x.gd/Pa1vo") String photo2,
			@RequestParam(value = "photo3", defaultValue = "https://x.gd/Pa1vo") String photo3,
			@RequestParam("photo1Id") Integer photo1Id,
			@RequestParam("photo2Id") Integer photo2Id,
			@RequestParam("photo3Id") Integer photo3Id,
			@RequestParam("planName") String planName,
			@RequestParam("price") Integer price,
			Model model) {
		Inn inn = new Inn(id, categoryId, name, zipCode, address, tel, prefectureId);

		innRepository.save(inn);

		Photo newPhoto1 = new Photo(photo1Id, inn.getId(), photo1);
		Photo newPhoto2 = new Photo(photo2Id, inn.getId(), photo2);
		Photo newPhoto3 = new Photo(photo3Id, inn.getId(), photo3);

		photoRepository.save(newPhoto1);
		photoRepository.save(newPhoto2);
		photoRepository.save(newPhoto3);

		return "redirect:/admin/index/Inn";
	}

	@PostMapping({ "/admin/inn/{id}/delete" })
	public String deleteInn(
			@PathVariable("id") Integer id, Model model) {
		innRepository.deleteById(id);
		return "redirect:/admin/index/Inn";
	}
}
