package lt.nfq.conference.service.dao;

import java.util.Date;
import java.util.List;

import lt.nfq.conference.domain.Conference;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface ConferenceMapper {

    @Select("SELECT conferences.* , categories.categoryName as categoryName FROM conferences LEFT JOIN conference_categories ON(conferences.conferenceId = conference_categories.conferenceId) JOIN categories ON (conference_categories.categoryId = categories.categoryId) WHERE conferences.conferenceId=#{id}")
    public Conference getConference(@Param("id") int id);

    @Select("SELECT * FROM conferences")
    public List<Conference> getConferences();

    @Select("SELECT conferences.* , categories.categoryName as categoryName FROM conferences LEFT JOIN conference_categories ON(conferences.conferenceId = conference_categories.conferenceId) JOIN categories ON (conference_categories.categoryId = categories.categoryId) WHERE startDate > #{start} and startDate < #{end} and endDate < #{end} and endDate > #{start}")
    public List<Conference> getConferencesByDates(@Param("start") Date start, @Param("end") Date end);

    @Select("SELECT * FROM conferences LEFT OUTER JOIN (SELECT * FROM conference_categories )")
    public List<Conference> getConferencesByDates2(@Param("start") Date start ,@Param("end") Date end);
    
    @Options(flushCache=true)
    @Update("UPDATE conferences set name = #{name}, startDate = #{startDate}, endDate = #{endDate} WHERE id=#{id}")
    public int updateConference(Conference conference);

    @Options(flushCache=true)
    @Insert("INSERT INTO conferences (conferenceName, location, description, startDate, endDate,ownerId) VALUES (#{conferenceName}, #{location}, #{description},#{startDate},#{endDate},#{ownerId})")
    @SelectKey(statement="CALL IDENTITY()", keyProperty="id", before=false, resultType=int.class)
    public int insertConference(Conference conference);
    
    @Select("SELECT TOP 1 conferenceId FROM conferences ORDER BY conferenceId DESC")
    public int getLast();

    @Select("SELECT conferences.* , categories.categoryName as categoryName"
    		+ " FROM conference_attendees "
    		+ " LEFT JOIN conferences ON(conference_attendees.conferenceId = conferences.conferenceId)"
    		+ " JOIN conference_categories ON(conferences.conferenceId = conference_categories.conferenceId)"
    		+ " JOIN categories ON (conference_categories.categoryId = categories.categoryId)"
    		+ " WHERE conference_attendees.userId = #{userId}")
	public List<Conference> getConferencesById(@Param("userId") int userId);
    
}
