package com.oefa.tdrcreation.service;

import com.oefa.tdrcreation.model.Supplier;

import java.util.List;

public interface SupplierService {
    Supplier getSupplierByEmail(String email);

    Supplier save(Supplier supplier);

    List<Supplier> getAllSuppliers();
}
