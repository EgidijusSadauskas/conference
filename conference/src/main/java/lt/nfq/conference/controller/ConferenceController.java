package lt.nfq.conference.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import lt.nfq.conference.domain.Conference;
import lt.nfq.conference.service.CategoryService;
import lt.nfq.conference.service.ConferenceService;
import lt.nfq.conference.service.MemberService;
import lt.nfq.conference.service.validation.ConferenceValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "/conference")
@SessionAttributes({"sessionUsername","password","sessionId"})
public class ConferenceController {

    @Autowired
    private ConferenceService conferenceService;
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/")
    public String list(ModelMap model) {
    	
    	
        SimpleDateFormat simpleDateFormat = getDateFormat();
        long timeNow = new Date().getTime();

        String startDate = simpleDateFormat.format(timeNow);
        String endDate = simpleDateFormat.format(timeNow + 1000 * 60 * 60 * 24 * 10); // + 10d
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("dateFormat", simpleDateFormat);
        model.addAttribute("categoryList",categoryService.getAllCategories());
       
        if (model.get("sessionUsername") != null){
        	System.out.println("Egzistuoja sesija");
        	List<Conference> lt = conferenceService.getParticipatedConferences((int)model.get("sessionId"));
        	System.out.println("Conferenciju kiekis = "+lt.size());
        	model.addAttribute("participatingConferencesList", conferenceService.getParticipatedConferences((int)model.get("sessionId")));
    	}

        try {
            model.addAttribute("conferenceList", conferenceService.getConferencesByDates(simpleDateFormat.parse(startDate), simpleDateFormat.parse(endDate)));
        } catch (ParseException e) {

        }

        return "conference/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public String filterList(ModelMap model,
                             @RequestParam(value = "start") Date start,
                             @RequestParam(value = "end") Date end,
                             @RequestParam(value = "category") int category) {
    	
    
    	if(category == 0){
    		model.addAttribute("conferenceList", conferenceService.getConferencesByDates(start, end));
    	}else{
    		model.addAttribute("conferenceList", conferenceService.getConferencesByDatesAndCategory(start, end,category));
    	}
    	
    	
        model.addAttribute("dateFormat", getDateFormat());

        return "conference/items";
    }
    
    
    
    @RequestMapping(value = "/create" ,method = RequestMethod.GET)
    public String create(ModelMap model) {
        
    	if (model.get("sessionUsername") == null){
        	return "redirect:/";
        }
    	
    	model.addAttribute("conference", new Conference());
        SimpleDateFormat simpleDateFormat = getDateFormat();
        long timeNow = new Date().getTime();

        String startDate = simpleDateFormat.format(timeNow);
        String endDate = simpleDateFormat.format(timeNow + 1000 * 60 * 60 * 24 * 10); // + 10d
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("dateFormat", simpleDateFormat);
        model.addAttribute("categoryList",categoryService.getAllCategories());
        return "conference/conferenceCreationForm";
    }
    
    @RequestMapping(value ="/createConference",method=RequestMethod.POST)
    public String createConference(ModelMap model ,
    		 Conference conference,BindingResult result){
    	
    	if (model.get("sessionUsername") == null){
    		return "redirect:/";
    	}
    	conference.setOwnerId((int) model.get("sessionId"));
    	
    	
    	Errors errors = new BindException(result);
    	ConferenceValidator conferenceValidator = new ConferenceValidator();
    	conferenceValidator.validate(conference, errors);
 	
    	if (errors.getErrorCount() > 0){
    		SimpleDateFormat simpleDateFormat = getDateFormat();
    		model.addAttribute("errorList",errors.getAllErrors());
    		model.addAttribute("conference",conference);
    		model.addAttribute("startDate",simpleDateFormat.format(conference.getStartDate()));
    		model.addAttribute("endDate",simpleDateFormat.format(conference.getEndDate()));
    		model.addAttribute("dateFormat", simpleDateFormat);
            model.addAttribute("categoryList",categoryService.getAllCategories());
    		return "conference/conferenceCreationForm";
    	}
    	
    		conferenceService.saveConference(conference);
    		return "redirect:/conference/join?id=1";
    }

    
    
    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String update(ModelMap model, @RequestParam(value = "id") int id) {
        if (model.get("sessionUsername") == null)
        	return "redirect:/";

        model.addAttribute("userId",model.get("sessionId"));
    	model.addAttribute("conference", conferenceService.getConference(id));
        model.addAttribute("attendeesList",memberService.getParticipants(id));
        model.addAttribute("dateFormat", getDateFormat());
        
        if (conferenceService.isAlreadyParticipating((int)model.get("sessionId"),id) > 0){
        	model.addAttribute("alreadyParticipating", true);
        	
        }
        return "conference/signUpForm";
    }
    @RequestMapping(value ="/signUp" ,method = RequestMethod.POST)
    public String signUp(ModelMap model,@RequestParam(value = "hiddenUserId") int userId,
    		@RequestParam("hiddenConferenceId") int conferenceId){	
    	
    	if (conferenceService.checkConferenceIfExists(conferenceId) > 0){
    		conferenceService.addAttendant(userId,conferenceId);
    	}
    	
    	return "redirect:/";
    }
    @RequestMapping(value="/exit")
    public String exit(ModelMap model,@RequestParam("id")int id){
    	if(model.get("sessionUsername") == null)
    		return "redirect:/";
    	
    	conferenceService.exitConference((int)model.get("sessionId"),id);
    	
    	return "redirect:/";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public
    @ResponseBody
    HashMap<String, String> save(@ModelAttribute("conference") Conference conference) {
        HashMap<String, String> response = new HashMap<String, String>();
        if (conferenceService.updateConference(conference)) {
            response.put("success", "saved");
        } else {
            response.put("error", "error with saving");
        }
        response.put("status", "ok");
        return response;
    }
    
    private SimpleDateFormat getDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
    	
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
    
    @ModelAttribute
	public Conference newRequest(ModelMap model) {
    	 
    	if (model.get("sessionUsername") != null)
		{
    		List<Conference> list = conferenceService.getParticipatedConferences((int)model.get("sessionId"));
    		
    		System.out.println("joinina i ="+list.size());
			model.addAttribute("participatingConferencesList", conferenceService.getParticipatedConferences((int)model.get("sessionId")));
		}
    	return new Conference();
	}
    


}
