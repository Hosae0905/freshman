package com.project.freshman.company.controller;

import com.project.freshman.company.model.PatchUpdateReq;
import com.project.freshman.company.model.PostLoginReq;
import com.project.freshman.company.model.PostSignUpReq;
import com.project.freshman.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public void companySignUp(@RequestBody PostSignUpReq request) {
        companyService.signUp(request);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public void companyLogin(@RequestBody PostLoginReq request) {
        companyService.login(request);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public void companyUpdate(@RequestBody PatchUpdateReq request) {
        companyService.update(request);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{idx}")
    public void companyDelete(@PathVariable Long idx) {
        companyService.delete(idx);
    }
}
