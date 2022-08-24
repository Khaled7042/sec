package com.security.sec.Controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class controller {


    @GetMapping(value = "/login", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {


        Collection <SimpleGrantedAuthority> authorities =
                (Collection<SimpleGrantedAuthority>)
                        authentication.getAuthorities();
        authorities.stream().forEach(auth-> System.out.println(auth.getAuthority()));

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            String cookiesString = Arrays.stream(cookies)
                    .map(c -> c.getName() + "=" + c.getValue()).collect(Collectors.joining(", "));

            System.out.println(cookiesString);
        }

        // create a cookie
        Cookie cookie = new Cookie("username", "Jovan");
        cookie.setDomain("securewebsite.nl");
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        //add cookie to response
        response.addCookie(cookie);


        return ResponseEntity.ok("Hello !!");
    }



}
