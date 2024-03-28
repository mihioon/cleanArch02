package com.cleanArch.hh02.user.lect.entity.repository;

import com.cleanArch.hh02.user.lect.entity.LectureRegist;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

//DAO e.g. DB에 데이터를 CRUD 하는 JpaRepository<>를 상속받는 Repository 객체들

public interface LectureRegistRepository extends JpaRepository<LectureRegist, Integer> {

    Long countByLectureId(Long lectureId); // 강의 ID로 강의 신청 인원 수 조회

    LectureRegist findByUserIdAndLectureId(Long userId, Long lectureId); // 사용자 해당강의 신청 여부

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    LectureRegist save(LectureRegist lectureRegist);
}
