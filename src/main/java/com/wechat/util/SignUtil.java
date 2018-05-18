package com.wechat.util;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by zxc on 2018/2/19.
 */
public class SignUtil {

	/**
	 * 将字节码转为字符串
	 * @param byteArray
	 * @return
	 */
	private static String byteToStr(byte[] byteArray) {
		String strDigest = "";
		for (int i = 0; i < byteArray.length; i++) {
			strDigest += byteToHexStr(byteArray[i]);
		}
		return strDigest;
	}

	/**
	 * 将字节码转为16进制字符
	 * @param mByte
	 * @return
	 */
	private static String byteToHexStr(byte mByte) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		char[] tempArr = new char[2];
		tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
		tempArr[1] = Digit[mByte & 0X0F];

		String s = new String(tempArr);
		return s;
	}

	/**
	 * 验证签名
	 *
	 * @param token 微信服务器token，在env.properties文件中配置的和在开发者中心配置的必须一致
	 * @param signature 微信服务器传过来sha1加密的证书签名
	 * @param timestamp 时间戳
	 * @param nonce 随机数
	 * @return
	 */
	public static boolean checkSignature(String token,String signature, String timestamp, String nonce) {
		//
		String[] arr = new String[] { token, timestamp, nonce };
		Arrays.sort(arr);

		StringBuilder content = new StringBuilder();

		for (int i = 0; i < arr.length; i++) {
			content.append(arr[i]);
		}
		MessageDigest md = null;
		String tmpStr = null;

		try {
			md = MessageDigest.getInstance("SHA-1");
			// 将三个参数字符串拼接成一个字符串进行sha1加密
			byte[] digest = md.digest(content.toString().getBytes());
			tmpStr = byteToStr(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		content = null;

		return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
	}

	public static String sha1(String str) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			digest.update(str.getBytes());
			byte messageDigest[] = digest.digest();
			// Create Hex String
			StringBuffer hexString = new StringBuffer();
			// 字节数组转换为 十六进制 数
			for (int i = 0; i < messageDigest.length; i++) {
				String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexString.append(0);
				}
				hexString.append(shaHex);
			}
			return hexString.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}


	public static String sort(String token, String timestamp, String nonce) {
		String[] strArray = {token, timestamp, nonce};
		Arrays.sort(strArray);
		StringBuilder sb = new StringBuilder();
		for (String str : strArray) {
			sb.append(str);
		}
		return sb.toString();
	}
}
