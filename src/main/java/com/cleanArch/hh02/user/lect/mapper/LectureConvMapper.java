package com.cleanArch.hh02.user.lect.mapper;

import com.cleanArch.hh02.common.model.User;
import com.cleanArch.hh02.user.lect.dto.LectureListRequest;
import com.cleanArch.hh02.user.lect.dto.LectureListResponse;
import com.cleanArch.hh02.user.lect.dto.LectureRegistRequest;
import com.cleanArch.hh02.user.lect.model.LectureRegist;
import com.cleanArch.hh02.user.lect.model.LectureTime;

import java.util.List;


public interface LectureConvMapper {

    public Long parseStrLong(String param);
    //UserId Long 타입 반환
    public Long dtoToUserId(LectureRegistRequest param);
    public Long dtoToUserId(LectureListRequest param);

    //dto -> entity
    public LectureRegist dtoToEntity(LectureRegistRequest param, LectureTime lectureTime, User user);

    //entity -> dto
    public List<LectureListResponse> entityToDto(List<LectureTime> param);


}
