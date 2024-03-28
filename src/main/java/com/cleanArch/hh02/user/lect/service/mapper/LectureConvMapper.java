package com.cleanArch.hh02.user.lect.service.mapper;

import com.cleanArch.hh02.error.ParseException;
import com.cleanArch.hh02.error.RegistException;
import com.cleanArch.hh02.user.lect.entity.LectureRegist;
import com.cleanArch.hh02.user.lect.service.serviceDTO.LectureDTO;


public interface LectureConvMapper {

    public Long parseStrLong(String param) throws ParseException;
    //UserId Long 타입 반환
    public Long dtoToUserId(LectureDTO param) throws ParseException;
    public Long dtoToLectureId(LectureDTO param) throws ParseException;

    //dto -> entity
    public LectureRegist dtoToEntity(LectureDTO param) throws RegistException;

    //entity -> dto
    public LectureDTO entityToDto(LectureRegist param);

}
