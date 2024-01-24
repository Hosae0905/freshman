package com.project.freshman.company.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String companyEmail;
    private String companyPw;
    private String companyAddress;
    private String companyDepartment;
    private String companyTel;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
