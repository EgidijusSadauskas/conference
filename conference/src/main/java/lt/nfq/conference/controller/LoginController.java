package lt.nfq.conference.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginForm() {
        return "redirect:/conference/"; 
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login() {
        return "redirect:/conference/";
    }
    @RequestMapping(value = "/login2", method = RequestMethod.POST)
    public String loginToSystem() {
        return "redirect:/";
    }
    @RequestMapping(value = "conference/login2", method = RequestMethod.POST)
    public String loginToSystemInside() {
        return "redirect:/";
    }
}
