package com.nttdata.loginultra.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Map;

public class JwtUtils {

    public static void addUserInfoToResponse(Authentication authentication, Map<String, Object> response) {
        if (authentication instanceof JwtAuthenticationToken) {
            JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication;

            response.put("nombre", jwtAuth.getToken().getClaimAsString("name"));
            response.put("email", jwtAuth.getToken().getClaimAsString("unique_name"));
            response.put("authorities", authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .toList());
        }
    }
}
