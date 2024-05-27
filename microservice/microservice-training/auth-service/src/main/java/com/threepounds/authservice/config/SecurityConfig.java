package com.threepounds.authservice.config;

import com.threepounds.authservice.service.OAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final OAuth2UserService oAuth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http

            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/user/list").permitAll()
                    .requestMatchers("/user/**").permitAll()
                .anyRequest().authenticated()
            ).oauth2Login(oauth2 -> oauth2
                .userInfoEndpoint(infoEndpoint ->
                    infoEndpoint.userService(oAuth2UserService)));
        return http.build();
    }

}



