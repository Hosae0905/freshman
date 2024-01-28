package com.project.freshman.company.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostSignUpReq {
    private String email;
    private String password;
    private String address;
    private String department;
    private String tel;
}
