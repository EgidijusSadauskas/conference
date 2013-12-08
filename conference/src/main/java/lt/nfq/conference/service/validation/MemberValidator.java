package lt.nfq.conference.service.validation;

import lt.nfq.conference.domain.Member;
import lt.nfq.conference.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MemberValidator implements Validator{

	@Autowired
	private MemberService memberService;
	
	
	public void validate(Object obj, Errors errors,MemberService service) {

		Member member = (Member)obj;
		
		String escapedName = StringEscapeUtils.escapeJava(member.getFullName());
		String escapedPassword = StringEscapeUtils.escapeJavaScript(member.getPassword());
		String escapedEmailAddress = StringEscapeUtils.escapeJavaScript(member.getEmailAddress());
		String escapedTown = StringEscapeUtils.escapeJavaScript(member.getTown());
		String escapedUsername = StringEscapeUtils.escapeJavaScript(member.getUserName());
		
		if (escapedName.equals("") || escapedName.length() < 10){
			errors.reject("name", "Fullname shouldn't be empty");
		}
		if(escapedPassword.length() < 10){
			errors.reject("password","Password should consists atleast of 10 symbols");
		}
		if (escapedEmailAddress == null || escapedEmailAddress.indexOf("@") < 0){
			errors.reject("emailaddress","Email address should be valid");
		}
		if (escapedTown == null || escapedTown.equals("")){
			errors.reject("town","Town shouldn't be empty");
		}
		if(escapedUsername == null || escapedUsername.length() < 8){
			errors.reject("userName", "username should be longer");
		}
		
		if (service.getMember(escapedUsername) > 0  ){
			errors.reject("userNameExists","user with provided username already exists");
		}
		member.setFullName(escapedName);
		member.setEmailAddress(escapedEmailAddress);
		member.setPassword(escapedPassword);
		member.setTown(escapedTown);
		
		
		
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return Member.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}
	
	
}
