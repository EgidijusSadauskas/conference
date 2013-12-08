package lt.nfq.conference.service;

import java.util.List;



import lt.nfq.conference.domain.PlainCategory;
import lt.nfq.conference.service.dao.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	
	@Autowired
	CategoryMapper categoryMapper;

	public List<PlainCategory> getAllCategories() {
		return categoryMapper.getCategories();
	}
	
	
	
}
