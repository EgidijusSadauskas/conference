package lt.nfq.conference.controller;


import lt.nfq.conference.domain.Member;
import lt.nfq.conference.service.LocationService;
import lt.nfq.conference.service.MemberService;
import lt.nfq.conference.service.validation.MemberValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class RegistrationController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private LocationService locationService;
	
	@RequestMapping(value="/register" ,method = RequestMethod.GET)
	public String registerForm(){
		return "registrationForm";
	}
	

	@RequestMapping(value="/register" ,method = RequestMethod.POST)
	public String register(Model model, Member member ,BindingResult result){
		
		Errors errors = new BindException(result);
		MemberValidator memberValidator = new MemberValidator();
		
		memberValidator.validate(member, (Errors)errors,memberService);
		
		System.out.println(member.getFullName());
		System.out.println(member.getCountry());
		System.out.println(member.getTown());
		
		System.out.println(member.getPassword());
		System.out.println(member.getUserName());
		System.out.println(member.getEmailAddress());
		
		locationService.addCity(member.getTown(),member.getCountry());
		
		if (errors.getAllErrors().size() > 0){
			model.addAttribute("errorList",errors.getAllErrors());
			model.addAttribute("member", member);
			return "registrationForm";
		}else{
			memberService.saveMember(member);
			return "redirect:/conference/";
		}
	}
	@ModelAttribute
	public Member newRequest() {
		return new Member();
	}
	
	
	
}
