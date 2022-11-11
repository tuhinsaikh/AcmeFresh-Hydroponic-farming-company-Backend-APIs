package com.acmefresh.controller;

import java.net.http.HttpResponse;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acmefresh.exception.UserAlreadyExists;
import com.acmefresh.model.Role;
import com.acmefresh.model.RoleEnum;
import com.acmefresh.model.User;
import com.acmefresh.payload.request.LoginRequest;
import com.acmefresh.payload.request.SignupRequest;
import com.acmefresh.payload.response.JwtResponse;
import com.acmefresh.payload.response.UserInfoResponse;
import com.acmefresh.repository.RoleRepository;
import com.acmefresh.repository.UserRepository;
import com.acmefresh.service.UserDetailsImpl;
import com.acmefresh.service.UserService;
import com.acmefresh.utility.JwtUtils;

@RestController
@RequestMapping("/")
public class UserController {
	
	  @Autowired
	  private AuthenticationManager authenticationManager;

	  @Autowired
	  private UserRepository userRepository;

	  @Autowired
	  private RoleRepository roleRepository;

	  @Autowired
	  private PasswordEncoder encoder;
	
	  @Autowired
	  private JwtUtils jwtUtils;
	  
	  @Autowired
	  private UserService userService;

	 @PostMapping("signup")
	  public ResponseEntity<String> registerUser(@RequestBody SignupRequest signUpRequest) {
	    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
	      throw new UserAlreadyExists("user already exist with this username");
	    }

	    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
	    	throw new UserAlreadyExists("user already exist with this email");
	    }

	    // Create new user's account
	    User user = new User(signUpRequest.getUsername(),
	                         signUpRequest.getEmail(),
	                         encoder.encode(signUpRequest.getPassword()));

	    Set<String> strRoles = signUpRequest.getRole();
	    Set<Role> roles = new HashSet<>();
	    System.out.println(strRoles);
	    
	    if (strRoles.size()<1) {	
		      throw new RuntimeException("no role defined");
		}else {
			strRoles.forEach(role->{
		        switch (role) {
		        case "seller":
		          System.out.println(role);	
		          Role sellerRole = new Role();
		          sellerRole.setName(RoleEnum.ROLE_SELLER);
		          roles.add(sellerRole);
	
		          break;
		        case "customer":
		        	System.out.println(role);	
			          Role customerRole = new Role();
			          customerRole.setName(RoleEnum.ROLE_CUSTOMER);
			          roles.add(customerRole);
		          break;
		        default:
		          throw new RuntimeException("role does not exists");
		        }
		    });
		}
	    user.setRoles(roles);
	    userRepository.save(user);
	    return new ResponseEntity<String>("account created successfully", HttpStatus.CREATED);
	  }
	 
	 @PostMapping("signin")
	 public JwtResponse authenticateUser(@RequestBody LoginRequest loginRequest) throws Exception {
		 System.out.println(loginRequest);
		  try {
	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(
	                    		loginRequest.getUsername(),
	                    		loginRequest.getPassword()
	                    )
	            );
	        } catch (BadCredentialsException e) {
	            throw new Exception("INVALID_CREDENTIALS", e);
	        }
		  System.out.println(loginRequest);
	        final UserDetails userDetails
	                = userService.loadUserByUsername(loginRequest.getUsername());

	        final String token =
	        		jwtUtils.generateToken(userDetails);

	        return  new JwtResponse(token);
	    
	  }
}
