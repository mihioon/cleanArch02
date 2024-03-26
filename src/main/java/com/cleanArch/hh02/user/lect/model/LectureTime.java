package com.cleanArch.hh02.user.lect.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Table(name = "lecture_time")
public class LectureTime { /* 강의시간정보 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timeId; /* Key */

    @ManyToOne
    @JoinColumn(name = "lectId", nullable = false)
    private Lecture lecture;

    @Column(nullable = false)
    private Timestamp startDtm; /* 강의시작시간 */

    @Column(nullable = false)
    private Timestamp endDtm; /* 강의종료시간 */

    @OneToMany(mappedBy = "lectureTime")
    private List<LectureRegist> lectureRegists;
}
