package lt.nfq.conference.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Conference {
    private Integer id;
    private String name;
    private Date startDate;
    private Date endDate;
    private String category;
    private String location;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public String getCategory(){
    	return category;
    }
    public void setCategory(String category){
    	this.category = category;
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
    



}
