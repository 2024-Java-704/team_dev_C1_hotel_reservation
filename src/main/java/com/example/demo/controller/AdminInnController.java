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

import com.example.demo.entity.Category;
import com.example.demo.entity.HighClass;
import com.example.demo.entity.HotSpring;
import com.example.demo.entity.Inn;
import com.example.demo.entity.Photo;
import com.example.demo.entity.Plan;
import com.example.demo.entity.Prefecture;
import com.example.demo.entity.Walk;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.HighClassRepository;
import com.example.demo.repository.HotSpringRepository;
import com.example.demo.repository.InnRepository;
import com.example.demo.repository.PhotoRepository;
import com.example.demo.repository.PlanRepository;
import com.example.demo.repository.PrefectureRepository;
import com.example.demo.repository.WalkRepository;

@Controller
public class AdminInnController {
	@Autowired
	InnRepository innRepository;

	@Autowired
	PhotoRepository photoRepository;

	@Autowired
	PlanRepository planRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	PrefectureRepository prefectureRepository;

	@Autowired
	HotSpringRepository hotSpringRepository;

	@Autowired
	WalkRepository walkRepository;

	@Autowired
	HighClassRepository highClassRepository;

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

			if (check.getCategory().getId() == checkCategoryId) {
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
	public String newInn(Model model) {
		List<Category> categories = categoryRepository.findAll();
		List<Prefecture> prefectures = prefectureRepository.findAll();

		model.addAttribute("categories", categories);
		model.addAttribute("prefectures", prefectures);
		return "newInn";
	}

	@PostMapping({ "/admin/update" })
	public String createInn(
			@RequestParam("name") String name,
			@RequestParam("categoryId") Integer categoryId,
			@RequestParam("zipCode") String zipCode,
			@RequestParam("address") String address,
			@RequestParam("tel") String tel,
			@RequestParam("prefectureId") Integer prefectureId,
			@RequestParam(value = "photo1", defaultValue = "https://x.gd/Pa1vo") String photo1,
			@RequestParam(value = "photo2", defaultValue = "https://x.gd/Pa1vo") String photo2,
			@RequestParam(value = "photo3", defaultValue = "https://x.gd/Pa1vo") String photo3,
			@RequestParam(name = "hotSpring", defaultValue = "") String hotSpring,
			@RequestParam(name = "walk", defaultValue = "") String walk,
			@RequestParam(name = "highClass", defaultValue = "") String highClass,
			@RequestParam("planName") String planName,
			@RequestParam("price") Integer price,
			Model model) {
		Category category = categoryRepository.findById(categoryId).get();
		Prefecture prefecture = prefectureRepository.findById(categoryId).get();

		Inn inn = new Inn(category, name, zipCode, address, tel, prefecture);

		innRepository.save(inn);

		Photo newPhoto1 = new Photo(inn.getId(), photo1);
		Photo newPhoto2 = new Photo(inn.getId(), photo2);
		Photo newPhoto3 = new Photo(inn.getId(), photo3);

		photoRepository.save(newPhoto1);
		photoRepository.save(newPhoto2);
		photoRepository.save(newPhoto3);

		if (hotSpring != null) {
			HotSpring spring = new HotSpring(inn.getId());
			hotSpringRepository.save(spring);
		}

		if (walk != null) {
			Walk w = new Walk(inn.getId());
			walkRepository.save(w);
		}

		if (highClass != null) {
			HighClass hClass = new HighClass(inn.getId());
			highClassRepository.save(hClass);
		}

		Plan plan = new Plan(inn.getId(), planName, price);

		planRepository.save(plan);

		return "redirect:/admin/index/Inn";
	}

	@GetMapping({ "/admin/edit/{id}/inn" })
	public String editInn(
			@PathVariable("id") Integer id,
			Model model) {
		Inn inn = innRepository.findById(id).get();
		List<Plan> plans = planRepository.findByInnId(inn.getId());
		List<Category> categories = categoryRepository.findAll();
		List<Prefecture> prefectures = prefectureRepository.findAll();
		
		List<HotSpring> hotSpring = hotSpringRepository.findByInnId(inn.getId());
		List<Walk> walk = walkRepository.findByInnId(inn.getId());
		List<HighClass> highClass = highClassRepository.findByInnId(inn.getId());

		model.addAttribute("inn", inn);

		//		List<Photo> photos = photoRepository.findByInnId(inn.getId());
		Photo photo1 = photoRepository.findByInnId(inn.getId()).get(0);
		Photo photo2 = photoRepository.findByInnId(inn.getId()).get(1);
		Photo photo3 = photoRepository.findByInnId(inn.getId()).get(2);

		//		model.addAttribute("photos", photos);
		model.addAttribute("photo1", photo1);
		model.addAttribute("photo2", photo2);
		model.addAttribute("photo3", photo3);

		model.addAttribute("plans", plans);
		model.addAttribute("categories", categories);
		model.addAttribute("prefectures", prefectures);
		
		if (hotSpring.size() != 0) {
			model.addAttribute("hotSpring", hotSpring);
		}

		if (walk.size() != 0) {
			model.addAttribute("walk", walk);
		}

		if (highClass.size() != 0) {
			model.addAttribute("highClass", highClass);
		}

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
			@RequestParam("prefectureId") Integer prefectureId,
			@RequestParam(value = "photo1", defaultValue = "https://x.gd/Pa1vo") String photo1,
			@RequestParam(value = "photo2", defaultValue = "https://x.gd/Pa1vo") String photo2,
			@RequestParam(value = "photo3", defaultValue = "https://x.gd/Pa1vo") String photo3,
			@RequestParam("photo1Id") Integer photo1Id,
			@RequestParam("photo2Id") Integer photo2Id,
			@RequestParam("photo3Id") Integer photo3Id,
			Model model) {
		Category category = categoryRepository.findById(categoryId).get();
		Prefecture prefecture = prefectureRepository.findById(categoryId).get();

		Inn inn = new Inn(id, category, name, zipCode, address, tel, prefecture);

		innRepository.save(inn);

		Photo newPhoto1 = new Photo(photo1Id, inn.getId(), photo1);
		Photo newPhoto2 = new Photo(photo2Id, inn.getId(), photo2);
		Photo newPhoto3 = new Photo(photo3Id, inn.getId(), photo3);

		photoRepository.save(newPhoto1);
		photoRepository.save(newPhoto2);
		photoRepository.save(newPhoto3);

		return "redirect:/admin/index/Inn";
	}

	@PostMapping({ "/admin/plan/{id}/add" })
	public String createPlan(
			@PathVariable("id") Integer id,
			@RequestParam("planName") String planName,
			@RequestParam("price") Integer price) {

		Plan plan = new Plan(id, planName, price);

		planRepository.save(plan);

		return "redirect:/admin/edit/" + id + "/inn";
	}

	@PostMapping({ "/admin/plan/edit{id}&{innId}" })
	public String editPlan(
			@PathVariable("id") Integer id,
			@PathVariable("innId") Integer innId,
			@RequestParam("planName") String planName,
			@RequestParam("price") Integer price) {

		Plan plan = new Plan(id, innId, planName, price);

		planRepository.save(plan);

		return "redirect:/admin/edit/" + innId + "/inn";
	}

	@PostMapping({ "/admin/inn/{id}/delete" })
	public String deleteInn(
			@PathVariable("id") Integer id, Model model) {
		innRepository.deleteById(id);
		return "redirect:/admin/index/Inn";
	}

	@PostMapping({ "/admin/plan/{id}/delete/{innId}" })
	public String deletePlan(
			@PathVariable("id") Integer id,
			@PathVariable("innId") Integer innId) {
		planRepository.deleteById(id);

		return "redirect:/admin/edit/" + innId + "/inn";
	}
}
