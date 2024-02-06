package com.project.freshman.mento.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class MentoCreateReq {
    private String mentoEmail;
    private String mentoPassword;
    private String mentoAddress;
    private String mentoCareer;


}
