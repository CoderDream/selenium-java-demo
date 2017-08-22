package com.coderdream.util.mail;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.apache.commons.mail.DataSourceResolver;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.resolver.DataSourceCompositeResolver;
import org.apache.commons.mail.resolver.DataSourceFileResolver;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;

/**
 * http://commons.apache.org/proper/commons-email/userguide.html
 * 
 * @author CoderDream
 *
 */
public class CommonsMailUtil {

	static void setEmail(Email email) {
		try {
			String host = ConfigLoader.getServer();
			String from = ConfigLoader.getSender();
			String username = ConfigLoader.getUsername();
			String password = ConfigLoader.getPassword();
			String nickname = ConfigLoader.getNickname();
			String mailto = ConfigLoader.getMailto();

			email.setFrom(from);
			email.setHostName(host);
			email.setSmtpPort(25);
			email.setAuthenticator(
							new DefaultAuthenticator(username, password));
			email.setSSLOnConnect(false);
			email.addTo(mailto, nickname);
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

	public static void sendSimpleTextEmail() {
		Email email = new SimpleEmail();
		setEmail(email);
		try {
			email.setSubject("SimpleTextMail");
			email.setMsg("SimpleTextMail");
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

	public static void sendingEmailsWithAttachments() {
		// Create the attachment
		EmailAttachment attachment = new EmailAttachment();
		String fileName = "20170822083315980_searchByParams.png";
		attachment.setPath(System.getProperty("user.dir") + "\\snapshot\\"
						+ fileName);
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Picture of John");
		attachment.setName(fileName);

		MultiPartEmail email = new MultiPartEmail();
		setEmail(email);
		try {
			// Create the email message
			email.setSubject("The picture");
			email.setMsg("Here is the picture you wanted");

			// add the attachment
			email.attach(attachment);

			// send the email
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

	public static void sendingEmailsWithAttachmentsUseURL() {
		try {
			// Create the attachment
			EmailAttachment attachment = new EmailAttachment();
			String fileName = "asf_logo_wide.gif";
			// attachment.setPath(System.getProperty("user.dir") +
			// "\\snapshot\\"
			// + fileName);
			attachment.setURL(new URL(
							"http://www.apache.org/images/" + fileName));
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			attachment.setDescription("Apache logo");
			attachment.setName(fileName);

			MultiPartEmail email = new MultiPartEmail();

			setEmail(email);

			// Create the email message
			email.setSubject("The picture");
			email.setMsg("Here is the picture you wanted");

			// add the attachment
			email.attach(attachment);

			// send the email
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public static void sendingHtmlFormattedEmail() {
		HtmlEmail email = new HtmlEmail();
		setEmail(email);
		try {
			// Create the email message
			email.setSubject("Test email with inline image");

			// embed the image and get the content id
			URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
			String cid = email.embed(url, "Apache logo");

			// set the html message
			email.setHtmlMsg("<html>The apache logo - <img src=\"cid:" + cid
							+ "\"></html>");

			// set the alternative message
			email.setTextMsg(
							"Your email client does not support HTML messages");

			// send the email
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param aSubject
	 * @param aHtml
	 * @param aText
	 */
	public static void sendingHtmlFormattedEmail(String aSubject, String aHtml,
					String aText, Map<String, String> addressMap) {
		try {
			ImageHtmlEmail email = new ImageHtmlEmail();// 用ImageHtmlEmail来发送
			email.setDebug(true);// 可以看到执行过程的debug信息
			email.setCharset("UTF-8");// 防止乱码
			email.setSSLCheckServerIdentity(true);
			setEmail(email);
			email.setSSLOnConnect(false);
			// Create the email message

			// String email, final String name

			email.setSubject(aSubject);

			// Iterate

			// 解析本地图片和网络图片都有的html文件重点就是下面这两行；
			// ImageHtmlEmail通过setDataSourceResolver来识别并嵌入图片
			// 查看DataSourceResolver的继承结构发现有几个好用的子类
			DataSourceResolver[] dataSourceResolvers;

			dataSourceResolvers = new DataSourceResolver[] {
							new DataSourceFileResolver(), // 添加DataSourceFileResolver用于解析本地图片
							new DataSourceUrlResolver(new URL("http://")) };
			// 添加DataSourceUrlResolver用于解析网络图片，注意：new
			// URL("http://")
			// DataSourceCompositeResolver类可以加入多个DataSourceResolver,
			// 把需要的DataSourceResolver放到一个数组里传进去就可以了；
			email.setDataSourceResolver(new DataSourceCompositeResolver(
							dataSourceResolvers));

			// set the html message
			email.setHtmlMsg(aHtml);

			// set the alternative message
			email.setTextMsg(aText);

			// send the email
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public static void sendingHtmlFormattedEmailWithEmbeddedImages() {
		try {
			// load your HTML email template
			String htmlEmailTemplate = ".... <img src=\"http://www.apache.org/images/feather.gif\"> ....";

			// define you base URL to resolve relative resource locations
			URL url = new URL("http://www.apache.org");

			// create the email message
			ImageHtmlEmail email = new ImageHtmlEmail();
			email.setDataSourceResolver(new DataSourceUrlResolver(url));

			setEmail(email);

			// Create the email message
			email.setSubject("Test email with inline image");

			// set the html message
			email.setHtmlMsg(htmlEmailTemplate);

			// set the alternative message
			email.setTextMsg(
							"Your email client does not support HTML messages");

			// send the email
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public static void sendHtmlEmailWithImg() {
		try {
			String fileName = "20170822083315980_searchByParams.png";
			String imgUrl = System.getProperty("user.dir") + "\\snapshot\\"
							+ fileName;
			String htmlEmailContent = "这是一张用于测试的图片，请查收。 <img src=\"" + imgUrl
							+ "\"> "
							+ " <img src=\"http://commons.apache.org/proper/commons-email/images/commons-logo.png\">";
			ImageHtmlEmail email = new ImageHtmlEmail();// 用ImageHtmlEmail来发送
			email.setDebug(true);// 可以看到执行过程的debug信息
			email.setCharset("UTF-8");// 防止乱码
			email.setSSLCheckServerIdentity(true);

			setEmail(email);

			// 解析本地图片和网络图片都有的html文件重点就是下面这两行；
			// ImageHtmlEmail通过setDataSourceResolver来识别并嵌入图片
			// 查看DataSourceResolver的继承结构发现有几个好用的子类
			DataSourceResolver[] dataSourceResolvers;

			dataSourceResolvers = new DataSourceResolver[] {
							new DataSourceFileResolver(), // 添加DataSourceFileResolver用于解析本地图片
							new DataSourceUrlResolver(new URL("http://")) };
			// 添加DataSourceUrlResolver用于解析网络图片，注意：new
			// URL("http://")
			// DataSourceCompositeResolver类可以加入多个DataSourceResolver,
			// 把需要的DataSourceResolver放到一个数组里传进去就可以了；
			email.setDataSourceResolver(new DataSourceCompositeResolver(
							dataSourceResolvers));

			email.setSubject("发送一张图片，看看是否可以收到。");

			email.setHtmlMsg(htmlEmailContent);

			// 如果客户端不去持HTML格式会显示这句话，不过应该很少有不支持HTML格式的客户端了吧
			email.setTextMsg("你的邮箱客户端不支持HTML格式邮件");
			email.send();

		} catch (MalformedURLException | EmailException e) {
			e.printStackTrace();
		}
	}

}
