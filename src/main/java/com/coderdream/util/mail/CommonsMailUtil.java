package com.coderdream.util.mail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * http://commons.apache.org/proper/commons-email/userguide.html
 * 
 * @author CoderDream
 *
 */
public class CommonsMailUtil {

	private String host = ConfigLoader.getServer();
	private String from = ConfigLoader.getSender();
	private String username = ConfigLoader.getUsername();
	private String password = ConfigLoader.getPassword();
	private String nickname = ConfigLoader.getNickname();

	private String mailto = ConfigLoader.getMailto();
	
	public void sendSimpleTextEmail() {
		Email email = new SimpleEmail();
		email.setHostName(host);
		email.setSmtpPort(25);
		email.setAuthenticator(new DefaultAuthenticator(username, password));
		email.setSSLOnConnect(false);
		try {
			email.setFrom(from);
			email.setSubject("SimpleTextMail");
			email.setMsg("SimpleTextMail");
			email.addTo(mailto);
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
}
