package com.project.freshman.company.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PatchUpdateRes {
    private String email;
}
