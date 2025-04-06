package com.example.auto_market.SpringSecurity.Config;

import java.beans.Customizer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.auto_market.SpringSecurity.Security.JWT.DomainUserDetailsService;
import com.example.auto_market.SpringSecurity.Security.JWT.jwtFilter;
import com.example.auto_market.SpringSecurity.Security.JWT.jwtService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final jwtService tokenProvider;

   private final DomainUserDetailsService userDetailsService;
    public SecurityConfig(jwtService tokenProvider, DomainUserDetailsService userDetailsService) {
        this.tokenProvider = tokenProvider;
        this.userDetailsService = userDetailsService;
        
    }

    
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http,PasswordEncoder passwordEncoder) throws Exception {
        AuthenticationManagerBuilder authBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authBuilder
            .userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder);
        return authBuilder.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(final HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http
        .securityMatcher("/**")
                .authorizeHttpRequests( authz -> authz
                .requestMatchers(HttpMethod.POST, "/api/authenticate").permitAll()
                .requestMatchers("/api/registro").permitAll()
                .requestMatchers("/", "/index.html").permitAll() 
                .requestMatchers(HttpMethod.GET, "/api/publicaciones").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(new jwtFilter(this.tokenProvider), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    

}
