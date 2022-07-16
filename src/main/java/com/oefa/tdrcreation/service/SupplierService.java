package com.oefa.tdrcreation.service;

import com.oefa.tdrcreation.model.Supplier;

public interface SupplierService {
    Supplier getSupplierByEmail(String email);
    Supplier save(Supplier supplier);
}
