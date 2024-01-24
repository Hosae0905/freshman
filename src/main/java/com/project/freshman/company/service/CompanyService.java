package com.project.freshman.company.service;

import com.project.freshman.company.model.Company;
import com.project.freshman.company.model.PatchUpdateReq;
import com.project.freshman.company.model.PostLoginReq;
import com.project.freshman.company.model.PostSignUpReq;
import com.project.freshman.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public void signUp(PostSignUpReq request) {

        Optional<Company> company = companyRepository.findByCompanyEmail(request.getEmail());

        if (company.isPresent()) {
            // 실패 응답(중복된 아이디)
        } else {

            companyRepository.save(Company.builder()
                    .companyEmail(request.getEmail())
                    .companyPw(request.getPassword())
                    .companyTel(request.getTel())
                    .companyAddress(request.getAddress())
                    .companyDepartment(request.getDepartment())
                    .createdAt(LocalDate.now())
                    .build());
            // 성공 응답
        }
    }

    public void login(PostLoginReq request) {
        Optional<Company> company = companyRepository.findByCompanyEmail(request.getEmail());

        if (company.isPresent()) {
            if (company.get().getCompanyPw().equals(request.getPassword())) {
                // 성공 응답
            } else {
                // 실패 응답(비밀번호 틀림)
            }
        } else {
            // 실패 응답(회원이 존재하지 않음)
        }
    }

    public void update(PatchUpdateReq request) {
        Optional<Company> company = companyRepository.findByCompanyEmail(request.getEmail());

        if (company.isPresent()) {
            if (company.get().getCompanyPw().equals(request.getPassword())) {
                company.get().setCompanyPw(request.getNewPassword());
                company.get().setUpdatedAt(LocalDate.now());

                // 성공 응답
            } else {
                // 실패 응답(비밀번호 틀림)
            }
        } else {
            // 실패 응답(회원이 존재하지 않음)
        }
    }

    public void delete(Long idx) {
        Optional<Company> company = companyRepository.findById(idx);

        if (company.isPresent()) {
            companyRepository.deleteById(idx);
            // 성공 응답
        } else {
            // 실패 응답(회원이 존재하지 않음)
        }
    }
}
