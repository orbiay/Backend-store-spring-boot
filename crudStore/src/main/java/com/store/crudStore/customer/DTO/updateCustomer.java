package com.store.crudStore.customer.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public class updateCustomer {

    @NotBlank(message = "Field 'id' cannot be blank")
    private  long id;
    @JsonProperty(required = false)
    private String name;

    @JsonProperty(required = false)
    private String email;

    @JsonProperty(required = false)
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
    public long getId() {
        return id;
    }

}
