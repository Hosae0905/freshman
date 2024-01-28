package com.project.freshman.company.model.response;

import com.project.freshman.applicant.model.response.PostLoginRes;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SuccessDeleteRes {
    private Boolean isSuccess;
    private Integer code;
    private DeleteCompanyRes result;
    private String message;
}

