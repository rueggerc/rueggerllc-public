package com.rueggerllc.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;


/**
 * This class is used by Spring Security configuration to allow Custom
 * Authentication. The framework will delegate the handling of the http request
 * to the authenticate() method of this class and it passes the auth info
 * entered by the client which needs to be verified by {@link AppAuthenticator}
 * implementation. Additional info and objects can be added to the
 * inputAuthentication object and returned which will be available in
 * {@link SecurityContextHolder}
 * 
 * @author seena
 * 
 */
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private static final Log logger = LogFactory.getLog(CustomAuthenticationProvider.class);
	
	// This will be injected by Spring via the setter method
	AppAuthenticator appAuthenticator;

	
	@Override
	public Authentication authenticate(Authentication inputAuthentication)
	        throws AuthenticationException {

		logger.debug("attempt to Authenticate...");
		
		String username = (String) inputAuthentication.getPrincipal();
		String password = (String) inputAuthentication.getCredentials();

		/*
		 * We take the passed auth object by the framework from the client
		 * (inputAuthentication), and add more information to it via the
		 * buildOutputAuthenticationObject method, and we call the completed
		 * object outputAuthentication
		 */
		Authentication outputAuthentication = doTheInternalAuthentication(inputAuthentication, username, password) ;
	
		return outputAuthentication;
	}


	private Authentication doTheInternalAuthentication(Authentication inputAuthentication, String username, String password) {

		AppUser authenticatedUser;
		
		//Authenticate against the backend system (an implementation of AppAuthenticator)
		try {
	         authenticatedUser = appAuthenticator.authenticate(username, password);
        } catch (Exception e) {
        	
        	logger.error("auth failed:" + e, e);

			throw new BadCredentialsException(
			        "Username/Password does not match for " + inputAuthentication.getPrincipal());
        }
        
        Authentication outputAuthentication =   buildOutputAuthenticationObject(inputAuthentication, authenticatedUser, username, password);
        
        return outputAuthentication;
		
    }

	private Authentication buildOutputAuthenticationObject(Authentication inputAuthentication, AppUser authenticatedUser, String username, String password) {
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		//Hard-coding a single authority/role for now - it's not used at this time but it's required by the framework
		//TODO:: this can be externalized 
		// authorities.add(new SimpleGrantedAuthority("ROLE_MHP_USER"));

		// AppUser appUser = new AppUser(username, password, authorities, authenticatedUser);
		AppUser appUser = null;
		

		return new UsernamePasswordAuthenticationToken(appUser, inputAuthentication.getCredentials(), authorities);
    }

	
	@Override
	public boolean supports(Class<? extends Object> authentication) {
		
		// Returns true if this AuthenticationProvider supports the indicated
		// Authentication object. See the javadoc on the interface for details.
		// copied it from AbstractUserDetailsAuthenticationProvider
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

	/**
	 * setter required by IOC to inject...
	 * 
	 * @param appAuthenticator to be injected by Spring
	 */
	public void setAppAuthenticator(AppAuthenticator appAuthenticator) {
		this.appAuthenticator = appAuthenticator;
	}

}