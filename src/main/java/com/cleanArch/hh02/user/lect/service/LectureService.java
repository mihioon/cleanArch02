package com.cleanArch.hh02.user.lect.service;

import com.cleanArch.hh02.error.ParseException;
import com.cleanArch.hh02.error.RegistException;
import com.cleanArch.hh02.user.lect.entity.Lecture;
import com.cleanArch.hh02.user.lect.service.serviceDTO.LectureDTO;

public interface LectureService {
    public Lecture selectLectureByLectureId(LectureDTO param) throws RegistException;
    public void saveLectureRegist(LectureDTO param) throws ParseException, RegistException;
    public LectureDTO isRegistSuccess(LectureDTO param) throws RegistException;
    public Long selectRegistCnt(LectureDTO param) throws RegistException;
}
