package com.oefa.tdrcreation.repository;

import com.oefa.tdrcreation.model.Supplier;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SupplierRepository extends MongoRepository<Supplier,String> {

    Supplier findSupplierByEmail(String email);
}
