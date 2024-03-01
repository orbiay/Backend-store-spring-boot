package com.authentication.security.User.Service;

import com.authentication.security.User.Dto.AuthenticationRequest;
import com.authentication.security.User.Dto.AuthenticationResponse;
import com.authentication.security.User.Dto.RegisterRequest;


import com.authentication.security.User.Repository.UserRepository;
import com.authentication.security.Config.JwtService;
import com.authentication.security.User.Role;
import com.authentication.security.User.Service.UserService;
import com.authentication.security.User.user;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {
//In summary, @Mock is used to create mock objects, while @InjectMocks is used to inject mock objects into a class under test.
    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private JwtService jwtService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private AuthenticationManager authenticationManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void register() {
        RegisterRequest request = new RegisterRequest("oussama", "rbiay", "oussama@gmail.com", "orbiay");
        user user = new user("oussama", "rbiay", "oussama@gmail.com", "encodedPassword", Role.USER);

        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(userRepository.save(any(user.class))).thenReturn(user);
        when(jwtService.generateToken(anyMap(), any(user.class))).thenReturn("jwtToken");

        AuthenticationResponse response = this.userService.register(request);

        assertNotNull(response);
        assertNotNull(response.getToken());
        assertEquals("jwtToken", response.getToken());
        verify(passwordEncoder, times(1)).encode("orbiay");
        verify(userRepository, times(1)).save(any(user.class));
        verify(jwtService, times(1)).generateToken(anyMap(), any(user.class));
    }
    @Test
    void authenticateTest()
    {
        AuthenticationRequest resquest = new AuthenticationRequest("oussama","password");
        user user = new user("oussama", "rbiay", "oussama@gmail.com", "encodedPassword", Role.USER);
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(user));
        when(jwtService.generateToken(anyMap(),any(user.class))).thenReturn("jwtToken");
        AuthenticationResponse response = this.userService.authenticate(resquest);
        assertNotNull(response);
        assertNotNull(response.getToken());
        assertEquals(response.getToken(),"jwtToken");
    }
}
