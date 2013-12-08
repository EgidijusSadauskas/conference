package lt.nfq.conference.service.dao;

import java.util.Date;
import java.util.List;

import lt.nfq.conference.domain.Conference;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface ConferenceMapper {

    @Select("SELECT conferences.* , categories.categoryName as category FROM conferences LEFT JOIN conference_categories ON(conferences.conferenceId = conference_categories.conferenceId) JOIN categories ON (conference_categories.categoryId = categories.categoryId) WHERE conferences.conferenceId=#{id}")
    public Conference getConference(@Param("id") int id);

    @Select("SELECT * FROM conferences")
    public List<Conference> getConferences();

    @Select("SELECT conferences.* , categories.categoryName as category FROM conferences LEFT JOIN conference_categories ON(conferences.conferenceId = conference_categories.conferenceId) JOIN categories ON (conference_categories.categoryId = categories.categoryId) WHERE startDate > #{start} and startDate < #{end} and endDate < #{end} and endDate > #{start}")
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

    @Select("SELECT conferences.* , categories.categoryName as category"
    		+ " FROM conference_attendees "
    		+ " LEFT JOIN conferences ON(conference_attendees.conferenceId = conferences.conferenceId)"
    		+ " JOIN conference_categories ON(conferences.conferenceId = conference_categories.conferenceId)"
    		+ " JOIN categories ON (conference_categories.categoryId = categories.categoryId)"
    		+ " WHERE conference_attendees.userId = #{userId}")
	public List<Conference> getConferencesById(@Param("userId") int userId);

    @Select("SELECT conferences.* , categories.categoryName as category FROM conferences LEFT JOIN conference_categories ON(conferences.conferenceId = conference_categories.conferenceId) JOIN categories ON (conference_categories.categoryId = categories.categoryId) WHERE startDate > #{start} and startDate < #{end} and endDate < #{end} and endDate > #{start} and categoryId = #{category}")
	public List<Conference> getConferencesByDatesAndCategory(@Param("start")Date start,@Param("end")Date end, @Param("category")int category);

    @Select("SELECT COUNT(*) FROM conferences WHERE conferenceId = #{conferenceId}") 
	public int getConferenceAmount(@Param("conferenceId")int conferenceId);

    @Options(flushCache = true)
    @Insert("INSERT INTO conference_attendees(conferenceId,userId) VALUES (#{conferenceId},#{userId})")
	public void addAttendant(@Param("userId")int userId, @Param("conferenceId")int conferenceId);

    @Delete("DELETE FROM conference_attendees WHERE conferenceId=#{conferenceId} AND userId=#{userId}")
	public void removeAttendance(@Param("conferenceId")int conferenceId, @Param("userId")int userId);
    
    @Select("SELECT COUNT(*) FROM conference_attendees WHERE conferenceId=#{conferenceId} AND userId=#{userId}")
	public int checkIfParticipant(@Param("conferenceId")int conferenceId, @Param("userId")int userId);
	
	
	
	
    
}
