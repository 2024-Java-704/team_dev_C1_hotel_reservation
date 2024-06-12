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
import com.example.demo.entity.Photo;
import com.example.demo.repository.InnRepository;
import com.example.demo.repository.PhotoRepository;

@Controller
public class AdminInnController {
	@Autowired
	InnRepository innRepository;
	
	@Autowired
	PhotoRepository photoRepository;

		@GetMapping({ "/admin/index/Inn" })
		public String indexInn(
				@RequestParam(value = "id", defaultValue = "") Integer id,
				@RequestParam(value = "categoryId", defaultValue = "") Integer categoryId,
				@RequestParam(value = "category", defaultValue = "") Integer category,
				
				Model model) {
			List<Inn> inns = null;
			
			
			if  (id != null) {
				Inn hotel=innRepository.findById(id).get();	
				inns.add(hotel);
			}
			else if (categoryId != null) {
				inns = innRepository.findByCategoryId(categoryId);
				
			}
			else{
				inns = innRepository.findAllByOrderByIdAsc();
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
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "categoryId", defaultValue = "") Integer categoryId,
			@RequestParam(value = "zipCode", defaultValue = "") String zipCode,
			@RequestParam(value = "address", defaultValue = "") String address,
			@RequestParam(value = "tel", defaultValue = "") String tel,
			@RequestParam(value = "prefectureId", defaultValue = "0") Integer prefectureId,
			@RequestParam(value = "photo1", defaultValue = "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEju7U8esONERDN_s7GbaKtQbHoaZ9ogxlzbcSf9I8_JbyCrXUM9BvvFFg-1LwbMZHM2x-5pBYWxlhTSqPa_9eLwZeWY2ZzHhVg_iQqb0PRsSxP-WxElIjlm1BT1jy0fCRtHAckDbyCjdd-u/s1600/no_image_logo.png") String photo1,
			@RequestParam(value = "photo2", defaultValue = "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEju7U8esONERDN_s7GbaKtQbHoaZ9ogxlzbcSf9I8_JbyCrXUM9BvvFFg-1LwbMZHM2x-5pBYWxlhTSqPa_9eLwZeWY2ZzHhVg_iQqb0PRsSxP-WxElIjlm1BT1jy0fCRtHAckDbyCjdd-u/s1600/no_image_logo.png") String photo2,
			@RequestParam(value = "photo3", defaultValue = "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEju7U8esONERDN_s7GbaKtQbHoaZ9ogxlzbcSf9I8_JbyCrXUM9BvvFFg-1LwbMZHM2x-5pBYWxlhTSqPa_9eLwZeWY2ZzHhVg_iQqb0PRsSxP-WxElIjlm1BT1jy0fCRtHAckDbyCjdd-u/s1600/no_image_logo.png") String photo3,
			Model model) {
		/*		model.addAttribute("name",name);
				model.addAttribute("categoruId",categoryId);
				model.addAttribute("adress",adress);
				model.addAttribute("prefectureId",prefectureId);*/
		Inn inn = new Inn(categoryId, name, zipCode, address, tel, prefectureId);
		innRepository.save(inn);
	
		Photo newPhoto1=new Photo(inn, photo1);
		Photo newPhoto2=new Photo(inn, photo2);
		Photo newPhoto3=new Photo(inn, photo3);
		
		photoRepository.save(newPhoto1);
		photoRepository.save(newPhoto2);
		photoRepository.save(newPhoto3);
		return "redirect:/admin/index/Inn";
	}

	@GetMapping({ "/admin/edit/{id}/inn" })
	public String editInn(
			@PathVariable("id") Integer id,
			Model model) {
		Inn inn = innRepository.findById(id).get();		
//		List<Photo> photos = photoRepository.findByInnId(inn.getId());
		Photo photo1 = photoRepository.findByInnId(inn.getId()).get(0);
		Photo photo2 = photoRepository.findByInnId(inn.getId()).get(1);
		Photo photo3 = photoRepository.findByInnId(inn.getId()).get(2);

		model.addAttribute("photo1",photo1);
		model.addAttribute("photo2",photo2);
		model.addAttribute("photo3",photo3);
//		model.addAttribute("photos", photos);
		model.addAttribute("inn", inn);
		return "editInn";
	}

	@PostMapping({ "/admin/edit/{id}/inn" })
	public String updateInn(
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "categoryId", defaultValue = "") Integer categoryId,
			@RequestParam(value = "zipCode", defaultValue = "") String zipCode,
			@RequestParam(value = "adress", defaultValue = "") String adress,
			@RequestParam(value = "tel", defaultValue = "") String tel,
			@RequestParam(value = "prefectureId", defaultValue = "") Integer prefectureId,
			Model model) {
		/*		model.addAttribute("id",id);
				model.addAttribute("name",name);
				model.addAttribute("categoryId",categoryId);
				model.addAttribute("adress",adress);
				model.addAttribute("prefectureId",prefectureId);*/
		Inn inn = new Inn(categoryId, name, zipCode, adress, tel, prefectureId);
		innRepository.save(inn);
		return "updateInn";
	}

	@PostMapping({ "/admin/inn/{id}/delete" })
	public String deleteInn(
			@PathVariable("id") Integer id, Model model) {
		innRepository.deleteById(id);
		return "redirect:/indexInn";
	}
}
