package com.acmefresh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.acmefresh.service.UserService;
import com.acmefresh.utility.AuthEntryPointJwt;
import com.acmefresh.utility.AuthTokenFilter;


@Configuration
@EnableAutoConfiguration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	 
	@Autowired
	private UserService userService;
	
	 @Autowired
	 private AuthEntryPointJwt unauthorizedHandler;
	 
	 @Autowired
	 private AuthTokenFilter authTokenFilter;
	

	 
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf()
	                .disable()
	                .authorizeRequests()
	                .antMatchers("/signin","/signup").permitAll()
	                .antMatchers("/seller","/seller/**","/product","/product/**","/products").hasRole("SELLER")
	                .antMatchers("/customer","/customer/**","/productsOrder/**","/servicesOrder/**").hasRole("CUSTOMER")
	                
	                .anyRequest()
	                .denyAll()
	                .and()
	                .sessionManagement()
	                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	        http.addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class);

	    }


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);
	}
	
	  @Bean
	  public DaoAuthenticationProvider authenticationProvider() {
	      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	       
	      authProvider.setUserDetailsService(userService);
	      authProvider.setPasswordEncoder(passwordEncoder());
	   
	      return authProvider;
	  }
	
	 @Bean
	 public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
	    return authConfig.getAuthenticationManager();
	 }
	 
	 @Bean
	 public AuthTokenFilter authenticationJwtTokenFilter() {
	    return new AuthTokenFilter();
	 }
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
//	 @Bean
//	 public PasswordEncoder passwordEncoder() {
//	     return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	 }

}
