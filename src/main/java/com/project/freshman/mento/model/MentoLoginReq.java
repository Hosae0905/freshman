package com.project.freshman.mento.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MentoLoginReq {
    private String mentoEmail;
    private String mentoPassword;
}
