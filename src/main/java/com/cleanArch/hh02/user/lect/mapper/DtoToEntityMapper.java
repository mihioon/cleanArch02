package com.cleanArch.hh02.user.lect.mapper;

import com.cleanArch.hh02.user.lect.dto.LectureListDto;
import com.cleanArch.hh02.user.lect.dto.LectureRegistDto;
import com.cleanArch.hh02.user.lect.model.LectureRegist;
import com.cleanArch.hh02.user.lect.model.LectureTime;

import java.util.List;

public interface DtoToEntityMapper {
    public LectureRegist dtoToLectureRegist(LectureRegistDto param);
    public List<LectureListDto> LectureTimeListToDto(List<LectureTime> param);
}
