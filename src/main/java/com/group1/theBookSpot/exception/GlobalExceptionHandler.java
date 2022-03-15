package com.group1.theBookSpot.exception;

import com.group1.theBookSpot.constants.MessageCodes;
import com.group1.theBookSpot.models.StatusMessage;
import org.apache.http.conn.ConnectTimeoutException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * This method used to throw server internal error at global level
     * @author Ankit Panwar
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseModel> generalException(Exception e) throws Exception{
        log.error(e.getMessage(), e);
        ExceptionResponseModel model = new ExceptionResponseModel();
        model.setStatus(MessageCodes.INTERNAL_SERVER_ERROR);
        model.setStatusMessage(new StatusMessage(MessageCodes.INTERNAL_SERVER_ERROR_MSG, "Internal Server Error. Please try again later."));
        return new ResponseEntity<ExceptionResponseModel>(model, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * This method used to send bad request response error at global level
     * @author Ankit Panwar
     * @param e
     * @return
     * @throws IOException
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponseModel> handleIllegalArgumentException(IllegalArgumentException e) throws IOException {
        log.error(e.getMessage());
        ExceptionResponseModel model = new ExceptionResponseModel();
        model.setStatus(MessageCodes.BAD_REQUEST);
        model.setStatusMessage(new StatusMessage(MessageCodes.BAD_REQUEST_MSG, e.getMessage()));
        return new ResponseEntity<ExceptionResponseModel>(model, HttpStatus.BAD_REQUEST);
    }


    /**
     * This method used to send gateway time out error. The time out is defined in application.properties file.
     * @author Ankit Panwar
     * @param ce
     * @return
     * @throws IOException
     */
    @ExceptionHandler({ConnectTimeoutException.class})
    public ResponseEntity<ExceptionResponseModel> invalidResponse(ConnectTimeoutException ce) throws IOException {
        log.error(ce.getMessage());
        ExceptionResponseModel model = new ExceptionResponseModel();
        model.setStatus(MessageCodes.GATEWAY_TIMEOUT);
        model.setStatusMessage(new StatusMessage(MessageCodes.GATEWAY_TIMEOUT_MSG, MessageCodes.GATEWAY_TIMEOUT_DESC));
        return new ResponseEntity<ExceptionResponseModel>(model, HttpStatus.GATEWAY_TIMEOUT);
    }


    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ModelApiExceptionResponse> handleApplicationException(ApplicationException e) throws IOException {
        log.error(e.getMessage());
        ModelApiExceptionResponse model = new ModelApiExceptionResponse();
        model.setStatus(MessageCodes.FAILED);
        model.setUserMessage(e.getMessage());
        return new ResponseEntity<ModelApiExceptionResponse>(model, e.getHttpStatus());
    }
    
}
