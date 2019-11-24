package com.tinhpt.hr.controllers;

import com.tinhpt.hr.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Secured("ROLE_ADMIN")
    @RequestMapping(method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public ResponseEntity<Long> createUser(@RequestPart("user") UserCreateRequest request, @RequestPart("file") MultipartFile file) {
        return ResponseEntity.ok(userService.create(request, file));
    }

    @GetMapping()
    public ResponseEntity<UserDetailResponse> getCurrentUser() {
        return  ResponseEntity.ok(userService.getCurrentUser());
    }
}
