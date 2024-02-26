package com.authentication.security.User.Controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.plaf.PanelUI;

@RestController
@RequestMapping("/api/vi/demo")
public class DemoController {
    @GetMapping
    @Secured("ADMIN")
    public ResponseEntity<?> sayHello()
    {
        try {
            return ResponseEntity.ok("Hello FRom Secured Endpoint");
        }catch (Exception err)
        {
//            System.out.println(err.getMessage());
            return ResponseEntity.ok(err.getMessage());
        }
    }
}
