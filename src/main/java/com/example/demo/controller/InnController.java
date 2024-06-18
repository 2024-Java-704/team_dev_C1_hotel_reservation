
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

import com.example.demo.entity.HighClass;
import com.example.demo.entity.History;
import com.example.demo.entity.HotSpring;
import com.example.demo.entity.Inn;
import com.example.demo.entity.Photo;
import com.example.demo.entity.Plan;
import com.example.demo.entity.Prefecture;
import com.example.demo.entity.Review;
import com.example.demo.entity.Walk;
import com.example.demo.model.Account;
import com.example.demo.repository.HighClassRepository;
import com.example.demo.repository.HistoryRepository;
import com.example.demo.repository.HotSpringRepository;
import com.example.demo.repository.InnRepository;
import com.example.demo.repository.PhotoRepository;
import com.example.demo.repository.PlanRepository;
import com.example.demo.repository.PrefectureRepository;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.repository.WalkRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class InnController {
	@Autowired
	HttpSession session;

	@Autowired
	Account account;

	@Autowired
	InnRepository innRepository;

	@Autowired
	ReviewRepository reviewRepository;

	@Autowired
	PlanRepository planRepository;

	@Autowired
	PhotoRepository photoRepository;

	@Autowired
	HistoryRepository historyRepository;

	@Autowired
	PrefectureRepository prefectureRepository;

	@Autowired
	HotSpringRepository hotSpringRepository;

	@Autowired
	WalkRepository walkRepository;

	@Autowired
	HighClassRepository highClassRepository;

	@GetMapping("/")
	public String index(
			@RequestParam(name = "keyword", defaultValue = "") String keyword,
			@RequestParam(name = "prefectureId", defaultValue = "") Integer prefectureId,
			Model model) {

		List<Photo> photos = new ArrayList<>();
		List<Inn> inns = null;
		List<Review> reviews = reviewRepository.findAll();
		List<Inn> ranking = new ArrayList<Inn>();

		var map = new TreeMap<Integer, Double>(Comparator.reverseOrder());
		//		var map = new TreeMap<Double, Inn>(Comparator.reverseOrder());

		inns = innRepository.findAll();

		List<Prefecture> prefectures = prefectureRepository.findAll();

		Double[] rankArray = new Double[inns.size()];
		Integer[] count = new Integer[inns.size()];

		for (int i = 0; i < inns.size(); i++) {
			rankArray[i] = 0.0;
			count[i] = 0;
		}

		if (reviews != null) {
			for (Review review : reviews) {
				rankArray[review.getInnId() - 1] += review.getRankId();
				count[review.getInnId() - 1] += 1;
			}

			for (int i = 0; i < rankArray.length; i++) {
				if (count[i] != 0) {
					rankArray[i] /= count[i];
				}
			}
		}

		ranking = innRepository.findAll();

		for (Inn rank : ranking) {
			rank.setRank(rankArray[rank.getId() - 1]);
		}

		ranking.sort(Comparator.comparingDouble(Inn::getRank).reversed());

		if (!keyword.equals("")) {
			//inns = innRepository.findByNameLike("%" + keyword + "%");
			inns = innRepository.findByNameContainingOrAddressContaining(keyword, keyword);

		}
		if (inns.size() == 0) {
			inns = innRepository.findAllByOrderByIdAsc();
			model.addAttribute("message", "入力した条件に合致する宿が存在しませんでした");
		}

		if (prefectureId != null) {
			inns = innRepository.findByPrefectureId(prefectureId);
		}

		Photo innPhotos = null;

		for (Inn inn : inns) {
			innPhotos = photoRepository.findByInnId(inn.getId()).get(0);
			photos.add(innPhotos);
		}

		model.addAttribute("prefectures", prefectures);
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
		List<HotSpring> hotSpring = hotSpringRepository.findByInnId(inn.getId());
		List<Walk> walk = walkRepository.findByInnId(inn.getId());
		List<HighClass> highClass = highClassRepository.findByInnId(inn.getId());

		Double rank = 0.0;

		for (Review review : reviews) {
			rank += review.getRankId();
		}

		if (reviews.size() != 0) {
			rank = rank / reviews.size();
		}

		if (account != null && account.getId() != null) {
			List<History> histories = historyRepository.findByUserIdAndInnId(account.getId(), inn.getId());
			History history = new History(inn, account.getId());

			if (histories.size() != 0) {
				historyRepository.deleteById(histories.get(0).getId());
			}

			historyRepository.save(history);
		}

		if (hotSpring.size() != 0) {
			model.addAttribute("hotSpring", "温泉");
		}

		if (walk.size() != 0) {
			model.addAttribute("walk", "駅から徒歩5分");
		}

		if (highClass.size() != 0) {
			model.addAttribute("highClass", "ハイクラス");
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
