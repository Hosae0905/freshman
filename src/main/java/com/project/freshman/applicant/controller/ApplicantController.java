package com.project.freshman.applicant.controller;

import com.project.freshman.applicant.model.request.PostLoginReq;
import com.project.freshman.applicant.model.request.PostSignUpReq;
import com.project.freshman.applicant.model.request.PostUpdateReq;
import com.project.freshman.applicant.service.ApplicantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/applicant")
public class ApplicantController {

    private final ApplicantService applicantService;

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public ResponseEntity<Object> applicantSignUp(@RequestBody PostSignUpReq request) {
        return ResponseEntity.ok().body(applicantService.signUp(request));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity<Object> applicantLogin(@RequestBody PostLoginReq request) {
        return ResponseEntity.ok().body(applicantService.login(request));
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity<Object> applicantUpdate(@RequestBody PostUpdateReq request) {
        return ResponseEntity.ok().body(applicantService.update(request));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{idx}")
    public ResponseEntity<Object> applicantDelete(@PathVariable Long idx) {
        return ResponseEntity.ok().body(applicantService.delete(idx));
    }
}
