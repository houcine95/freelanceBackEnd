package com.fennec.freelanceproject.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fennec.freelanceproject.model.AppUser;
import com.fennec.freelanceproject.service.AccountService;
import com.fennec.freelanceproject.service.AccountServiceImp;
import com.fennec.freelanceproject.util.SecurityConstant;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    private AccountService accountService;



    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, AccountService accountService) {
        this.authenticationManager = authenticationManager;
        this.accountService = accountService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        AppUser user = null;
        try{
            user = new ObjectMapper().readValue(request.getInputStream(), AppUser.class);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        User springUser = (User) authResult.getPrincipal();
        System.out.println("the key is : "+SecurityConstant.key.toString());
        String jwtToken = Jwts.builder()
                .setSubject(springUser.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstant.TOKEN_EXPIRATION_TIME))
                .signWith(SecurityConstant.key)
                .claim("roles", springUser.getAuthorities())
                .compact();
        response.addHeader(SecurityConstant.TOKEN_HEADER, SecurityConstant.TOKEN_PREFIX + jwtToken);

        String username = ((User)authResult.getPrincipal()).getUsername();

        AppUser userEntity = this.accountService.findUserByUsername(username);

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("token", jwtToken);
        body.put("user", userEntity.getUsername());
        body.put("message", "success");

        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setStatus(200);
        response.setContentType("application/json");


    }
}
