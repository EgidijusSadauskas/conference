package lt.nfq.conference.service.passwordProvider;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordFactory {
	
	public static String getEncodedPassword(String password){
		String encodedPassword;
		String salt = "Egidijus";
		try {
			MessageDigest mdigest = MessageDigest.getInstance("MD5");
			mdigest.update(password.getBytes(),0,password.length());
			encodedPassword = new BigInteger(1,mdigest.digest()).toString(16);
			
			encodedPassword = encodedPassword + salt;
			mdigest.update(encodedPassword.getBytes(), 0, encodedPassword.length());
			encodedPassword = new BigInteger(1, mdigest.digest()).toString();
			
			
		} catch (NoSuchAlgorithmException e) {
			encodedPassword = "error";
			e.printStackTrace();
		}	
		return encodedPassword;
	}
}
