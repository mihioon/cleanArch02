package com.cleanArch.hh02.user.lect.service;

import com.cleanArch.hh02.common.dto.UserRequest;
import com.cleanArch.hh02.common.model.User;
import com.cleanArch.hh02.common.service.UserService;
import com.cleanArch.hh02.user.lect.dto.LectureListRequest;
import com.cleanArch.hh02.user.lect.dto.LectureListResponse;
import com.cleanArch.hh02.user.lect.dto.LectureRegistRequest;
import com.cleanArch.hh02.user.lect.mapper.LectureConvMapper;
import com.cleanArch.hh02.user.lect.model.LectureRegist;
import com.cleanArch.hh02.user.lect.model.LectureTime;
import com.cleanArch.hh02.user.lect.repository.LectureRegitstRepository;
import com.cleanArch.hh02.user.lect.repository.LectureTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class LectureServiceImpl implements LectureService{

    private final LectureConvMapper mapper;
    private final LectureRegitstRepository regitstRepo;
    private final LectureTimeRepository timeRepo;

    private static final Logger log = Logger.getLogger(LectureServiceImpl.class.getName());

    private static UserService userService;

    @Autowired
    public LectureServiceImpl(LectureConvMapper mapper, LectureRegitstRepository regitstRepo, LectureTimeRepository timeRepo) {
        this.mapper = mapper;
        this.regitstRepo = regitstRepo;
        this.timeRepo = timeRepo;
    }

    @Override
    public String lectureRegist(LectureRegistRequest param) {
        String userId = param.getUserId();
        Long timeId = mapper.parseStrLong(param.getTimeId());

        LectureTime lectureTime = timeRepo.selectByTimeId(timeId);
        UserRequest userDto = new UserRequest(userId);
        User user = userService.selectUserByUserId(userDto);

        LectureRegist lectureRegist = mapper.dtoToEntity(param, lectureTime, user);

        registCheck(lectureRegist); // 유효성 체크

        String result = "01";
        try {
            regitstRepo.save(lectureRegist);
            result = "00"; //성공
        } catch (DataAccessException e) {
            log.severe("lectureRegist>DataAccessException : " + e.toString());
        } catch(Exception e) {
            log.severe("lectureRegist>error : " + e.toString());
        }
        return result;
    }

    @Override
    public List<LectureListResponse> registSuccessList(LectureListRequest param) {
        Long userId = mapper.dtoToUserId(param);
        List<LectureTime> resultE = regitstRepo.findLecturesByUserOrderByTime(userId);
        List<LectureListResponse> result = mapper.entityToDto(resultE);
        return result;
    }

    public LectureTime selectLecTimeByUserId(LectureRegist param){
        LectureTime result = new LectureTime();
        result = timeRepo.selectByTimeId(param);
        return result;
    }
    public void registCheck(LectureRegist param){
        // userId timeId 있는지 체크

        // userId-timeId 예약내역 없는지 체크

        // 특강 타임과 서버 타임 비교

    }
}
