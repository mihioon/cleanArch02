package com.cleanArch.hh02.user.lect.controller;

import com.cleanArch.hh02.error.RegistException;
import com.cleanArch.hh02.user.lect.controller.controllerDTO.LectureExistRequest;
import com.cleanArch.hh02.user.lect.controller.controllerDTO.LectureListResponse;
import com.cleanArch.hh02.user.lect.controller.controllerDTO.LectureRegistRequest;
import com.cleanArch.hh02.common.dto.UserRequest;
import com.cleanArch.hh02.user.lect.service.LectureService;
import com.cleanArch.hh02.user.lect.service.serviceDTO.LectureDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/lectures")
public class LectureController {

    @Autowired
    LectureService lectureService;

    private UserRequest getSessionUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (UserRequest)session.getAttribute("usr");
    }

    //특강 신청 API
    // @ResponseBody > @RestController 내의 모든 메서드 기본적으로 포함
    @RequestMapping(value = "/regist.do")
    public Map<String, Object> regist(LectureRegistRequest param) throws RegistException {
        Map<String, Object> result = new HashMap<>();

        LectureDTO lectureDTO = LectureDTO.builder()
                                    .userId(param.getUserId())
                                    .lectureId(param.getLectureId())
                                    .build();
        lectureService.saveLectureRegist(lectureDTO);

        //result.put("", );
        return result;
    }

    //특강 신청 여부 조회 API
    @RequestMapping(value = "/searchUserRegist.do")
    public Map<String, Object> searchUserRegist(LectureExistRequest param){
        Map<String, Object> result = new HashMap<>();

        LectureDTO lectureDTO = LectureDTO.builder()
                                    .userId(param.getUserId())
                                    .lectureId(param.getLectureId())
                                    .build();
        LectureDTO registList = lectureService.isRegistSuccess(lectureDTO);

        result.put("registList", registList);
        return result;
    }
}
