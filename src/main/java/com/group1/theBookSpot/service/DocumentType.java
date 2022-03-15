package com.group1.theBookSpot.service;

import com.group1.theBookSpot.models.BookDetailsDTO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface DocumentType {
        void produceDocument(List<BookDetailsDTO> list, HttpServletResponse response) throws IOException;
}
