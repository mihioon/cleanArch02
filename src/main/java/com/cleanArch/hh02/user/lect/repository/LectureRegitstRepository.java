package com.cleanArch.hh02.user.lect.repository;

import com.cleanArch.hh02.user.lect.model.LectureTime;
import com.cleanArch.hh02.user.lect.model.LectureRegist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LectureRegitstRepository extends JpaRepository<LectureRegist, Integer> {
    int countByLectId(Long lectId); // 강의 ID로 강의 신청 인원 수 조회

    int countByLectIdAndUserId(Long lectId, Long userId); // 해당 강의 사용자 신청여부

    @Query("SELECT DISTINCT lt FROM LectureTime lt JOIN lt.lectureRegists rg " +
            "WHERE rg.user.userId = :userId ORDER BY lt.startDtm ASC")
    List<LectureTime> findLecturesByUserOrderByTime(@Param("userId") Long userId); // 사용자 ID로 사용자 신청내역 조회
}
