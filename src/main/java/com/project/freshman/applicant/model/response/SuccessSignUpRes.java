package com.project.freshman.applicant.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SuccessSignUpRes {
    private Boolean isSuccess;
    private Integer code;
    private PostSignUpRes result;
    private String message;
}
