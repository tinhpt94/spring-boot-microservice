package com.tinhpt.authservice.controller;

import com.tinhpt.authservice.service.IAuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Auth Rest API")
public class AuthController {

    @Autowired
    private IAuthService authService;

    @PostMapping("/logout")
    @ApiOperation(value = "Logs the specified user device and clears the refresh tokens associated with it")
    public ResponseEntity logout() {
        authService.logout();
        return ResponseEntity.ok("Log out successful");
    }

}
