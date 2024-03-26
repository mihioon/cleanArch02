package com.cleanArch.hh02.user.lect.repository;

import com.cleanArch.hh02.common.model.User;
import com.cleanArch.hh02.user.lect.model.Lecture;
import com.cleanArch.hh02.user.lect.model.LectureTime;
import com.cleanArch.hh02.user.lect.model.LectureRegist;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LectureRegitstRepository extends JpaRepository<LectureRegist, Integer> {
    //DAO e.g. DB에 데이터를 CRUD 하는 JpaRepository<>를 상속받는 Repository 객체들
    int countByLecture(Lecture lecture); // 강의 ID로 강의 신청 인원 수 조회

    LectureTime findByLectIdAndUserId(User user, LectureTime lectureTime); // 해당 강의 사용자 신청여부

    @Query("SELECT DISTINCT lt FROM LectureTime lt JOIN lt.lectureRegists rg " +
            "WHERE rg.user.userId = :userId ORDER BY lt.startDtm ASC")
    List<LectureTime> findLecturesByUserOrderByTime(@Param("userId") Long userId); // 사용자 ID로 사용자 신청내역 조회

    // FK 제약 조건이 있는 테이블에는 낙관적 락(Optimistic Lock)을 이용시 데드락 발생 가능성 > 근데 비관적도 마찬가지임...
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    LectureRegist save(LectureRegist lectureRegist);
}
