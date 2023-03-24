package com.yashwin.blog.blogappapis.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    
    @Autowired
    private UserDetailsService UserDetailsService;

    @Autowired
    private JwtTokenHelper jwtTokenHelper;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {  
        
     // 1. get token 
     String requestToken = request.getHeader("Authorization");

     System.out.println(requestToken);

     String username = null;

     String token = null;

     if(requestToken!=null && requestToken.startsWith("Bearer"))
        {
            token = requestToken.substring(7);
            try
            {
                username = this.jwtTokenHelper.getUsernameFromToken(token);
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("unable to get Jwt token");
            }
            catch(ExpiredJwtException e)
            {
                System.out.println("Jwt token has expired");
            }
            catch (MalformedJwtException e)
            {
                System.out.println("invalid Jwt");
            }
            
       }
        else
            {
                System.out.println("Jwttoken does not start with bearer");
            }
    

    // 2. validate 
    if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
    {
        UserDetails userDetails = this.UserDetailsService.loadUserByUsername(username);

        if(this.jwtTokenHelper.validateToken(token, userDetails))
        {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
        else 
        {
            System.out.println("invalid Jwt token");
        }
    }
    else 
    {
        System.out.println("Username is null or context is null");
    }

    filterChain.doFilter(request, response);
}
            
}


