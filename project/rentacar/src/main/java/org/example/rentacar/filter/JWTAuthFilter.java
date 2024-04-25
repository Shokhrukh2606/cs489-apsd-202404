package org.example.rentacar.filter;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.rentacar.service.impl.MyUserDetailsService;
import org.example.rentacar.utility.JWTManagementUtilityService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTAuthFilter extends OncePerRequestFilter {
    private MyUserDetailsService myUserDetailsService;
    private JWTManagementUtilityService jwtManagementUtilityService;
    public  JWTAuthFilter(MyUserDetailsService myUserDetailsService,JWTManagementUtilityService jwtManagementUtilityService){
        this.myUserDetailsService=myUserDetailsService;
        this.jwtManagementUtilityService=jwtManagementUtilityService;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader=request.getHeader("Authorization");
        String jwtToken=null;
        String username=null;
        if(authorizationHeader!=null&&authorizationHeader.startsWith("Bearer ")){
            jwtToken=authorizationHeader.substring(7);
            System.out.println(jwtToken);
            username=jwtManagementUtilityService.extractUsername(jwtToken);
        }
        if(username!=null&& SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails=myUserDetailsService.loadUserByUsername(username);
            if(jwtManagementUtilityService.validateToken(jwtToken,userDetails)){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }

        }
        filterChain.doFilter(request,response);
    }
}
