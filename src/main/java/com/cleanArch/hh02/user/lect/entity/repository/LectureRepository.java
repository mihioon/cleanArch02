package com.cleanArch.hh02.user.lect.entity.repository;

import com.cleanArch.hh02.user.lect.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Integer> {
    Lecture findByLectureId(Long lectId); // 강의 ID로 강의 조회
}
