package com.coderdream.util.mail;

public class SendEmailDemo {

	public static void main(String[] args) {

		String host = ConfigLoader.getServer();
		String from = ConfigLoader.getSender();
		String username = ConfigLoader.getUsername();
		String password = ConfigLoader.getPassword();
		String nickname = ConfigLoader.getNickname();

		String to = "xulin.wh@qq.com";// use your reciever email address
		try {
			EmailHelper emailHelper = new EmailHelper(host, username, password, from);
			emailHelper.setTo(to);
			emailHelper.setSubject("subject ttt test");
			emailHelper.setHtmlContent("<h1> This is html </h1>");
			String path = System.getProperty("user.dir")
					+ "/snapshot/pa_test_case_0101_login.png";
			emailHelper.setImagePath(path);

			emailHelper.sendWithImage();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
