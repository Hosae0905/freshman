package com.project.freshman.applicant.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostUpdateReq {
    private String email;
    private String password;
    private String newPassword;
}
