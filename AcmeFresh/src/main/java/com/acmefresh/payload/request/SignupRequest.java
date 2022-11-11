package com.acmefresh.payload.request;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {
	
	    private String username;
	    private String email;
	    private String password;
	    private Set<String> role;
}
