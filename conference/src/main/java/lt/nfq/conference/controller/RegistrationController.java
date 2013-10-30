package lt.nfq.conference.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class RegistrationController {
	
	@RequestMapping(value="/register" ,method = RequestMethod.GET)
	public String registerForm(){
		return "registrationForm";
	}
	@RequestMapping(value="/register" ,method = RequestMethod.POST)
	public String register(){
		return "redirect:/conference/";
	}
}