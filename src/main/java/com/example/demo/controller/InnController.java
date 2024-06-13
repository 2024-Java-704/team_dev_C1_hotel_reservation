
package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

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
import com.example.demo.entity.Review;
import com.example.demo.repository.InnRepository;
import com.example.demo.repository.PhotoRepository;
import com.example.demo.repository.PlanRepository;
import com.example.demo.repository.ReviewRepository;

@Controller
public class InnController {
	@Autowired
	InnRepository innRepository;

	@Autowired
	ReviewRepository reviewRepository;

	@Autowired
	PlanRepository planRepository;

	@Autowired
	PhotoRepository photoRepository;

	@GetMapping("/")
	public String index(
			@RequestParam(name = "keyword", defaultValue = "") String keyword,
			Model model) {
		List<Inn> inns = null;
		List<Review> reviews = reviewRepository.findAll();
		List<Inn> ranking = new ArrayList<Inn>();

		var map = new TreeMap<Double, Inn>(Comparator.reverseOrder());
		//Map<Double, Inn> ranking = null;

		inns = innRepository.findAll();

		Integer[] num = new Integer[inns.size()];
		Double[] rankArray = new Double[inns.size()];

		do {

			for (Review review : reviews) {
				rankArray[review.getInnId() - 1] = 0.0;
				num[review.getInnId() - 1] = 0;
			}

			for (Review review : reviews) {
				rankArray[review.getInnId() - 1] += review.getRankId();
				num[review.getInnId() - 1] += 1;
			}

			for (int i = 0; i < rankArray.length; i++) {
				if (rankArray[i] != null) {
					rankArray[i] /= num[i];
				}
			}

			for (int i = 0; i < inns.size(); i++) {
				if (rankArray[i] != null) {
					map.put(rankArray[i], inns.get(i));
				}
			}

			for (var key : map.keySet()) {
				ranking.add(map.get(key));
			}
		} while (ranking.size() > 5);

		if (!keyword.equals("")) {
			inns = innRepository.findByNameLike("%" + keyword + "%");
		}

		model.addAttribute("keyword", keyword);
		model.addAttribute("inns", inns);
		model.addAttribute("ranking", ranking);

		return "innIndex";
	}

	@GetMapping("/detail/{id}")
	public String detailInn(@PathVariable("id") Integer id, Model model) {
		Inn inn = innRepository.findById(id).get();
		List<Plan> plans = planRepository.findByInnId(inn.getId());
		List<Photo> photos = photoRepository.findByInnId(inn.getId());
		List<Review> reviews = reviewRepository.findByInnId(inn.getId());
		Double rank = 0.0;

		for (Review review : reviews) {
			rank += review.getRankId();
		}

		rank = rank / reviews.size();

		model.addAttribute("inn", inn);
		model.addAttribute("plans", plans);
		model.addAttribute("photos", photos);
		model.addAttribute("reviews", reviews);
		model.addAttribute("rank", rank);

		return "detailInn";
	}

	@PostMapping("/review/add/{id}")
	public String addReview(@PathVariable("id") Integer id, @RequestParam("content") String content,
			@RequestParam("rankId") Integer rankId) {
		Review review = new Review(content, rankId, id);

		reviewRepository.save(review);

		return "redirect:/detail/{id}";
	}

}
