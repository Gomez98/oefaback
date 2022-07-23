package com.oefa.tdrcreation.service.impl;

import com.oefa.tdrcreation.model.Agreement;
import com.oefa.tdrcreation.model.Supplier;
import com.oefa.tdrcreation.repository.AgreementRepository;
import com.oefa.tdrcreation.repository.SupplierRepository;
import com.oefa.tdrcreation.service.AgreementService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;
@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class AgreementServiceImpl implements AgreementService {

    private final AgreementRepository agreementRepository;
    private final SupplierRepository supplierRepository;

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

        Supplier sup = supplierRepository.findById(agreement.getSupplierId()).orElse(null);
        String emailID = sup.getEmail();
        System.out.println("emailID = " + emailID);
        final String username = "m.gomezangeles@gmail.com";
        final String password = "qjbiglaypcbsefkc";
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(emailID)
            );
            message.setSubject("Alerta de Registro");
            message.setText("Estimado proveedor,"
                    + "\n\n su proforma fue correctamente registrada"
                    + "\n\n Saludos coordiales");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return agreementRepository.save(agreement);
    }
}

