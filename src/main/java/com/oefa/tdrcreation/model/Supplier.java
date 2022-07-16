package com.oefa.tdrcreation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier extends User{
    private String ruc;
    private String dni;
    private String phone;
    private String businessName;
}
