package com.cleanArch.hh02.user.lect.service.mapper;

import com.cleanArch.hh02.common.mapper.CommonConvImpl;
import com.cleanArch.hh02.error.RegistException;
import com.cleanArch.hh02.user.lect.entity.LectureRegist;
import com.cleanArch.hh02.user.lect.service.serviceDTO.LectureDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LectureConvImpl extends CommonConvImpl implements LectureConvMapper {

    @Override
    public Long dtoToUserId(LectureDTO param) {
        return parseStrLong(param.getUserId());
    }

    @Override
    public Long dtoToLectureId(LectureDTO param) {
        return parseStrLong(param.getLectureId());
    }

    @Override
    public LectureRegist dtoToEntity(LectureDTO param) throws RegistException {
        LocalDateTime registDtm = LocalDateTime.now();

        LectureRegist result = LectureRegist.builder()
                                        .user(param.getUser())
                                        .lecture(param.getLecture())
                                        .registDtm(registDtm)
                                        .registCnt(param.getRegistCnt())
                                        .build();

        return result;
    }

    @Override
    public LectureDTO entityToDto(LectureRegist param) {
        LectureDTO result = LectureDTO.builder()
                .user(param.getUser())
                .lecture(param.getLecture())
                .build();

        return result;
    }
}
