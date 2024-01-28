package com.project.freshman.company.controller;

import com.project.freshman.company.model.request.PatchUpdateReq;
import com.project.freshman.company.model.request.PostLoginReq;
import com.project.freshman.company.model.request.PostSignUpReq;
import com.project.freshman.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public ResponseEntity<Object> companySignUp(@RequestBody PostSignUpReq request) {
        return ResponseEntity.ok().body(companyService.signUp(request));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity<Object> companyLogin(@RequestBody PostLoginReq request) {
        return ResponseEntity.ok().body(companyService.login(request));
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity<Object> companyUpdate(@RequestBody PatchUpdateReq request) {
        return ResponseEntity.ok().body(companyService.update(request));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{idx}")
    public ResponseEntity<Object> companyDelete(@PathVariable Long idx) {
        return ResponseEntity.ok().body(companyService.delete(idx));
    }
}
