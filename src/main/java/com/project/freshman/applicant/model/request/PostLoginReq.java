package com.project.freshman.applicant.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostLoginReq {
    private String email;
    private String password;
}
