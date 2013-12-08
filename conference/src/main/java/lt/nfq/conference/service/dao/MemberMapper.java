package lt.nfq.conference.service.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import lt.nfq.conference.domain.Member;
import lt.nfq.conference.domain.Participant;

public interface MemberMapper {
	@Select("SELECT * from members WHERE userName=#{username} AND password=#{password}")
	public Member getMember(@Param("username") String username,@Param("password") String password);

	@Select("SELECT members.fullName as participantName , members.emailAddress as participantEmail FROM conference_attendees JOIN members ON(conference_attendees.userId = members.id) WHERE conference_attendees.conferenceId = #{conferenceId}")
	public List<Participant> getPartipatingMembers(@Param("conferenceId")int conferenceId);

	@Options(flushCache= true)
	@Insert("INSERT INTO members (fullName,emailAddress,town,country,userName,password) VALUES(#{fullName},#{emailAddress},#{town},#{country},#{userName},#{password})")
	@SelectKey(statement="CALL IDENTITY()", keyProperty="id", before=false, resultType=int.class)
	public void insertMember(Member member);
}

