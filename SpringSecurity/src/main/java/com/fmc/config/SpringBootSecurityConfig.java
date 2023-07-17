package com.fmc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringBootSecurityConfig {
	@Value("${user.admin.name}")
	private String adminNmae;
	@Bean
	SecurityFilterChain customFIlterchain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests((requests)->requests
		.requestMatchers("/cards","/loans","/balance","/account").authenticated()
		.requestMatchers("/contact","/notice").permitAll())
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults());
		return http.build();
		
	}
	//appraoach-1
	/*
	 * @Bean public InMemoryUserDetailsManager userDetailsService(){ UserDetails
	 * admin =
	 * User.withDefaultPasswordEncoder().username(adminNmae).password("12345").
	 * authorities("admin").build(); UserDetails user =
	 * User.withDefaultPasswordEncoder().username("user").password("12345").
	 * authorities("read").build(); return new
	 * InMemoryUserDetailsManager(admin,user); }
	 */
	@Bean
	public InMemoryUserDetailsManager userDetailsService(){
		UserDetails admin=User.withUsername("admin")
				.password("12345").authorities("admin").build();
		UserDetails user=User.withUsername("user")
				.password("12345").authorities("read").build();
		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(); 
		inMemoryUserDetailsManager.createUser(admin);
		inMemoryUserDetailsManager.createUser(user);
		return inMemoryUserDetailsManager;
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
