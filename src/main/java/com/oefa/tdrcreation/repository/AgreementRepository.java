package com.oefa.tdrcreation.repository;

import com.oefa.tdrcreation.model.Agreement;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AgreementRepository extends MongoRepository<Agreement, String> {
}
