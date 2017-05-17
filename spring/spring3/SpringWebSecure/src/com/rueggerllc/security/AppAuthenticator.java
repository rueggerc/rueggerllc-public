package com.rueggerllc.security;


/**
 * Simple interface to implement custom authentication, which will be used in  {@link com.agilex.healthcare.mobilehealthplatform.security.CustomAuthenticationProvider}
 * 
 *  This would allow switching authentication mechanism for different backends/modes in the MHP application
 *  
 * @author Seena
 *
 */
public interface AppAuthenticator {

	public AppUser authenticate(String accessCode, String verifyCode) throws Exception;
	
}