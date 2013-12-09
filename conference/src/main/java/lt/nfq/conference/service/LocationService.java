package lt.nfq.conference.service;

import java.util.List;

import lt.nfq.conference.domain.City;
import lt.nfq.conference.service.dao.CityMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LocationService {

	@Autowired
	CityMapper cityMapper;
	
	public List<City> getAllCities(String countryCrecendials) {
		return cityMapper.getAllCities(countryCrecendials);
	}
	

	public void addCity(String city, String country) {
		if (cityMapper.getTownWithCountry(city,country) == 0 )
			cityMapper.addCity(city,country);
	}


	
	
	
}
