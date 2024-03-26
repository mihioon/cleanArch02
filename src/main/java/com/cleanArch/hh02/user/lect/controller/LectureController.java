package com.cleanArch.hh02.user.lect.controller;

import com.cleanArch.hh02.user.lect.dto.LectureListRequest;
import com.cleanArch.hh02.user.lect.dto.LectureListResponse;
import com.cleanArch.hh02.user.lect.dto.LectureRegistRequest;
import com.cleanArch.hh02.common.dto.UserRequest;
import com.cleanArch.hh02.user.lect.service.LectureService;
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
    public Map<String,String> regist(LectureRegistRequest param, HttpServletRequest request){
        UserRequest usr = getSessionUser(request);
        if(usr != null){
            param.setUserId(usr.getUserId());
        }

        String msgCd = lectureService.lectureRegist(param);

        Map<String,String> result = new HashMap<>();
        result.put("msgCd", msgCd);
        return result;
    }

    //특강 신청 여부 조회 API
    @RequestMapping(value = "/searchRegistList.do")
    public List<LectureListResponse> searchRegistList(LectureListRequest param, HttpServletRequest request){
        UserRequest usr = getSessionUser(request);
        if(usr != null){
            param.setUserId(usr.getUserId());
        }
        List<LectureListResponse> registList = lectureService.registSuccessList(param);
        return registList;
    }
}
