package com.project.freshman.mento.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MentoUpdateReq {
    private String mentoEmail;
    private String mentoPassword;
    private String mentoAddress;
    private String mentoCareer;

}
