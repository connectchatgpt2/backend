package com.ishan.markdowneditor.service.impl;

import com.ishan.markdowneditor.dto.LoginRequestDto;
import com.ishan.markdowneditor.service.ILoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements ILoginService {
    @Override
    public Boolean verifyLogin(LoginRequestDto loginRequestDto) {
        String username = loginRequestDto.getUsername();
        String password = loginRequestDto.getPassword();
        if (username.equals("admin") && password.equals("12345")) {
            return true;
        } else {
            return false;
        }
    }
}
