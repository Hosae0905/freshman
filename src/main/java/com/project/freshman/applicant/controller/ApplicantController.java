package com.project.freshman.applicant.controller;

import com.project.freshman.applicant.model.request.PostLoginReq;
import com.project.freshman.applicant.model.request.PostSignUpReq;
import com.project.freshman.applicant.model.request.PostUpdateReq;
import com.project.freshman.applicant.service.ApplicantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/applicant")
public class ApplicantController {

    private final ApplicantService applicantService;

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public void applicantSignUp(@RequestBody PostSignUpReq request) {
        applicantService.signUp(request);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public void applicantLogin(@RequestBody PostLoginReq request) {
        applicantService.login(request);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public void applicantUpdate(@RequestBody PostUpdateReq request) {
        applicantService.update(request);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{idx}")
    public void applicantDelete(@PathVariable Long idx) {
        applicantService.delete(idx);
    }
}
