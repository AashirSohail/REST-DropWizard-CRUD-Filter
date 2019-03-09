package edu.seecs.dropwizard;



import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

import java.util.Optional;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

public class auth implements Authenticator<BasicCredentials, User> {
	
	private static final ImmutableMap<String, ImmutableSet<? extends Object>> VALID_USERS = ImmutableMap.of(
	        "guest", ImmutableSet.of(),
	        "user", ImmutableSet.of("USER"),
	        "admin", ImmutableSet.of("ADMIN", "USER")
	    );
	 
	    @Override
	    public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException
	    {
	        if (VALID_USERS.containsKey(credentials.getUsername()) && "password".equals(credentials.getPassword()))
	        {
	            return Optional.of(new User(credentials.getUsername()));
	        }
	        return Optional.empty();
	    }

}
