package com.cleanArch.hh02.user.lect.service.mapper;

import com.cleanArch.hh02.error.RegistException;
import com.cleanArch.hh02.user.lect.entity.LectureRegist;
import com.cleanArch.hh02.user.lect.service.serviceDTO.LectureDTO;


public interface LectureConvMapper {

    public Long parseStrLong(String param) throws RegistException;
    //UserId Long 타입 반환
    public Long dtoToUserId(LectureDTO param) throws RegistException;
    public Long dtoToLectureId(LectureDTO param) throws RegistException;

    //dto -> entity
    public LectureRegist dtoToEntity(LectureDTO param);

    //entity -> dto
    public LectureDTO entityToDto(LectureRegist param);

}
