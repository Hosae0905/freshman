package com.project.freshman.mypage.controller;

import com.project.freshman.mypage.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {
    private final MyPageService myPageService;

    @RequestMapping(method = RequestMethod.GET, value = "/applicant/read")
    public void getApplicantMyPage() {
        myPageService.getApplicantMyPage();
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/applicant/update")
    public void updateApplicantMyPage() {
        myPageService.updateApplicantMyPage();
    }
}
