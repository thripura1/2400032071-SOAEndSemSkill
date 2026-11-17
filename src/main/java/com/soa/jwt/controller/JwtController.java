
package com.soa.jwt.controller;

import com.soa.jwt.model.UserRequest;
import com.soa.jwt.service.JwtService;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/jwt")
public class JwtController {

    private final JwtService jwtService;

    public JwtController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/generate")
    public Map<String, String> generate(
            @RequestBody UserRequest user) {

        String token = jwtService.generateToken(
            user.getUsername(),
            user.getRole());

        return Map.of("token", token);
    }
}
