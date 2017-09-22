package com.coderdream.sadp;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.coderdream.util.mail.CommonsMailUtil;

public class MyProfileServiceTest extends BaseTest {

	private MyProfileService viewMyProfileService;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		viewMyProfileService = new MyProfileService();
	}

	@Test
	public void testMyProfile() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		String roleName = "普通员工";
		String staffName = "[B-21945]颜冰";

		// 登陆
		viewMyProfileService.login(driver, roleName, staffName);

		// 进入【我的人力看板】页面
		map.putAll(viewMyProfileService.myProfile(driver));

		// 进入【我的基本信息】页面
		map.putAll(viewMyProfileService.myProfileBaseInfo(driver));

		// 修改基本信息后自动返回
		map.putAll(viewMyProfileService.updateMyProfileBaseInfo(driver));

		// 修改技能信息后自动返回
		String skillName = "iOS";
		map.putAll(viewMyProfileService.editSkill(driver, skillName));

		// 发邮件
		String aSubject = "Test email with inline image";

		// set the html message
		StringBuilder aHtml = new StringBuilder("<html>");
		// The apache logo - <img src=\"" + imgUrl
		// + "\">";

		for (Map.Entry<String, String> entry : map.entrySet()) {
			// System.out.println("Key = " + entry.getKey() + ", Value = "
			// + entry.getValue());
			String content = entry.getKey();
			String imgUrl = entry.getValue();
			aHtml.append("<p>" + content + "</p>");
			aHtml.append("<p><img src=\"" + imgUrl + "\"></p>");
		}

		aHtml.append("</html>");
		String aText = "Your email client does not support HTML messages";

		Map<String, String> addressMap = null;
		CommonsMailUtil.sendingHtmlFormattedEmail(aSubject, aHtml.toString(),
						aText, addressMap);
	}

	@Test
	public void testMyProfile_02() {
		String roleName = "普通员工";
		String staffName = "[B-13416]王东霞";
		viewMyProfileService.login(driver, roleName, staffName);

		viewMyProfileService.myProfile(driver);

		// viewMyProfileService.myProfileBaseInfo(driver);

		// viewMyProfileService.updateMyProfileBaseInfo(driver);

		// viewMyProfileService.returnMyProfile(driver);

		String domainName = "ERP";
		viewMyProfileService.editDomain(driver, domainName);
	}

}
