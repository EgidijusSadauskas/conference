package lt.nfq.conference.controller;

import lt.nfq.conference.domain.Member;
import lt.nfq.conference.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({"sessionUsername","password","sessionId"})
public class LoginController {

	@Autowired
	MemberService memberService;
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginForm() {
        return "redirect:/conference/"; 
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model,@RequestParam(value = "username") String username,
    					@RequestParam(value = "password") String password) {
    	

    	Member member = memberService.retrieveMember(username,password);
    	if (member == null){
    		System.out.println("blogas pass");
    		return "user/notAUser";
    	}
    	
    	model.addAttribute("sessionId",member.getId());
    	model.addAttribute("sessionUsername", username);
    	model.addAttribute("password", password);
    	
        return "user/UserData";
    }
    @RequestMapping(value = "/login2", method = RequestMethod.POST)
    public String loginToSystem() {
        return "redirect:/";
    }
    @RequestMapping(value = "/conference/login2", method = RequestMethod.POST)
    public String loginToSystemInside() {
        return "redirect:/";
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET )
    public String logout(ModelMap model, SessionStatus status){
    	String userName = (String) model.get("sessionUsername");
    	if (userName != null){
    		status.setComplete();
    		model.remove("sessionId");
    		model.remove("sessionUsername");
    		model.remove("password");	
    	}
    	
    	return "redirect:/";
    }
}
