// package org.iiitb.pushd.security;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfigurerAdapter {

// 	private UserDetailsService userDetServ;
// 	private BCryptPasswordEncoder bcrypt;

// 	@Override
// 	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
// 		auth.userDetailsService(userDetServ).passwordEncoder(bcrypt);
// 	}

// 	@Override
// 	protected void configure(HttpSecurity http) throws Exception {
// 		// TODO Auto-generated method stub
// 		super.configure(http);
// 	}

// }
