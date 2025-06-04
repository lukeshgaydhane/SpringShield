package com.security.SpringShield.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
        http.sessionManagement(session->session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        http.formLogin(withDefaults());        //for form based authentication
        http.httpBasic(withDefaults());           //for basic authentication
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails user = User
                .withUsername("lukesh")
                .password("{noop}gaydhane")
                .roles("USER")
                .build();
        UserDetails admin = User
                .withUsername("noob")
                .password("{noop}play")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}
