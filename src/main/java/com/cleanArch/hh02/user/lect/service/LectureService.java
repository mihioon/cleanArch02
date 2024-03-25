package com.cleanArch.hh02.user.lect.service;

import com.cleanArch.hh02.user.lect.dto.LectureListDto;
import com.cleanArch.hh02.user.lect.dto.LectureRegistDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LectureService {
    public void lectureRegist(LectureRegistDto param);
    public List<LectureListDto> registSuccessList();
}
