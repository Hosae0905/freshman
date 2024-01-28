package com.project.freshman.company.service;

import com.project.freshman.company.model.entity.Company;
import com.project.freshman.company.model.request.PatchUpdateReq;
import com.project.freshman.company.model.request.PostLoginReq;
import com.project.freshman.company.model.request.PostSignUpReq;
import com.project.freshman.company.model.response.*;
import com.project.freshman.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public SuccessSignUpRes signUp(PostSignUpReq request) {

        Optional<Company> company = companyRepository.findByCompanyEmail(request.getEmail());

        if (company.isPresent()) {
            // 실패 응답(중복된 아이디)
            return null;
        } else {

            Company companyInfo = companyRepository.save(Company.builder()
                    .companyEmail(request.getEmail())
                    .companyPw(request.getPassword())
                    .companyTel(request.getTel())
                    .companyAddress(request.getAddress())
                    .companyDepartment(request.getDepartment())
                    .authority("COMPANY")
                    .createdAt(LocalDate.now())
                    .build());
            // 성공 응답

            PostSignUpRes result = PostSignUpRes.builder()
                    .email(companyInfo.getCompanyEmail())
                    .authority(companyInfo.getAuthority())
                    .build();

            return SuccessSignUpRes.builder()
                    .isSuccess(true)
                    .code(1000)
                    .result(result)
                    .message("회원가입 성공")
                    .build();
        }
    }

    public SuccessLoginRes login(PostLoginReq request) {
        Optional<Company> company = companyRepository.findByCompanyEmail(request.getEmail());

        if (company.isPresent()) {
            if (company.get().getCompanyPw().equals(request.getPassword())) {
                // 성공 응답

                PostLoginRes result = PostLoginRes.builder()
                        .email(company.get().getCompanyEmail())
                        .authority(company.get().getAuthority())
                        .build();

                return SuccessLoginRes.builder()
                        .isSuccess(true)
                        .code(1000)
                        .result(result)
                        .message("로그인 성공")
                        .build();
            } else {
                // 실패 응답(비밀번호 틀림)
                return null;
            }
        } else {
            // 실패 응답(회원이 존재하지 않음)
            return null;
        }
    }

    public SuccessUpdateRes update(PatchUpdateReq request) {
        Optional<Company> company = companyRepository.findByCompanyEmail(request.getEmail());

        if (company.isPresent()) {
            if (company.get().getCompanyPw().equals(request.getPassword())) {
                company.get().setCompanyPw(request.getNewPassword());
                company.get().setUpdatedAt(LocalDate.now());
                companyRepository.save(company.get());
                // 성공 응답

                PatchUpdateRes result = PatchUpdateRes.builder()
                        .email(company.get().getCompanyEmail())
                        .build();
                
                return SuccessUpdateRes.builder()
                        .isSuccess(true)
                        .code(1000)
                        .result(result)
                        .message("회원 정보 수정 성공")
                        .build();


            } else {
                // 실패 응답(비밀번호 틀림)
                return null;
            }
        } else {
            // 실패 응답(회원이 존재하지 않음)
            return null;
        }
    }

    public SuccessDeleteRes delete(Long idx) {
        Optional<Company> company = companyRepository.findById(idx);

        if (company.isPresent()) {
            companyRepository.deleteById(idx);
            // 성공 응답

            DeleteCompanyRes result = DeleteCompanyRes.builder().idx(idx).build();

            return SuccessDeleteRes.builder()
                    .isSuccess(true)
                    .code(1000)
                    .result(result)
                    .message("회원탈퇴 성공")
                    .build();

        } else {
            // 실패 응답(회원이 존재하지 않음)
            return null;
        }
    }
}
