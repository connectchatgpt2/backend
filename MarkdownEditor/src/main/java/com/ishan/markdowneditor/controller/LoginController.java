package com.ishan.markdowneditor.controller;

import com.ishan.markdowneditor.dto.LoginRequestDto;
import com.ishan.markdowneditor.service.ILoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*",exposedHeaders = "*")
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class LoginController {
    ILoginService iLoginService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto) {
        Boolean isLoginSuccess = iLoginService.verifyLogin(loginRequestDto);
        if (isLoginSuccess) {
            return ResponseEntity.ok("Login Successful");
        } else return ResponseEntity.badRequest().body("Login Failed");
    }
}
