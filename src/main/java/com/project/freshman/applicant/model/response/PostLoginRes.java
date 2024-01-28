package com.project.freshman.applicant.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PostLoginRes {
    private String email;
    private String authority;
}
