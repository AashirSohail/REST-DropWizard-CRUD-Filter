package edu.seecs.dropwizard;



import io.dropwizard.auth.Authorizer;
 
public class authorizer implements Authorizer<User>
{
    @Override
    public boolean authorize(User user, String role) {
        return user.getRoles() != null && user.getRoles().contains(role);
    }
}