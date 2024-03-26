package com.cleanArch.hh02.user.lect.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
@Table(name = "lecture")
public class Lecture { /* 강의정보 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lectId; /* Key */

    @Column(length = 20, nullable = false)
    private String lectNm; /* 강의명 */

    @Column(length = 20, nullable = false)
    private String coachNm; /* 강사명 */

    @Column(length = 500)
    private String lectInfo; /* 강의정보 */

    @Column(nullable = false)
    private Integer size; /* 수강가능인원 */

    @OneToMany(mappedBy = "lecture")
    @OrderBy("startDtm ASC")
    private List<LectureTime> lectureTimes;
}
