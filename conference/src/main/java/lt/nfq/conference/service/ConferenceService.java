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
    		categoryMapper.insertCategory(id, Integer.parseInt(conference.getCategory()));
    	}
    }

	public List<Conference> getParticipatedConferences(int userId) {
		return conferenceMapper.getConferencesById(userId);
	}

	public List<Conference> getConferencesByDatesAndCategory(Date start, Date end,
			int category) {
		
		return conferenceMapper.getConferencesByDatesAndCategory(start,end,category);
	}

	
	public int checkConferenceIfExists(int conferenceId) {
		return conferenceMapper.getConferenceAmount(conferenceId);
	}

	public void addAttendant(int userId, int conferenceId) {
		conferenceMapper.addAttendant(userId,conferenceId);
		
	}

	public void exitConference(int userId, int conferenceId) {
		conferenceMapper.removeAttendance(conferenceId,userId);
		
	}

	public int isAlreadyParticipating(int userId, int conferenceId) {
		return conferenceMapper.checkIfParticipant(conferenceId,userId);
	}
}
