package com.cleanArch.hh02.user.lect.service;

import com.cleanArch.hh02.error.RegistException;
import com.cleanArch.hh02.user.lect.entity.Lecture;
import com.cleanArch.hh02.user.lect.service.serviceDTO.LectureDTO;

public interface LectureService {
    public Lecture selectLectureByLectureId(LectureDTO param);
    public void saveLectureRegist(LectureDTO param) throws RegistException;
    public LectureDTO isRegistSuccess(LectureDTO param);
    public Long selectRegistCnt(LectureDTO param);
}
