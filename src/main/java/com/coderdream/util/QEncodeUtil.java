package com.coderdream.util;

import java.net.URLEncoder;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

//import org.springframework.util.Base64Utils;

/**
 * <pre>
 * 编码工具类
 * 1.将byte[]转为各种进制的字符串
 * 2.base 64 encode
 * 3.base 64 decode
 * 4.获取byte[]的md5值
 * 5.获取字符串md5值
 * 6.结合base64实现md5加密
 * 7.AES加密
 * 8.AES加密为base 64 code
 * 9.AES解密
 * 10.将base 64 code AES解密
 * </pre>
 * 
 * @author uikoo9
 * @version 0.0.7.20140601
 */
public class QEncodeUtil {

	private static final String PASSWORD = "0123456789abcdef";

	public static void main(String[] args) {
		// String decrypt =
		// decrypt("S3LFUHV9svY6HrGhIQp+TG/+TafiBSXT9Fkq5gjQ73Q=");
		// System.out.println("解密后" + "：" + decrypt);

		// String encryptString = encrypt("B-26026");
		// System.out.println("加密后" + "：" + encryptString);

		String encryptString = "oFhJKfDAVBriCk5AVX8Hthj15DitMBENUuxrnSAr428=";
		String decryptString = QEncodeUtil.decrypt(encryptString);
		System.out.println("解密后" + "：" + decryptString);
	}

	/**
	 * 加密
	 * 
	 * @param content
	 *            需要加密的内容
	 * @return
	 */
	public static String encrypt(String content) {
		try {
			content = content + "|" + new Date().getTime();
			byte[] encryptBytes = content.getBytes(Constants.ENCODING);
			byte[] raw = PASSWORD.getBytes(Constants.ENCODING);
			SecretKeySpec sks = new SecretKeySpec(raw, "AES");
			// 创建密码器
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			// 初始化
			cipher.init(Cipher.ENCRYPT_MODE, sks);
			byte[] result = cipher.doFinal(encryptBytes);
			String str = URLEncoder.encode(base64Encode(result),
					Constants.ENCODING); // 加密
			// str = URLDecoder.decode(str, Constants.ENCODING);
			// System.out.println("加密后：" + str);
			return str; // 加密
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解密
	 * 
	 * @param content
	 *            待解密内容
	 * @return
	 */
	public static String decrypt(String content) {
		try {
			byte[] encryptBytes = base64Decode(content);
			byte[] raw = PASSWORD.getBytes(Constants.ENCODING);
			SecretKeySpec sks = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, sks);
			byte[] decryptBytes = cipher.doFinal(encryptBytes);
			String result = new String(decryptBytes);
			return result.split("\\|")[0];
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static byte[] base64Decode(String bs) throws Exception {
		return Base64.decodeBase64(bs);
	}

	private static String base64Encode(byte[] bytes) {
		return Base64.encodeBase64String(bytes);
	}

	// /**
	// * 解密
	// *
	// * @param pwd
	// * @return
	// * @see [类、类#方法、类#成员]
	// */
	// public static byte[] base64Decode(String pwd) {
	// byte[] debytes = Base64.decodeBase64(pwd);
	// return debytes;
	// }
	//
	// /**
	// * 加密
	// *
	// * @param pwd
	// * @return
	// * @see [类、类#方法、类#成员]
	// */
	// public static String base64Encode(byte[] bytes) {
	// return Base64.encodeBase64URLSafeString(bytes);
	// }
}
