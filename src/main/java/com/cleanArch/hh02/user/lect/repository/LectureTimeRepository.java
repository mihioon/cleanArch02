package com.cleanArch.hh02.user.lect.repository;

import com.cleanArch.hh02.user.lect.model.Lecture;
import com.cleanArch.hh02.user.lect.model.LectureTime;

public interface LectureTimeRepository {
    LectureTime selectByTimeId(Long timeId);
}
