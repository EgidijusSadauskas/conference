package lt.nfq.conference.service.dao;

import java.util.List;

import lt.nfq.conference.domain.City;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

public interface CityMapper {

	@Select("SELECT cityName from cities WHERE countryName = #{countryName}")
	public List<City> getAllCities(@Param("countryName")String countryCrecendials);

	
	@Select("SELECT COUNT(*) from cities WHERE cityName = #{cityName} AND countryName = #{countryName}")
	public int getTownWithCountry(@Param("cityName")String cityName, @Param("countryName")String country);

	
	@Options(flushCache=true)
	@Insert("INSERT INTO cities(cityName,countryName) VALUES(#{cityName},#{countryName})")
	@SelectKey(statement="CALL IDENTITY()", keyProperty="id", before=false, resultType=int.class)
	public void addCity(@Param("cityName")String city, @Param("countryName")String country);
	
	
	
}
