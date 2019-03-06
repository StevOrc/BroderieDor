package com.broderieDor.registration.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginForm {
	
	   	@NotBlank
	    @Size(min=5, max = 30)
	    private String username;
	 
	    @NotBlank
	    @Size(min = 5, max = 30)
	    private String password;
	 
	    
	    
	    public LoginForm(@NotBlank @Size(min = 5, max = 20) String username,
				@NotBlank @Size(min = 5, max = 20) String password) {
			super();
			this.username = username;
			this.password = password;
		}

		public String getUsername() {
	        return username;
	    }
	 
	    public void setUsername(String username) {
	        this.username = username;
	    }
	 
	    public String getPassword() {
	        return password;
	    }
	 
	    public void setPassword(String password) {
	        this.password = password;
	    }
}
