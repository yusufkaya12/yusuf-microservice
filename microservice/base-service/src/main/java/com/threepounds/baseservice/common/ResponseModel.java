package com.threepounds.baseservice.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseModel<T> {
    private int statusCode;

    private T body;

    private String errorMessage;

}
