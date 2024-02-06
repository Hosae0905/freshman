package com.project.freshman.mento.controller;

import com.project.freshman.mento.model.MentoCreateReq;
import com.project.freshman.mento.model.MentoLoginReq;
import com.project.freshman.mento.model.MentoUpdateReq;
import com.project.freshman.mento.service.MentoService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mento")
public class MentoController {
    private final MentoService mentoService;

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public ResponseEntity create(@RequestBody MentoCreateReq mentoCreateReq){
        return ResponseEntity.ok().body(mentoService.signup(mentoCreateReq));
    }
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity list(@RequestBody MentoLoginReq mentoLoginReq){
        return ResponseEntity.ok().body(mentoService.login(mentoLoginReq));
    }
    @RequestMapping(method = RequestMethod.GET, value = "/read")
    public ResponseEntity read(){
        return ResponseEntity.ok().body("");
    }
    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity update(@RequestBody MentoUpdateReq mentoUpdateReq){
        return ResponseEntity.ok().body(mentoService.update(mentoUpdateReq));
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{idx}")
    public ResponseEntity delete(@PathVariable Long idx){
        return ResponseEntity.ok().body(mentoService.delete(idx));
    }

}
