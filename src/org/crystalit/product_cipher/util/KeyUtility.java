package org.crystalit.product_cipher.util;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class KeyUtility {
	
	public KeyUtility() {}
	
	// Modify the key so that the key has sufficient length.
	public String createKey(String key, String message) {
			
			ArrayList<Character> messageArray = new ArrayList<>();
			ArrayList<Character> keyArray = new ArrayList<>();
			String newKey = "";
			
			// Add message to an array list.
			messageArray = arrayConversion(message);
			
			// Add key to an array list.
			keyArray = arrayConversion(key);
			
			// Synthesize the new key according to the size of the message.
			if(messageArray.size() > keyArray.size()) {
				int difference = messageArray.size() - keyArray.size();
				for (int i = 0; i < difference; i++) {
					keyArray.add(keyArray.get(i));
				}
			} else if (messageArray.size() < keyArray.size()) {
				int difference = keyArray.size() - messageArray.size();
				for (int i = 0; i <keyArray.size() - difference; i++) {
					keyArray.add(keyArray.get(i));
				}
			} else {}
			
			// Convert the key array back to a string.
			for (Character character : keyArray) {
				newKey = newKey + character.toString();
			}
			
			return newKey;
	}
	
	public String encBySubstitution(String message, String key) {
		String encMessage = "";
		String newKey = createKey(key, message);
		int size = message.length();
		ArrayList<Character> messageArray = arrayConversion(message);
		ArrayList<Character> keyArray = arrayConversion(newKey);
		
		for (int i = 0; i < message.length(); i++) {
			encMessage = encMessage + (char)((int)messageArray.get(i) ^ (int)keyArray.get(i));
		}
		
		return encMessage;
	}
	
	// Utility method to convert each string to an array.
	public ArrayList<Character> arrayConversion(String string) {
		ArrayList<Character> arraylist = new ArrayList<>();
		for (int i = 0; i < string.length(); i++) {
			arraylist.add(string.charAt(i));
		}
		return arraylist;
	}
	
	// Sandbox method.
	public void test() {
		char[] test = "b".toCharArray();
		char[] key = "k".toCharArray();
		System.out.println("ASCII version: " + (int)test[0]);
		int temp = (int)test[0] ^ (int)key[0];
		System.out.println("Encrypted version: " + (char)temp );
		System.out.println("Char version: " + (char)(int)(test[0]));
		int temp2 = temp ^ (int)key[0];
		System.out.println("Decrypted version: "  + (char)temp2);
	}
	
}
