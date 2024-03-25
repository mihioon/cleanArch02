package com.cleanArch.hh02.user.lect.mapper;

import com.cleanArch.hh02.user.lect.dto.LectureRegistDto;
import com.cleanArch.hh02.user.lect.model.LectureRegist;
import com.cleanArch.hh02.user.lect.model.LectureTime;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DtoToEntityImpl implements DtoToEntityMapper {
    @Override
    public LectureRegist dtoToLectureRegist(LectureRegistDto param) {
        return null;
    }

    @Override
    public List<LectureRegistDto> LectureTimeListToDto(List<LectureTime> param) {
        return null;
    }
}
