package com.project.freshman.company.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatchUpdateReq {
    private String email;
    private String password;
    private String newPassword;
}
