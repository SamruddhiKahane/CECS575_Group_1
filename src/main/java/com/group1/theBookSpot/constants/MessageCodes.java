package com.group1.theBookSpot.constants;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MessageCodes {


    public static final String SUCCESS = "200";
    public static final String SUCCESS_MSG = "SUCCESS";
    public static final String CAPTURED_MSG = "CAPTURE";
    public static final String INPROGRESS_MSG = "INPROGRESS";
    public static final String NOT_FOUND = "404";
    public static final String UNPROCESSABLE_ENTITY = "422";
    public static final String UNPROCESSABLE_ENTITY_MSG = "UNPROCESSABLE_ENTITY";
    public static final String INVALID_FETCH_RESPONSE = "Unable to fetch response";

    public static final String ERROR = "ERROR";
    public static final String NO_RECORD_FOUND = "No Record Found";
    public static final String BOOK_DATA_FETCHED_SUCCESS = "Book Data fetched successfully.";

    public static final Integer DEFAULT_LIMIT = 10;
    public static final Integer DEFAULT_OFFSET = 0;


    // common error messages
    public static final String INVALID_LIMIT = "limit must be positive number";
    public static final String INVALID_OFFSET = "offset must be positive number or zero";


    public static final String INTERNAL_SERVER_ERROR = "500";
    public static final String INTERNAL_SERVER_ERROR_MSG = "Internal Server Error";
    public static final String INTERNAL_SERVER_ERROR_DESC = "Internal Server Error. Please try again later.";

    public static final String INVALID_RESPONSE = "502";
    public static final String INVALID_RESPONSE_MSG = "INVALID_RESPONSE";
    public static final String INVALID_RESPONSE_DESC = "Internal Response. Please try again later";

    public static final String BAD_REQUEST = "400";
    public static final String BAD_REQUEST_MSG = "BAD_REQUEST";
    public static final String BAD_REQUEST_DESC = "Invalid Request. Please provide valid request.";

    public static final String GATEWAY_TIMEOUT = "504";
    public static final String GATEWAY_TIMEOUT_MSG = "GATEWAY_TIMEOUT";
    public static final String GATEWAY_TIMEOUT_DESC = "Gateway Time Out. Please try again later.";
    public static final String FAILED = "FAILED";
}
