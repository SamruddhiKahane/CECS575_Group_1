package com.group1.theBookSpot.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.awt.print.Book;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BooksDetailsListResponse {
    private HttpStatus status;
    private String userMessage;
    private List<BookDetailsDTO> booksDetails;
    public static class Builder {
        private HttpStatus status;
        private String userMessage;
        private List<BookDetailsDTO> booksDetails;

        public Builder setStatus(HttpStatus status) {
            this.status = status;
            return this;
        }

        public Builder setUserMessage(String userMessage) {
            this.userMessage = userMessage;
            return this;
        }

        public Builder setBooksDetails(List<BookDetailsDTO> booksDetails) {
            this.booksDetails = booksDetails;
            return this;
        }

        public BooksDetailsListResponse build(){
            return new BooksDetailsListResponse(status,userMessage,booksDetails);
        }
    }
}