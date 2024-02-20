package com.authentication.security.User.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.plaf.PanelUI;

@RestController
@RequestMapping("/api/vi/demo")
public class DemoController {
    @GetMapping
    public ResponseEntity<String> sayHello()
    {
        return ResponseEntity.ok("Hello FRom Secured Endpoint");
    }
}
