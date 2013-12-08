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
import lt.nfq.conference.service.passwordProvider.PasswordFactory;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	public void saveMember(Member member){
		member.setPassword(PasswordFactory.getEncodedPassword(member.getPassword()));
		memberMapper.insertMember((Member)member);
	}
	public List<Participant> getParticipants(int conferenceId) {
		return memberMapper.getPartipatingMembers(conferenceId);
	}
	public Member getMember(String username, String password) {	
		password = PasswordFactory.getEncodedPassword(password);
		
		return memberMapper.getMember(username,password);
	}
	
	public int getMember(String userName) {
			return memberMapper.checkIfExists(userName);
	}
}
