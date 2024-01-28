package com.project.freshman.company.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class PostLoginRes {
    private String email;
    private String authority;
}
