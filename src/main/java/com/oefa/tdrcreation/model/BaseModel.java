package com.oefa.tdrcreation.model;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
public class BaseModel {
    @Id
    private String id;
    private Long created = System.currentTimeMillis();
    private Long modified = System.currentTimeMillis();
    private Boolean active = Boolean.TRUE;
}
