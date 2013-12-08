package lt.nfq.conference.service.dao;

import java.util.List;

import lt.nfq.conference.domain.PlainCategory;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CategoryMapper {
	
	@Select("SELECT * FROM categories")
	public List<PlainCategory> getCategories();
	
	@Insert("INSERT INTO conference_categories (conferenceId,categoryId) VALUES (#{conferenceId},#{categoryId})")
	public void insertCategory(@Param("conferenceId") int conferenceId, @Param("categoryId")int categoryId);
}
