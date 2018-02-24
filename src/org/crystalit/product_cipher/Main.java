package org.crystalit.product_cipher;

import org.crystalit.product_cipher.util.KeyUtility;

public class Main {
	
	public static void main(String[] args) {
		KeyUtility keyUtility = new KeyUtility();
		System.out.println("Welcome to Product Cipher Program!");
		System.out.println("Message is: 'dasun'");
		System.out.println("Encrypted message is: " + keyUtility.encBySubstitution("dasun", "key"));
		String encMessage = keyUtility.encBySubstitution("dasun", "key");
		System.out.println("Decrypted message is: " + keyUtility.encBySubstitution(encMessage, "key"));
//		keyUtility.test();
	}
	
}
