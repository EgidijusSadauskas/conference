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
		memberMapper.insertMember((Member)member);
	}
	public List<Participant> getParticipants(int conferenceId) {
		return memberMapper.getPartipatingMembers(conferenceId);
	}
	public Member getMember(String username, String password) {	
		try {
			MessageDigest mdigest = MessageDigest.getInstance("MD5");
			mdigest.update(password.getBytes(),0,password.length());
			password = new BigInteger(1,mdigest.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return memberMapper.getMember(username,password);
	}
}
