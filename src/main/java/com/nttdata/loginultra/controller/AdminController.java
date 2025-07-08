package com.nttdata.loginultra.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AdminController {

    @GetMapping("/validate-token")
    public ResponseEntity<Map<String, Object>> adminData(Authentication authentication) {
        Jwt jwt = (Jwt) authentication.getPrincipal();
        String userName = jwt.getClaimAsString("name");
        List<String> roles = jwt.getClaimAsStringList("roles"); // Roles extraídos por Spring Security

        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", "¡Usuario autenticado y validado por el backend!");
        responseBody.put("userName", userName != null ? userName : "N/A");
        responseBody.put("roles", roles != null ? roles : Collections.emptyList()); // <-- Envía los roles aquí

        return ResponseEntity.ok(responseBody);

    }

}
