package com.cleanArch.hh02.user.lect.mapper;

import com.cleanArch.hh02.common.mapper.CommonConvImpl;
import com.cleanArch.hh02.common.model.User;
import com.cleanArch.hh02.user.lect.dto.LectureListRequest;
import com.cleanArch.hh02.user.lect.dto.LectureListResponse;
import com.cleanArch.hh02.user.lect.dto.LectureRegistRequest;
import com.cleanArch.hh02.user.lect.model.LectureRegist;
import com.cleanArch.hh02.user.lect.model.LectureTime;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class LectureConvImpl extends CommonConvImpl implements LectureConvMapper {

    private static final Logger log = Logger.getLogger(LectureConvImpl.class.getName());

    @Override
    public Long dtoToUserId(LectureRegistRequest param) {
        String str = param.getUserId();
        Long result = parseStrLong(str);
        return result;
    }

    @Override
    public Long dtoToUserId(LectureListRequest param) {
        String str = param.getUserId();
        Long result = parseStrLong(str);
        return result;
    }

    @Override
    public LectureRegist dtoToEntity(LectureRegistRequest param, LectureTime lectureTime, User user) {
        LectureRegist result = new LectureRegist();
        Timestamp registDtm = Timestamp.from(Instant.now());

        result.setUser(user);
        result.setLectureTime(lectureTime);
        result.setRegistDtm(registDtm);

        return result;
    }

    @Override
    public List<LectureListResponse> entityToDto(List<LectureTime> param) {
        List<LectureListResponse> result = param.stream()
                                        .map(entity -> {
                                            LectureListResponse dto = new LectureListResponse();
                                            dto.setLectId(entity.getLecture().getLectId());
                                            dto.setLectNm(entity.getLecture().getLectNm());
                                            dto.setCoachNm(entity.getLecture().getCoachNm());
                                            dto.setStartDtm(entity.getStartDtm());
                                            dto.setEndDtm(entity.getEndDtm());
                                            return dto;
                                        }).collect(Collectors.toList());
        return result;
    }
}
