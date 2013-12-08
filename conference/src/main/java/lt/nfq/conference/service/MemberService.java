package lt.nfq.conference.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.nfq.conference.domain.Member;
import lt.nfq.conference.domain.Participant;
import lt.nfq.conference.service.dao.MemberMapper;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	public void saveMember(Member member){
		try {
			MessageDigest mdigest = MessageDigest.getInstance("MD5");
			mdigest.update(member.getPassword().getBytes(),0,member.getPassword().length());
			member.setPassword(new BigInteger(1,mdigest.digest()).toString(16));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Bandymas 2");
		System.out.println(member.getFullName());
		System.out.println(member.getCountry());
		System.out.println(member.getTown());
		System.out.println(member.getPassword());
		System.out.println(member.getUserName());
		System.out.println(member.getEmailAddress());
		
		memberMapper.insertMember((Member)member);
		//memberMapper.insertMember(member.getFullName(),member.getEmailAddress(),member.getCountry(),member.getTown(),member.getUserName(),member.getPassword());	
	}
	public Member getMember(Member member){
		return memberMapper.getMember(member);
	}
	public List<Participant> getParticipants(int conferenceId) {
		return memberMapper.getPartipatingMembers(conferenceId);
	}
	public Member getMember(String username, String password) {	
		return memberMapper.getMember(username,password);
	}
}
