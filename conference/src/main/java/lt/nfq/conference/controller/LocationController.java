package lt.nfq.conference.controller;

import java.util.List;

import lt.nfq.conference.domain.City;
import lt.nfq.conference.service.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LocationController {
	@Autowired
	LocationService locationService;
	
	@RequestMapping(value="/location/getCities" ,method = RequestMethod.POST)
	public String getCities(ModelMap model,@RequestParam("location")String cityCrecendials){
		List<City> cityList = locationService.getAllCities(cityCrecendials);
		if(cityList.size() > 0)
			model.addAttribute("cityList", cityList);
		
		
		return "location/cityList";
		
	}
	
}
