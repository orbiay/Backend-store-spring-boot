package com.authentication.security.User.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/vi/demo")
public class DemoController {
    @GetMapping("/yes")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> sayHello() {
        try {
            System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
            return ResponseEntity.ok(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        } catch (Exception err) {
            return ResponseEntity.ok(err.getMessage());
        }
    }

    @GetMapping("/no")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> sayHelloNotSecured()
    {
        try {
            System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
            return ResponseEntity.ok(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        }catch (Exception err)
        {
//            System.out.println(err.getMessage());
            return ResponseEntity.ok(err.getMessage());
        }
    }
}
