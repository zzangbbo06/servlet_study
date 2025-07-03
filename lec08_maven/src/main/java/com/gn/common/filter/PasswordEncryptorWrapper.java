package com.gn.common.filter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class PasswordEncryptorWrapper extends HttpServletRequestWrapper{

	public PasswordEncryptorWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String name) {
		String result = super.getParameter(name);
		if(name.contains("memberPw")) {
			result = getSHA512(result);
		}
		return result;
	}
	// 단방향 암호화 메소드
	private String getSHA512(String oriVal) {
		String result = "";
		// 1. Java에서 제공하는 암호화 처리 클래스 객체화
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			// 내가 사용하고자 하는 암호화 로직을 instacne안에 넣기
			
			// 2. String 데이터를 byte 배열로 쪼개기
			byte[] oriValByte = oriVal.getBytes();
			
			// 3. 자른 데이터를 암호화 처리
			md.update(oriValByte);
			
			// 4. 암호화 처리된 값을 byte 배열로 꺼내기
			byte[] encValByte = md.digest();
			
			// 5. byte 배열 데이터를 String으로 변환
			result = Base64.getEncoder().encodeToString(encValByte);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
