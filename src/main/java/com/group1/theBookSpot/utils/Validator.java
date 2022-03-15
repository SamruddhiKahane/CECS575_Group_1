package com.group1.theBookSpot.utils;

import com.group1.theBookSpot.constants.MessageCodes;
import com.group1.theBookSpot.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public class Validator {
    public static void checkLimitAndOffset(Integer limit, Integer offset) {
        if (limit != null && limit < 1) {
            throw new ApplicationException(MessageCodes.INVALID_LIMIT,
                    HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if (offset != null && offset < 0) {
            throw new ApplicationException(MessageCodes.INVALID_OFFSET,
                    HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
