package com.classDojo.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtils {
	private static final String ALGORITHM = "SHA-256";

	public static String encryptPassword(String input) throws NoSuchAlgorithmException {
		// getInstance() method is called with algorithm SHA-512
		MessageDigest md = MessageDigest.getInstance(ALGORITHM);
		/*
		 * digest() method is called to calculate message digest of the input string
		 * returned as array of byte
		 */
		byte[] messageDigest = md.digest(input.getBytes());
		// Convert byte array into signum representation
		BigInteger no = new BigInteger(1, messageDigest);
		// Convert message digest into hex value
		String hashtext = no.toString(16);
		// Add preceding 0s to make it 32 bit
		while (hashtext.length() < 32) {
			hashtext = "0" + hashtext;
		}
		// return the HashText
		return hashtext;
	}
}
