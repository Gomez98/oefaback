package com.oefa.tdrcreation.config.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AgreementTemplate  {
    private String supplierName;

    Document document;
    FileOutputStream fileOutputStream;
    Paragraph paragraph;

    public AgreementTemplate(String supplierName) {
        this.supplierName = supplierName;
        document = new Document();
        paragraph = new Paragraph("FORMATO DE ESPECIFICACIONES TECNICAS PARA BIENES");
    }

    public void createTemplate(){
        try {
            fileOutputStream = new FileOutputStream(supplierName + ".pdf");
            PdfWriter.getInstance(document,fileOutputStream);
            document.open();
            paragraph.setAlignment(1);
            document.add(paragraph);
            document.add(new Paragraph("1. DENOMINACIÓN DE LA CONTRATACIÓN"));
            document.add(new Paragraph("Adquisicion de una (01) Unidad central de Procesamiento (CPU) para"));
            document.add(new Paragraph(supplierName));
            document.add(Chunk.NEWLINE);

            document.add(new Paragraph("2. FINALIDAD PÚBLICA"));
            Paragraph step2 = new Paragraph("Con la adquisicion de... ");
            document.add(step2);
            document.close();

        }catch (FileNotFoundException | DocumentException e){
            System.out.println(e);
        }
    }
}
