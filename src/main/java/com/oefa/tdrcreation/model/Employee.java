package com.oefa.tdrcreation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends BaseModel {

    private String firstName;
    @Email
    @NotEmpty(message = "Email cannot be empty")
    private String email;
    private String lastName;
    @NotEmpty(message = "Profile id cannot be empty")
    private String profileId;
    private String password;
}
