package com.project.freshman.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BaseResponse<T> {
    private Boolean isSuccess;
    private String message;
    private Integer code;
    private T result;

    public void SuccessResponse(T result, String message, Integer code) {
        this.isSuccess = true;
        this.message = message;
        this.code = code;
        this.result = result;
    }

    public void FailResponse(String message, Integer code) {
        this.isSuccess = false;
        this.message = message;
        this.code = code;
    }
}
