package com.cleanArch.hh02.user.lect.service.mapper;

import com.cleanArch.hh02.common.service.mapper.CommonConvImpl;
import com.cleanArch.hh02.error.RegistException;
import com.cleanArch.hh02.user.lect.entity.LectureRegist;
import com.cleanArch.hh02.user.lect.service.serviceDTO.LectureDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LectureConvImpl extends CommonConvImpl implements LectureConvMapper {

    @Override
    public Long parseStrLong(String str) throws RegistException {
        Long number = null;
        try {
            number = Long.parseLong(str);
        } catch (NumberFormatException e) {
            throw new RegistException("숫자 값이 아님.");
        }
        return number;
    }

    @Override
    public Long dtoToUserId(LectureDTO param) throws RegistException {
        return parseStrLong(param.getUserId());
    }

    @Override
    public Long dtoToLectureId(LectureDTO param) throws RegistException {
        return parseStrLong(param.getLectureId());
    }

    @Override
    public LectureRegist dtoToEntity(LectureDTO param) {
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
