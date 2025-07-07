package com.nttdata.loginultra.controller;

import com.nttdata.loginultra.utils.JwtUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('Admin')")
public class AdminController {

    @GetMapping()
    public Map<String, Object> adminData(Authentication authentication) {
        Map<String, Object> response = new HashMap<>();
        response.put("acceso", "Acceso administrador FX Ultra");

        JwtUtils.addUserInfoToResponse(authentication, response);

        return response;
    }

}
