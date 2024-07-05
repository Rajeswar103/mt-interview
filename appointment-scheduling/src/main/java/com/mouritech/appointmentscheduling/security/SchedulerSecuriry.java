package com.mouritech.appointmentscheduling.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.mouritech.appointmentscheduling.serviceimpl.CustomRegistration;
import com.mouritech.appointmentscheduling.serviceimpl.JwtFilter;

@Configuration
public class SchedulerSecuriry {
	
	@Autowired
	private JwtFilter filter;

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().requestMatchers("/regestration","/generatejwttoken").permitAll();
//		http.authorizeHttpRequests(requests -> requests.requestMatchers("/schedulemettings").hasAuthority("SCHEDULER")
//			    .anyRequest().authenticated());
		http.authorizeHttpRequests().requestMatchers("/schedulemettings").hasAuthority("SCHEDULER").and().
		authorizeHttpRequests()
				.requestMatchers("/getallmettingsdetails", "/updateschedulemeetings",
						"/updateallschedulemeetings" + "/getallmettingsbasedoncategory","/getAllmettingsbasedonusername")
				.hasAuthority("ADMIN").and().authorizeHttpRequests()
				.requestMatchers("/getAllmettingsbasedoncategoryandapproval").hasAnyAuthority("MINISTER").anyRequest()
				.authenticated()
				.and()
				.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(authenticationProvider())
				.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		http.csrf(csrf -> csrf.disable());
		http.formLogin();
		http.httpBasic();
		return http.build();
	}

	@Bean
	public PasswordEncoder password() {
		return new BCryptPasswordEncoder();

	}

	@Bean
	public UserDetailsService userDetailService() {
		return new CustomRegistration();

	}

	@Bean
	AuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailService());
		provider.setPasswordEncoder(password());
		return provider;

	}
	@Bean
	AuthenticationManager autheManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();

	}

}
