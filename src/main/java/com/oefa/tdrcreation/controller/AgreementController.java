package com.oefa.tdrcreation.controller;

import com.oefa.tdrcreation.config.pdf.AgreementTemplate;
import com.oefa.tdrcreation.model.Agreement;
import com.oefa.tdrcreation.model.Response;
import com.oefa.tdrcreation.service.AgreementService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/v1/agreement")
@AllArgsConstructor
public class AgreementController {

    private final AgreementService agreementService;

    @GetMapping("/list")
    public ResponseEntity<Response> getAllAgreements(){
        List<Agreement> list = agreementService.listAllAgreements();
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("agreements", list == null ? "": list))
                        .message( list.isEmpty() ? "No agreement registered" : "Agreement retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getAgreementById(@PathVariable("id") String id){
        Agreement agre = agreementService.findById(id);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("agreement", agre == null ? "" : agre))
                        .message(agre == null ? "Agreement not found" : "Agreement retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveAgreement(@RequestBody @Valid Agreement agreement){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("agreement", agreementService.create(agreement)))
                        .message("Agreement created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @PostMapping("/generate")
    public ResponseEntity<Response> generateAgreement(@RequestBody String supName){
        AgreementTemplate template = new AgreementTemplate(supName);
        template.createTemplate();
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("agreement", ""))
                        .message("Agreement created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }
}
