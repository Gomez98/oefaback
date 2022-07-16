package com.oefa.tdrcreation.controller;

import com.oefa.tdrcreation.model.Response;
import com.oefa.tdrcreation.model.Supplier;
import com.oefa.tdrcreation.service.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/v1/supplier")
@AllArgsConstructor
public class SupplierControler {

    private final SupplierService supplierService;

    @PostMapping("/login")
    public ResponseEntity<Response> getSupplierByEmail(@RequestBody String email){
        Supplier sup = supplierService.getSupplierByEmail(email);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("supplier", sup))
                        .message( sup == null ? "Supplier not found" : "Supplier retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveSupplier(@RequestBody Supplier supplier){
        Supplier sup = supplierService.save(supplier);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("supplier", sup))
                        .message( sup == null ? "Supplier not found" : "Supplier updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
