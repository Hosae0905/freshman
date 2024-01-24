package com.project.freshman.applicant.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String applicantEmail;
    private String applicantPw;
    private String applicantTel;
    private String applicantAddress;
    private Boolean authority;
    private Boolean status;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
