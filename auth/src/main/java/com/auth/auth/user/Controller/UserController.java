package com.auth.auth.user.Controller;

import com.auth.auth.user.DTO.CreationDto;
import com.auth.auth.user.DTO.loginDto;
import com.auth.auth.user.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/public/user/")
public class UserController {
    @Autowired
    private CustomerService service;

    public UserController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public String Hello()
    {
        return "Hello";
    }


    @PostMapping("registry")
    public ResponseEntity<?> registre(@RequestBody CreationDto body)
    {
        try {
            return ResponseEntity.ok(this.service.createUser(body));
        }catch (Exception err)
        {
            return ResponseEntity.badRequest().body(err.getMessage());
        }
    }
    @PostMapping("signup")
    public RedirectView signup(@RequestParam("name") String name,
                               @RequestParam("email") String email,
                               @RequestParam("password") String password)
    {
        try {
            final CreationDto customer = new CreationDto(name,email,password);
            System.out.println(customer.getEmail());
            this.service.createUser(customer);
            return new  RedirectView("/login",true);
        }catch (Exception err)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, err.getMessage());
        }
    }
//    @PostMapping("login")
//    public RedirectView login(@RequestBody loginDto body)
//    {
//        System.out.println(body.getName());
//        return new  RedirectView("/",true);
//    }
}
