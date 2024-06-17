
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

		List<Photo> photos = new ArrayList<>();
		List<Inn> inns = null;
		List<Review> reviews = reviewRepository.findAll();
		List<Inn> ranking = new ArrayList<Inn>();

		var map = new TreeMap<Integer, Double>(Comparator.reverseOrder());
		//		var map = new TreeMap<Double, Inn>(Comparator.reverseOrder());

		inns = innRepository.findAll();

		Double[] rankArray = new Double[inns.size()];
		Integer[] count = new Integer[inns.size()];

		for (int i = 0; i < inns.size(); i++) {
			rankArray[i] = 0.0;
			System.out.println("ランク" + rankArray[i]);
			count[i] = 0;
		}

		if (reviews != null) {
			for (Review review : reviews) {
				rankArray[review.getInnId() - 1] += review.getRankId();
				System.out.println("ランク" + rankArray[review.getInnId() - 1]);
				count[review.getInnId() - 1] += 1;
			}

			for (int i = 0; i < rankArray.length; i++) {
				if (count[i] != 0) {
					rankArray[i] /= count[i];
				}
				System.out.println("ランク" + rankArray[i]);
			}
		}

		ranking = innRepository.findAll();

		for (Inn rank : ranking) {
			rank.setRank(rankArray[rank.getId() - 1]);
		}

		ranking.sort(Comparator.comparingDouble(Inn::getRank).reversed());

		for (Inn rank : ranking) {
			System.out.println("ID" + rank.getId());
			System.out.println("ランク" + rank.getRank());
		}

		if (!keyword.equals("")) {
//			inns = innRepository.findByNameLike("%" + keyword + "%");
			inns = innRepository.findByNameContainingOrAddressContaining(keyword, keyword);

		}
		if (inns.size() == 0) {
			inns = innRepository.findAllByOrderByIdAsc();
			model.addAttribute("message", "入力した条件に合致する宿が存在しませんでした");
		}

		// 修正点：宿に紐づいた写真を取得
		for (Inn inn : inns) {
			Photo innPhotos = photoRepository.findByInnId(inn.getId()).get(0);
			photos.add(innPhotos); // すべての写真をphotosリストに追加
		}

		model.addAttribute("photos", photos);
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

		if (reviews.size() != 0) {
			rank = rank / reviews.size();
		}

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
