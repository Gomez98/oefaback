package com.oefa.tdrcreation.service.impl;

import com.oefa.tdrcreation.model.Supplier;
import com.oefa.tdrcreation.repository.SupplierRepository;
import com.oefa.tdrcreation.service.SupplierService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;


    @Override
    public Supplier getSupplierByEmail(String email) {
        return supplierRepository.findSupplierByEmail(email);
    }

    @Override
    public Supplier save(Supplier supplier) {
        log.info("Save Employee");
        return supplierRepository.save(supplier);
    }
}
