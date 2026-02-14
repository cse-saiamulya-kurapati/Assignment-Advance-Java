package com.capgemini.junit;

public class LoginValidationSystem {
	
	public boolean isValidUsername(String username) {
		if(username == null) return false;
		
		if(username.isEmpty()) return false;
		
		if(username.length()<5 || username.length()>15) return false;
		
		if(!username.matches("[a-zA-Z0-9]+")) return false;

		
		return true;
	}
	public boolean isValidPassword(String password) {

	    if (password == null || password.length() < 8)
	        return false;

	    boolean hasAlphabet = false;
	    boolean hasDigit = false;
	    boolean hasSpecial = false;

	    for (char ch : password.toCharArray()) {

	        if (Character.isLetter(ch)) hasAlphabet = true;
	        if (Character.isDigit(ch)) hasDigit = true;
	        if (!Character.isLetterOrDigit(ch))
	            hasSpecial = true;
	    }

	    return hasAlphabet && hasDigit && hasSpecial;
	}

	public boolean login(String username,String password) {
		return isValidUsername(username) && isValidPassword(password);
	}
} 
