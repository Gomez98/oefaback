package com.oefa.tdrcreation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseModel{
    @Email
    @NotEmpty(message = "Email cannot be empty")
    private String email;
    private String name;
    private String password;
}
