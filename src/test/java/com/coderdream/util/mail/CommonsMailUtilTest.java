package com.coderdream.util.mail;

import static org.junit.Assert.*;

import org.junit.Test;

public class CommonsMailUtilTest {

	@Test
	public void testSendSimpleTextEmail() {
		CommonsMailUtil commonsMailUtil  = new CommonsMailUtil();
		commonsMailUtil.sendSimpleTextEmail();
	}

}
