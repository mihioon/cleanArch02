package com.cleanArch.hh02.user.lect.service;

import com.cleanArch.hh02.common.entity.User;
import com.cleanArch.hh02.common.service.UserService;
import com.cleanArch.hh02.common.service.serviceDTO.UserDTO;
import com.cleanArch.hh02.error.ParseException;
import com.cleanArch.hh02.error.RegistException;
import com.cleanArch.hh02.user.lect.service.mapper.LectureConvMapper;
import com.cleanArch.hh02.user.lect.entity.Lecture;
import com.cleanArch.hh02.user.lect.entity.LectureRegist;
import com.cleanArch.hh02.user.lect.entity.repository.LectureRegistRepository;
import com.cleanArch.hh02.user.lect.entity.repository.LectureRepository;
import com.cleanArch.hh02.user.lect.service.serviceDTO.LectureDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Logger;

@Service
public class LectureServiceImpl implements LectureService{

    private final LectureConvMapper mapper;
    private final LectureRegistRepository regitstRepo;
    private final LectureRepository lectureRepo;

    private static final Logger log = Logger.getLogger(LectureServiceImpl.class.getName());

    private static UserService userService;

    @Autowired
    public LectureServiceImpl(LectureConvMapper mapper, LectureRegistRepository regitstRepo, LectureRepository lectureRepo) {
        this.mapper = mapper;
        this.regitstRepo = regitstRepo;
        this.lectureRepo = lectureRepo;
    }

    @Override
    public Lecture selectLectureByLectureId(LectureDTO param) throws RegistException {
        Long lectureId = mapper.dtoToLectureId(param);
        Lecture result = lectureRepo.findByLectureId(lectureId);
        return result;
    }

    @Override
    @Transactional
    public void saveLectureRegist(LectureDTO param) throws ParseException, RegistException  {
        UserDTO userDTO = UserDTO.builder().userId(param.getUserId()).build();
        User user = userService.selectUserByUserId(userDTO);

        LectureDTO lectureDTO = LectureDTO.builder().lectureId(param.getLectureId()).build();
        Lecture lecture = selectLectureByLectureId(lectureDTO);

        Long registCnt = selectRegistCnt(lectureDTO);

        LectureDTO lectureRegistDTO = LectureDTO.builder().user(user).lecture(lecture).registCnt(registCnt).build();
        LectureRegist lectureRegist = mapper.dtoToEntity(lectureRegistDTO);

        regitstRepo.save(lectureRegist);
    }

    @Override
    public LectureDTO isRegistSuccess(LectureDTO param) {
        Long userId = 0L;
        Long lectureId = 0L;

        LectureRegist lectureRegist = regitstRepo.findByUserIdAndLectureId(userId, lectureId);
        LectureDTO result = mapper.entityToDto(lectureRegist);
        return result;
    }

    public Long selectRegistCnt(LectureDTO param) throws RegistException {
        Long lectureId = mapper.dtoToLectureId(param);
        Long result = regitstRepo.countByLectureId(lectureId);
        return result;
    }
}
