package com.group1.theBookSpot.contoller;


import com.group1.theBookSpot.service.DocumentService;
import com.group1.theBookSpot.constants.DocumentEnum;
import com.group1.theBookSpot.constants.NamespaceConstants;
import com.group1.theBookSpot.models.BooksDetailsListResponse;
import com.group1.theBookSpot.service.BookStoreService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@RestController
@Slf4j
@Api(value = "Book Store", produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping(value = NamespaceConstants.BOOKSTORE)
public class BookStoreController {

    @Autowired
    BookStoreService bookStoreService;

    @Autowired
    DocumentService documentService;



    @GetMapping(NamespaceConstants.LIST)
    public ResponseEntity<Object> fetchBooks()
            throws Exception {
        log.info("BookStoreController:: fetchBooks :: Init ");
        BooksDetailsListResponse response = bookStoreService.fetchBooksList();
        log.info("BookStore Controller:: fetchBooks :: Ends " + response);
        return ResponseEntity.ok(response);
    }

    @GetMapping(NamespaceConstants.FILE_TYPE)
    public void getFile(@RequestParam DocumentEnum type, HttpServletResponse response ) throws IOException {
        String headerValue = "";
        if(DocumentEnum.EXCEL.equals(type)){
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            headerValue = "attachment; filename= books" + UUID.randomUUID() + ".xlsx";
        }
        else{
            response.setContentType("application/pdf");
            headerValue = "attachment; filename= books" + UUID.randomUUID() + ".pdf";
        }
        String headerKey = "Content-Disposition";
        response.setHeader(headerKey, headerValue);
        documentService.download(type,response);
    }


}
