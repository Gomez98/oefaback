package com.oefa.tdrcreation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Agreement extends BaseModel{

    private String supplierId;
    private String categoryId;
    private String productId;
    private String features;
    private String price;
    private Integer warranty;
    private Integer shippingTime;
}
