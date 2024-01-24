package com.project.freshman.applicant.service;

import com.project.freshman.applicant.model.entity.Applicant;
import com.project.freshman.applicant.model.request.PostLoginReq;
import com.project.freshman.applicant.model.request.PostSignUpReq;
import com.project.freshman.applicant.model.request.PostUpdateReq;
import com.project.freshman.applicant.repository.ApplicantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplicantService {
    private final ApplicantRepository applicantRepository;

    public void signUp(PostSignUpReq request) {

        Optional<Applicant> applicant = applicantRepository.findByApplicantEmail(request.getEmail());

        if (applicant.isPresent()) {
            return;
        } else {
            applicantRepository.save(Applicant.builder()
                    .applicantEmail(request.getEmail())
                    .applicantPw(request.getPassword())
                    .applicantTel(request.getTel())
                    .applicantAddress(request.getAddress())
                    .authority(false)
                    .status(false)
                    .createdAt(LocalDate.now())
                    .build());
        }
    }

    public void login(PostLoginReq request) {
        Optional<Applicant> applicant = applicantRepository.findByApplicantEmail(request.getEmail());
        
        if (applicant.isPresent()) {
            if (applicant.get().getApplicantPw().equals(request.getPassword())) {
                // 성공 응답 코드
                
            } else {
                // 실패 응답 코드
                return;
            }
            // 회원이 없을 경우 응답 코드
        }
        
    }

    public void update(PostUpdateReq request) {
        Optional<Applicant> applicant = applicantRepository.findByApplicantEmail(request.getEmail());
        
        if (applicant.isPresent()) {
            if (applicant.get().getApplicantPw().equals(request.getPassword())) {
                applicant.get().setApplicantPw(request.getNewPassword());
                applicant.get().setUpdatedAt(LocalDate.now());
                // 성공 응답 코드
            } else {
                // 실패 응답 코드
            }
        } else {
            // 회원이 없을 경우 응답 코드
        }
    }

    public void delete(Long idx) {
        Optional<Applicant> applicant = applicantRepository.findById(idx);

        if (applicant.isPresent()) {
            // 성공 응답 코드
            applicantRepository.deleteById(applicant.get().getIdx());
        } else {
            // 실패 응답 코드
        }
    }
}
