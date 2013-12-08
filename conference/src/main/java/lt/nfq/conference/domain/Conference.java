package lt.nfq.conference.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Conference {
    private Integer conferenceId;
    private String conferenceName;
    private Date startDate;
    private Date endDate;
    private String location;
    private String description;
    private int ownerId;
    private String categoryName;

    public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String category) {
		this.categoryName = category;
	}

	public String getConferenceName () {
        return conferenceName;
    }

    public void setConferenceName(String name) {
        this.conferenceName = name;
    }

    public Date getStartDate() {
        return startDate;
    }
    public String getStartDate(SimpleDateFormat simpleDateFormat) {
        return simpleDateFormat.format(startDate);
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getEndDate(SimpleDateFormat simpleDateFormat) {
        return simpleDateFormat.format(endDate);
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public String getLocation(){
    	return this.location;
    }
    public void setLocation(String location){
    	this.location = location;
    }
    public String getDescription(){
    	return this.description;
    }
    public void setDescription(String description){
    	this.description = description;
    }

	public Integer getConferenceId() {
		return conferenceId;
	}

	public void setConferenceId(Integer conferenceId) {
		this.conferenceId = conferenceId;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
    
    



}
