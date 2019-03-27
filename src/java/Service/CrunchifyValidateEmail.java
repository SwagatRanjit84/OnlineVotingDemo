/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author acer
 */

    public class CrunchifyValidateEmail {
 
	public static void main(String[] args) {
		CrunchifyValidateEmail crunchifyCheck = new CrunchifyValidateEmail();
 
		// Specify Boolean Flag
		boolean isValid = false;
 
		String email = "ddddddddddddddd@gmail.com";
		isValid = crunchifyCheck.crunchifyEmailValidator(email);
		crunchifyCheck.myLogger(email, isValid);
 
//		email = "hello.crunchify";
//		isValid = crunchifyCheck.crunchifyEmailValidator(email);
//		crunchifyCheck.myLogger(email, isValid);
// 
//		email = "hello.crunchify@";
//		isValid = crunchifyCheck.crunchifyEmailValidator(email);
//		crunchifyCheck.myLogger(email, isValid);
	}
 
	private boolean crunchifyEmailValidator(String email) {
		boolean isValid = false;
		try {
			//
			// Create InternetAddress object and validated the supplied
			// address which is this case is an email address.
			                 InternetAddress internetAddress = new InternetAddress(email);
			internetAddress.validate();
			isValid = true;
		} catch (AddressException e) {
			System.out.println("You are in catch block -- Exception Occurred for: " + email);
		}
		return isValid;
	}
 
	private void myLogger(String email, boolean valid) {
		System.out.println(email + " is " + (valid ? "a" : "not a") + " valid email address\n");
	}
}

