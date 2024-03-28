package com.cleanArch.hh02.user.lect.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
@Table(name = "lecture")
public class Lecture { /* 강의정보 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; /* Key */

    @Column(length = 20, nullable = false)
    private String lectureNm; /* 강의명 */

    @OneToMany(mappedBy = "lecture")
    private List<LectureRegist> lectureRegists;
}
