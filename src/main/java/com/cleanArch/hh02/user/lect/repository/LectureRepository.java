package com.cleanArch.hh02.user.lect.repository;

import com.cleanArch.hh02.user.lect.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Integer> {
    Lecture findByLectId(Long lectId); // 강의 ID로 강의 조회

    List<Lecture> findAllByStartDtmBetween(LocalDateTime start, LocalDateTime end);
}
