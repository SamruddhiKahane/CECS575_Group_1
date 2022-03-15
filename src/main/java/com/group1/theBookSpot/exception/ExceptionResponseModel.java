package com.group1.theBookSpot.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.group1.theBookSpot.models.StatusMessage;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponseModel {

    private String status;
    private StatusMessage statusMessage;

}
