package com.cleanArch.hh02.user.lect.service;

import com.cleanArch.hh02.user.lect.dto.LectureListDto;
import com.cleanArch.hh02.user.lect.dto.LectureRegistDto;
import com.cleanArch.hh02.user.lect.mapper.DtoToEntityMapper;
import com.cleanArch.hh02.user.lect.model.LectureRegist;
import com.cleanArch.hh02.user.lect.model.LectureTime;
import com.cleanArch.hh02.user.lect.repository.LectureRegitstRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class LectureServiceImpl implements LectureService{

    private final DtoToEntityMapper mapper;
    private final LectureRegitstRepository lectureRegitstRepository;

    @Autowired
    public LectureServiceImpl(DtoToEntityMapper mapper, LectureRegitstRepository lectureRegitstRepository) {
        this.mapper = mapper;
        this.lectureRegitstRepository = lectureRegitstRepository;
    }

    @Override
    public void lectureRegist(LectureRegistDto param) {
        LectureRegist LectureRegist = mapper.dtoToLectureRegist(param);
        lectureRegitstRepository.save(LectureRegist);
    }

    @Override
    public List<LectureListDto> registSuccessList() {
        Long id = 0L; //세션에서 받는게 베스트인디...
        List<LectureTime> param = lectureRegitstRepository.findLecturesByUserOrderByTime(id);
        List<LectureListDto> result = mapper.LectureTimeListToDto(param);
        return result;
    }
}
