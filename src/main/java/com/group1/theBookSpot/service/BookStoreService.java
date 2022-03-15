package com.group1.theBookSpot.service;


import com.group1.theBookSpot.constants.MessageCodes;
import com.group1.theBookSpot.entity.Items;
import com.group1.theBookSpot.models.BookDetailsDTO;
import com.group1.theBookSpot.models.BooksDetailsListResponse;
import com.group1.theBookSpot.models.PaginationData;
import com.group1.theBookSpot.repository.BookDetailsRepository;
import com.group1.theBookSpot.repository.BookDetailsRepositoryCustomImpl;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;

@Service
@Slf4j
@Transactional
public class BookStoreService {

    @Autowired
    private BookDetailsRepositoryCustomImpl repository;

    @Autowired
    private BookDetailsRepository detailsRepository;


    @Autowired
    private ModelMapper mapper;

    public BooksDetailsListResponse fetchBooksList() {
        log.info("BookStoreService :: fetchBooksList :: Init ");
        List<BookDetailsDTO> entityToDto = null;
        List<Items> list= (List<Items>) detailsRepository.findAll();
        if (!(list.size() > 0)) {
            return new BooksDetailsListResponse.Builder().
                    setStatus(HttpStatus.OK).
                    setUserMessage(MessageCodes.NO_RECORD_FOUND).
                    build();
        }
        Type listType = new TypeToken<List<BookDetailsDTO>>() {
        }.getType();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        entityToDto =mapper.map(list,listType);
        log.info("BookStoreService :: fetchBooksList :: ends ");
        return new BooksDetailsListResponse.Builder().setStatus(HttpStatus.OK).
                setUserMessage(MessageCodes.BOOK_DATA_FETCHED_SUCCESS).
                setBooksDetails(entityToDto).
                build();
    }
}
