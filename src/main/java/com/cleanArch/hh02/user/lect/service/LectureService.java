package com.cleanArch.hh02.user.lect.service;

import com.cleanArch.hh02.error.ParseException;
import com.cleanArch.hh02.user.lect.entity.Lecture;
import com.cleanArch.hh02.user.lect.service.serviceDTO.LectureDTO;

public interface LectureService {
    public Lecture selectLectureByLectureId(LectureDTO param) throws ParseException;
    public void saveLectureRegist(LectureDTO param) throws ParseException;
    public LectureDTO isRegistSuccess(LectureDTO param);
    public Long selectRegistCnt(LectureDTO param) throws ParseException;
}
