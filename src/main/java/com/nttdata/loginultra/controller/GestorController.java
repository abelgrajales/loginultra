package com.nttdata.loginultra.controller;

import com.nttdata.loginultra.utils.JwtUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/gestor")
@PreAuthorize("hasRole('Gestor')")
public class GestorController {

    @GetMapping()
    public Map<String, Object> adminData(Authentication authentication) {
        Map<String, Object> response = new HashMap<>();
        response.put("acceso", "Acceso Gestor FX Ultra");

        JwtUtils.addUserInfoToResponse(authentication, response);

        return response;
    }

}
