package lt.nfq.conference.service.validation;

import lt.nfq.conference.domain.Conference;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ConferenceValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Conference.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		Conference conference = (Conference)obj;
		
		// Filtering Conference Name. Escaping html code,xml , javascript and SQL.
		String escapedConferenceName = StringEscapeUtils.escapeHtml(conference.getConferenceName());
		escapedConferenceName = StringEscapeUtils.escapeJavaScript(escapedConferenceName);
		
		// Filtering Conference description . Escaping html code,xml,javascript and SQL
		String escapedConferenceDescription = StringEscapeUtils.escapeJavaScript(conference.getDescription());
		
		// Putting back into object
		conference.setConferenceName(escapedConferenceName);
		conference.setDescription(escapedConferenceDescription);
		
		
		// Validating Conference Name
		if(conference.getConferenceName().equals("") || conference.getConferenceName() == null){
			errors.reject("conferenceName","conference name should not be empty");
		}else if(conference.getConferenceName().length() < 10){
			errors.reject("conferenceName","conference name should be more detailed");
		}else{
			
		}
		
		// Validating Conference category
		try{
			int tmpId = Integer.parseInt(conference.getCategory());
		}catch(NumberFormatException e){
			errors.reject("category","unknown category");
		}
		
		// Validating Conference description
		if (conference.getDescription().length() < 10 || conference.getDescription() == null){
			errors.reject("description","description should be more detailed");
		}
		// Validating conference location
		if (conference.getLocation().length() < 1){
			errors.reject("location","location does not exists");
		}
	}
	
}
