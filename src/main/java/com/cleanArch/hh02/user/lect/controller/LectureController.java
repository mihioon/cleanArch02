package com.cleanArch.hh02.user.lect.controller;

import com.cleanArch.hh02.user.lect.dto.LectureListDto;
import com.cleanArch.hh02.user.lect.dto.LectureRegistDto;
import com.cleanArch.hh02.user.lect.model.Lecture;
import com.cleanArch.hh02.user.lect.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lectures")
public class LectureController {

    @Autowired
    LectureService lectureService;

    //특강 신청 API
    public void lectureRegist(LectureRegistDto param){
        lectureService.lectureRegist(param);
    }

    //특강 신청 여부 조회 API
    public List<LectureListDto> registSuccessList(){
        List<LectureListDto> result = lectureService.registSuccessList();
        return result;
    }
}
