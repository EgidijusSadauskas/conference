package lt.nfq.conference.service;

import java.util.Date;
import java.util.List;

import lt.nfq.conference.domain.Conference;
import lt.nfq.conference.service.dao.CategoryMapper;
import lt.nfq.conference.service.dao.ConferenceMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConferenceService {
	
    @Autowired
    private ConferenceMapper conferenceMapper;
    
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Conference> getConferencesByDates(Date start, Date end) {
        return conferenceMapper.getConferencesByDates(start, end);
    }

    public Conference getConference(int id) {
        return conferenceMapper.getConference(id);
    }

    public boolean updateConference(Conference conference) {
        return conferenceMapper.updateConference(conference) > 0;
    }

    public void saveConference(Conference conference) {
    	if (conference.getConferenceId() != null) {
    		conferenceMapper.updateConference(conference);
    	} else {
    	    conferenceMapper.insertConference(conference);
    	    int id = conferenceMapper.getLast();
    		categoryMapper.insertCategory(id, Integer.parseInt(conference.getCategoryName()));
    	}
    }

	public List<Conference> getParticipatedCategories(int userId) {
		return conferenceMapper.getConferencesById(userId);
	}
}
