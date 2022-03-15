package com.group1.theBookSpot.service;

import com.group1.theBookSpot.constants.DocumentEnum;
import com.group1.theBookSpot.service.helper.ExcelGenerate;
import com.group1.theBookSpot.service.helper.PDFGenerate;
import org.springframework.stereotype.Component;

@Component
public class DocumentTypeFactory {
     DocumentType getDocument(DocumentEnum name) {
        switch (name) {
            case EXCEL:
                return new ExcelGenerate();
            case PDF:
                return new PDFGenerate();
        }
        throw new RuntimeException("No matching object could be created");
    }
}

