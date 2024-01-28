package com.project.freshman.applicant.model.response;

import com.project.freshman.applicant.model.request.PostUpdateReq;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SuccessUpdateRes {
    private Boolean isSuccess;
    private Integer code;
    private PatchUpdateRes result;
    private String message;
}
