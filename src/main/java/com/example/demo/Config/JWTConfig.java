package com.example.demo.Config;//package com.example.demo.Config;
//
//import com.example.demo.Service.JWTService;
//import com.example.demo.Service.UserService;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Conditional;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//import org.thymeleaf.util.StringUtils;
//
//import java.io.IOException;
//
//@Configuration
//@RequiredArgsConstructor
//@Component
//public class JWTConfig extends OncePerRequestFilter {
//    private final JWTService jwtService;
//    private final UserService userService;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String initTocken=request.getHeader("Authorization");
//        String userEmail;
//        String extractedJwtToken;
//        if (StringUtils.isEmpty(initTocken)|| !initTocken.startsWith("Bearer ")){
//            filterChain.doFilter(request,response);
//            return;
//        }
//        extractedJwtToken =initTocken.substring(7);
//        userEmail=jwtService.extractUserName(extractedJwtToken);
//
//            if (StringUtils.isEmpty(userEmail)&&
//                    SecurityContextHolder.getContext().getAuthentication()==null){
//                var userDetails=userService.userDetailsService().loadUserByUsername(userEmail);
//                if (jwtService.validateToken(extractedJwtToken,userDetails)){
//                    SecurityContext emptyContext=SecurityContextHolder.createEmptyContext();
//                    var authToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
//                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                    emptyContext.setAuthentication(authToken);
//                    SecurityContextHolder.setContext(emptyContext);
//                }
//            }
//    }
//}
