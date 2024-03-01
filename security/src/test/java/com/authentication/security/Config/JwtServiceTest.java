package com.authentication.security.Config;

import com.authentication.security.Config.JwtService;
import com.authentication.security.User.Role;
import com.authentication.security.User.user;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JwtServiceTest {

    private static final String SECRET_KEY = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEA0eZekL5vIkbUiB4DeCLhiqC1mG5uOfLU/IPno3SfuLQmsIMGcLYQVjSl7QKKufeMxMhtLwe7dIj6S9yoYlX89QIDAQABAkEArjLYTJwfM31BKW5vRqb8M8bIrycHB8TGioMWHQvO+sPXh4e0vusaIj3VJgIwr/U65G3riifsetENSm5qa7YHyQIhAOof9n64K9zlg6mek/GBm386zlcHGeJP/fvWlHfq5mhfAiEA5YL4B+4CW/foLgUQ/Mk2/1OBsCamwSdXSP8idL31qysCIH/RMV5fJ7syJh49L+Gic4UTUsEaZFw0daG+tVF+kYmbAiAg/Ei/gwKNyzxwWMQPQLAJ1CugcH2o5wmRcTG3i5GiTwIhAKJ9x+A+2Fw2ycyF/QO8PjKortNTlZY7jNJvfvQw0RF7";

    @InjectMocks
    private JwtService jwtService;

    @Mock
    private JwtService jwtserviceMock;

    @Mock
    private UserDetails userDetails;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void generateToken() {
        HashMap hm = new HashMap();
        hm.put("firstname","oussama");

        when(userDetails.getUsername()).thenReturn("oussama");
        when(userDetails.getPassword()).thenReturn("password");

        String token = jwtService.generateToken(hm, userDetails);

        assertNotNull(token);
        assertTrue(token.length() > 0);
        System.out.println(token);
        Map<String, Object> decodedClaims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        assertEquals("oussama", decodedClaims.get("sub"));
        assertEquals("oussama", decodedClaims.get("firstname"));
        assertNotNull(decodedClaims.get("iat"));
        assertNotNull(decodedClaims.get("exp"));
    }
    @Test
    void isTokenValid()
    {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJmaXJzdG5hbWUiOiJvdXNzYW1hIiwic3ViIjoib3Vzc2FtYSIsImlhdCI6MTcwOTI4ODM3NCwiZXhwIjoxNzA5MzQ4Mzc0fQ.6sp2xiirnxffIhJekhl73HYeF0d7-MVK7zrpggXy400";
        user user = new user("oussama", "rbiay", "oussama", "encodedPassword", Role.USER);

        when(jwtserviceMock.extractUsername(token)).thenReturn("oussama");
        when(userDetails.getUsername()).thenReturn("oussama");
        when(jwtserviceMock.isTokenExpired(token)).thenReturn(false);
        boolean bool =  this.jwtService.isTokenValid(token,user);
        assertTrue(bool == true);
    }
}
