package com.project.freshman.mento.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String mentoEmail;
    private String mentoPassword;
    private String mentoAddress;
    private String mentoCareer;
    private Boolean authority;
    private Boolean Status;
    private LocalDate mentoCreatedAt;
    private LocalDate mentoDeletedAt;
    private LocalDate mentoUpdatedAt;
}
