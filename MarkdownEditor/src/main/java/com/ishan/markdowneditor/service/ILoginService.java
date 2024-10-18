package com.ishan.markdowneditor.service;

import com.ishan.markdowneditor.dto.LoginRequestDto;

public interface ILoginService {
    Boolean verifyLogin(LoginRequestDto loginRequestDto);
}
