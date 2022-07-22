package com.oefa.tdrcreation.service;

import com.oefa.tdrcreation.model.Agreement;

import java.util.List;

public interface AgreementService {

    List<Agreement> listAllAgreements();
    Agreement findById(String id);
    Agreement create(Agreement agreement);
}
