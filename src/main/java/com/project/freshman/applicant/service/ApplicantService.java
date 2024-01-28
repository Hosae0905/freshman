package com.project.freshman.applicant.service;

import com.project.freshman.applicant.model.entity.Applicant;
import com.project.freshman.applicant.model.request.PostLoginReq;
import com.project.freshman.applicant.model.request.PostSignUpReq;
import com.project.freshman.applicant.model.request.PostUpdateReq;
import com.project.freshman.applicant.model.response.*;
import com.project.freshman.applicant.repository.ApplicantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplicantService {
    private final ApplicantRepository applicantRepository;

    public SuccessSignUpRes signUp(PostSignUpReq request) {

        Optional<Applicant> applicant = applicantRepository.findByApplicantEmail(request.getEmail());

        if (applicant.isPresent()) {
            return null;
        } else {
            Applicant applicantInfo = applicantRepository.save(Applicant.builder()
                    .applicantEmail(request.getEmail())
                    .applicantPw(request.getPassword())
                    .applicantTel(request.getTel())
                    .applicantAddress(request.getAddress())
                    .authority("APPLICANT")
                    .status(false)
                    .createdAt(LocalDate.now())
                    .build());

            PostSignUpRes result = PostSignUpRes.builder()
                    .email(applicantInfo.getApplicantEmail())
                    .authority(applicantInfo.getAuthority())
                    .build();

            return SuccessSignUpRes.builder()
                    .isSuccess(true)
                    .result(result)
                    .message("회원가입 성공")
                    .code(1000)
                    .build();
        }
    }

    public SuccessLoginRes login(PostLoginReq request) {
        Optional<Applicant> applicant = applicantRepository.findByApplicantEmail(request.getEmail());
        
        if (applicant.isPresent()) {
            if (applicant.get().getApplicantPw().equals(request.getPassword())) {
                // 성공 응답 코드
                PostLoginRes result = PostLoginRes.builder()
                        .email(applicant.get().getApplicantEmail())
                        .authority(applicant.get().getAuthority())
                        .build();

                return SuccessLoginRes.builder()
                        .isSuccess(true)
                        .code(1000)
                        .result(result)
                        .message("로그인 성공")
                        .build();
            } else {
                // 실패 응답 코드
                return null;
            }
            // 회원이 없을 경우 응답 코드
        }
        return null;
    }

    public SuccessUpdateRes update(PostUpdateReq request) {
        Optional<Applicant> applicant = applicantRepository.findByApplicantEmail(request.getEmail());
        
        if (applicant.isPresent()) {
            if (applicant.get().getApplicantPw().equals(request.getPassword())) {
                applicant.get().setApplicantPw(request.getNewPassword());
                applicant.get().setUpdatedAt(LocalDate.now());
                applicantRepository.save(applicant.get());
                // 성공 응답 코드

                PatchUpdateRes result = PatchUpdateRes.builder().email(applicant.get().getApplicantEmail()).build();

                return SuccessUpdateRes.builder()
                        .isSuccess(true)
                        .code(1000)
                        .result(result)
                        .message("회원정보 수정 성공")
                        .build();
                
            } else {
                // 실패 응답 코드
                return null;
            }
        } else {
            // 회원이 없을 경우 응답 코드
            return null;
        }
    }

    public SuccessDeleteRes delete(Long idx) {
        Optional<Applicant> applicant = applicantRepository.findById(idx);

        if (applicant.isPresent()) {
            // 성공 응답 코드
            applicantRepository.deleteById(applicant.get().getIdx());

            DeleteUserRes userIdx = DeleteUserRes.builder().idx(idx).build();

            return SuccessDeleteRes.builder()
                    .isSuccess(true)
                    .code(1000)
                    .result(userIdx)
                    .message("회원삭제 성공")
                    .build();


        } else {
            // 실패 응답 코드
            return null;
        }
    }
}
