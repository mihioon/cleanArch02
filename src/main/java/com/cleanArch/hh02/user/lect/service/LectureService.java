package com.cleanArch.hh02.user.lect.service;

import com.cleanArch.hh02.user.lect.dto.LectureListRequest;
import com.cleanArch.hh02.user.lect.dto.LectureListResponse;
import com.cleanArch.hh02.user.lect.dto.LectureRegistRequest;

import java.util.List;

public interface LectureService {
    public String lectureRegist(LectureRegistRequest param);
    public List<LectureListResponse> registSuccessList(LectureListRequest param);
}
