package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Offer;
import kr.ac.hansung.service.OffersService;

@Controller
public class OffersController {

	private OffersService offersService;

	@RequestMapping("/offers")
	public String showOffers(Model model) {

		List<Offer> offers = offersService.getCurrent();
		model.addAttribute("offers", offers);

		return "offers";
	}

	@RequestMapping("/createoffer")
	public String createOffer(Model model) {
		model.addAttribute(new Offer());
		return "createoffer";
	}

	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}
	
	@RequestMapping("/docreate")
	public String doCreate(Model model,@Valid Offer offer,BindingResult result) {
		//request 파라미터 값이 offer로 자동으로 바인딩 됨
		
		if(result.hasErrors()){
			System.out.println("Form data does not validate");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error:errors){
				System.out.println(error.getDefaultMessage());
			}
			return "createoffer";
		}
		offersService.insert(offer);
		return "offercreated";
	}


}
