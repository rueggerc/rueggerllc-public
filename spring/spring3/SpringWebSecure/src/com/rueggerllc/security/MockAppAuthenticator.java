package com.rueggerllc.security;

import org.springframework.security.authentication.BadCredentialsException;

/**
 * Dummy implementation of
 * {@link com.agilex.healthcare.mobilehealthplatform.security.AppAuthenticator}
 * to be used for test/mock mode in the app; this is getting injected into
 * {@link com.agilex.healthcare.mobilehealthplatform.security.CustomAuthenticationProvider}
 * 
 * @author seena
 * 
 */
public class MockAppAuthenticator implements AppAuthenticator {

	@Override
	public AppUser authenticate(String accessCode, String verifyCode) {

		if (verifyCode != null && verifyCode.trim().toLowerCase().contains("pass")) {

			AppUser mockUser = getMockedUser(accessCode);

			return mockUser;
		} else {
			
			throw new BadCredentialsException(
			        "Username/Password does not match for username: " + accessCode);
		}
		
	}

	private AppUser getMockedUser(String accessCode) {

		AppUser mockUser = new AppUser();

		mockUser.setFirstName("User");
		mockUser.setLastName(accessCode);
		mockUser.setId(accessCode);

		return mockUser;
	}

}
