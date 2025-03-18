package com.stockaiproject.controller;

import com.stockaiproject.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping(value = "/token", produces = MediaType.APPLICATION_XML_VALUE)
    public String auth(@RequestParam("serviceKey") String serviceKey) {

        return authService.generateToken(serviceKey);


    }
}
