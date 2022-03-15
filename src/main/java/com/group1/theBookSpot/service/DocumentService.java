package com.group1.theBookSpot.service;

import com.group1.theBookSpot.constants.DocumentEnum;
import com.group1.theBookSpot.entity.Items;
import com.group1.theBookSpot.models.BookDetailsDTO;
import com.group1.theBookSpot.repository.BookDetailsRepository;
import com.group1.theBookSpot.service.helper.ExcelGenerate;
import com.group1.theBookSpot.service.helper.PDFGenerate;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@Service
public class DocumentService {
    @Autowired
    BookDetailsRepository repository;

    @Autowired
    private ModelMapper mapper;

    public void download(DocumentEnum type, HttpServletResponse response) throws IOException {
        DocumentTypeFactory typeFactory = new DocumentTypeFactory();
        List<BookDetailsDTO> entityToDto = null;
        List<Items> items = (List<Items>) repository.findAll();
        Type listType = new TypeToken<List<BookDetailsDTO>>() {
        }.getType();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        entityToDto =mapper.map(items,listType);
        if (DocumentEnum.EXCEL.equals(type)) {
            ExcelGenerate generate = (ExcelGenerate) typeFactory.getDocument(DocumentEnum.EXCEL);
            generate.produceDocument(entityToDto,response);
        } else if(DocumentEnum.PDF.equals(type)){
            PDFGenerate generate2 = (PDFGenerate) typeFactory.getDocument(DocumentEnum.PDF);
            generate2.produceDocument(entityToDto,response);
        }
    }

}
