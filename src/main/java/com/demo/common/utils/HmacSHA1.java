package com.demo.common.utils;

import org.apache.commons.lang3.StringUtils;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HmacSHA1 {
	 
	 
	private final  String HMACSHA1 = "HmacSHA1";
	private SecretKey   key = null;
	 
	
	//返回随机生成的key
	
	/**
	 * 
	 * @return  byte => base64 String  
	 */
	public String getSecretKey() {
		
		KeyGenerator keyGen;
		try {
			keyGen = KeyGenerator.getInstance(HMACSHA1);
			key = keyGen.generateKey();
			
			byte[] keyByte = this.key.getEncoded();
			return Base64.getEncoder().encodeToString(keyByte);
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
			
		}
		return "";
	}
	
	
	//返回密文
	public  String getSecretValue(@NotBlank String password) throws Exception  {
		
		if(this.key == null) throw new NullPointerException("需要先调用 静态方法 getSecretKey()");
 
			 Mac mac = Mac.getInstance(HMACSHA1);
			
			 mac.init(this.key);
			 mac.update(password.getBytes("UTF-8"));
			byte[] result =  mac.doFinal();
			return new BigInteger(1,result).toString(16);
	}
	
	
	//根据key和 字符串 返回密文
	public String getSecretValue(@Valid @NotBlank String salt, @Valid @NotBlank String str)
			throws NoSuchAlgorithmException {

		if (StringUtils.isBlank(salt) || StringUtils.isBlank(str) )
			return "";

		
		byte[] parameKey = Base64.getDecoder().decode(salt);
		SecretKey secretKey = new SecretKeySpec(parameKey, HMACSHA1);
		Mac mac = Mac.getInstance(HMACSHA1);
		try {
			mac.init(secretKey);
			mac.update(str.getBytes("UTF-8"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		byte[] result = mac.doFinal();
		String passwordHashed = new BigInteger(1, result).toString(16);
		return passwordHashed;
	}
	
	
	
	//检查
	
	/***
	 * 
	 * @param base64KeyStr
	 * @param password
	 * @param secretPassword
	 * @return
	 * @throws InvalidKeyException 
	 * @throws UnsupportedEncodingException 
	 * @throws IllegalStateException 
	 */
	public  boolean checkSecretValue(@NotBlank  String base64KeyStr,@NotBlank String password,@NotBlank String secretPassword) throws Exception { 
		
		byte[] parameKey = Base64.getDecoder().decode(base64KeyStr);
		SecretKey secretKey = new SecretKeySpec(parameKey, HMACSHA1);
		Mac mac = Mac.getInstance(HMACSHA1);
		
		mac.init(secretKey);
		mac.update(password.getBytes("UTF-8"));
		byte[] result = mac.doFinal();
		
		String passwordHashed = new BigInteger(1,result).toString(16);
		if(passwordHashed.equals(secretPassword)) {return true;}
		return false;
		
	}

  
	
	/**
	 * 
	 * @param oldSalt
	 * @param oldPassword
	 * @param password
	 * @return
	 */
	public   boolean checkPassword(String oldSalt,String oldPassword, String password) {
		
		boolean checkResult = false;

		try {
			checkResult = this.checkSecretValue(oldSalt, password,oldPassword);			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return checkResult;
 
	}

 
}
