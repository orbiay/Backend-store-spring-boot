package com.authentication.security.User.Service;

import com.authentication.security.Config.JwtService;
import com.authentication.security.User.Dto.AuthenticationRequest;
import com.authentication.security.User.Dto.AuthenticationResponse;
import com.authentication.security.User.Dto.RegisterRequest;
import com.authentication.security.User.Repository.UserRepository;
import com.authentication.security.User.Role;
import com.authentication.security.User.user;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
//    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request)
    {
        System.out.println(request.getPassword());
        user user = new user(request.getFirstname(),request.getLastname(),request.getEmail(),passwordEncoder.encode(request.getPassword()), Role.USER);
        userRepository.save(user);
        var jwtToken = this.jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
    public AuthenticationResponse authenticate(AuthenticationRequest request)
    {
//        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken((request.getEmail()),request.getPassword()));
        user user = this.userRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = this.jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
