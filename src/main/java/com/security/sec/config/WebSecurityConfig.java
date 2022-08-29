package com.security.sec.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    String userId1 = "user";

    String password1 = "$2a$10$qP7GjYfrVAUXn.katgOswONWEsbyIdQNjOgZ5tc92JKMYHr7DVNNO";

    String userId2 = "admin";

    String password2 = "$2a$10$qP7GjYfrVAUXn.katgOswONWEsbyIdQNjOgZ5tc92JKMYHr7DVNNO";



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("namhm")
                .password(password1)
                .roles("USER","ADMIN")
                .and()
                .withUser("admin")
                .password(password2)
                .roles("ADMIN")
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .and()
                .formLogin()
        ;

    }



}
