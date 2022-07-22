package com.oefa.tdrcreation.service.impl;

import com.oefa.tdrcreation.model.Agreement;
import com.oefa.tdrcreation.repository.AgreementRepository;
import com.oefa.tdrcreation.service.AgreementService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class AgreementServiceImpl implements AgreementService {

    private final AgreementRepository agreementRepository;

    @Override
    public List<Agreement> listAllAgreements() {
        return agreementRepository.findAll();
    }

    @Override
    public Agreement findById(String id) {
        return agreementRepository.findById(id).orElse(null);
    }

    @Override
    public Agreement create(Agreement agreement) {
        return agreementRepository.save(agreement);
    }
}

