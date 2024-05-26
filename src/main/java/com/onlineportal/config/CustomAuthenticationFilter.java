package com.onlineportal.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	 private final ObjectMapper objectMapper = new ObjectMapper();

	    @Override
	    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
	        try {
	            // Read the request's payload
	            BufferedReader reader = request.getReader();
	            StringBuilder sb = new StringBuilder();
	            String line;
	            while ((line = reader.readLine()) != null) {
	                sb.append(line);
	            }
	            // Convert JSON payload to a map
	            Map<String, String> requestMap = objectMapper.readValue(sb.toString(), Map.class);
	            // Extract username and password from the map
	            String username = requestMap.get("username");
	            String password = requestMap.get("password");
	            // Create authentication token
	            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
	            // Allow subclasses to set the "details" property
	            setDetails(request, authRequest);
	            // Proceed with authentication
	            return this.getAuthenticationManager().authenticate(authRequest);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }

	    @Override
	    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
	        super.successfulAuthentication(request, response, chain, authResult);
	        // You can add additional actions here upon successful authentication, if necessary.
	    }


}
