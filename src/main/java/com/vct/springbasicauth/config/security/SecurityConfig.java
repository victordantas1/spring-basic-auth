package com.vct.springbasicauth.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((auth) ->
                        auth.requestMatchers(HttpMethod.POST, "/produtos").permitAll()
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .build();
    }
    /*
    @Bean
    public InMemoryUserDetailsManager memoryUser() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("victor")
                .password("senha123")
                .roles("ADMIN")
                .build();
        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("user")
                .password("senha123")
                .roles("USER")
                .build();
        List<UserDetails> list = new ArrayList<>();
        list.add(user);
        list.add(user2);
        return new InMemoryUserDetailsManager(list);
    }
    */
}
