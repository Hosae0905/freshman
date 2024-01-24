package com.project.freshman.applicant.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PostSignUpReq {
    private String email;
    private String password;
    private String tel;
    private String address;
}
