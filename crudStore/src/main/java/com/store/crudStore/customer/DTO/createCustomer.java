package com.store.crudStore.customer.DTO;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

@Validated
public class createCustomer {
    @NotBlank(message = "Field 'name' cannot be blank")
    private String name;

    @NotBlank(message = "Field 'email' cannot be blank")
    private String email;

    @NotBlank(message = "Field 'password' cannot be blank")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

