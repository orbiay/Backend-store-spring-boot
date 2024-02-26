package com.authentication.security.User.Controller;

import com.authentication.security.User.Dto.AuthenticationRequest;
import com.authentication.security.User.Dto.AuthenticationResponse;
import com.authentication.security.User.Dto.RegisterRequest;
import com.authentication.security.User.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vi/auth")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    )
    {
        try{
            return ResponseEntity.ok( this.userService.register(request));
        }catch (Exception err){}
        return null;
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    )
    {
        return null;
    }
}
