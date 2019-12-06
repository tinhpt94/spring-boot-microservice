package com.tinhpt.hr.controllers;

import com.tinhpt.hr.services.IEmployeeService;
import com.tinhpt.hr.services.IFakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService userService;

    @Autowired
    private IFakerService fakerService;

    @Secured("ROLE_HR_ADMIN")
    @RequestMapping(method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public ResponseEntity<Long> createUser(@RequestPart("user") EmployeeCreateRequest request, @RequestPart("file") MultipartFile file) {
        return ResponseEntity.ok(userService.create(request, file));
    }

    @GetMapping()
    public ResponseEntity<EmployeeResponse> getCurrentUser() {
        return  ResponseEntity.ok(userService.getCurrentUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getCurrentUser(@PathVariable("id") Long id) {
        return  ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity createFakeEmployeedata() {
        //fakerService.createTeleSale();
        //fakerService.createSale();
        //fakerService.createSaleAdmin();
        fakerService.createSaleManager();
        return ResponseEntity.ok("Created");
    }
}
