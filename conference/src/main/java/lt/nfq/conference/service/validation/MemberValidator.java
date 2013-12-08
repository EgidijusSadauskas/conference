package lt.nfq.conference.service.validation;

import java.util.Map;

import javax.validation.Validation;

import lt.nfq.conference.domain.Member;
import lt.nfq.conference.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.apache.commons.lang.StringEscapeUtils;

public class MemberValidator implements Validator{

	@Autowired
	private MemberService memberService;
	
	@Override
	public void validate(Object obj, Errors errors) {

		Member member = (Member)obj;
		System.out.println(member.getEmailAddress());
		if (member.getFullName().equals("")){
			errors.reject("name", "Fullname shouldn't be empty");
		}
		if(member.getPassword().length() < 10){
			errors.reject("password","Password should consists atleast of 10 symbols");
		}
		
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return Member.class.equals(arg0);
	}
	
	
}
