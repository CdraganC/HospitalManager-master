package com.siit.hospital_manager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web -> web.ignoring().requestMatchers("/", "/public"));
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/", "/public", "/api-docs/**", "/swagger-ui/**",
                        "/actuator/**", "/mvc/patient/create", "/validationError.html", "/error",
                        "/favicon.ico", "/mvc/patient/submitCreatePatientForm", "/entityExistsError.html", "/static/**").permitAll()
                .requestMatchers("/dashboard/**", "/dashboard", "/appointment/**","/medication/**", "/diagnose/**").hasAnyRole("PATIENT", "ADMIN", "DOCTOR")
                .requestMatchers("/**").hasRole("ADMIN")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .formLogin()
                .and()
                .csrf().disable();
        return http.build();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
