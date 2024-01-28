package com.project.freshman.company.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SuccessLoginRes {
    private Boolean isSuccess;
    private Integer code;
    private PostLoginRes result;
    private String message;
}
