package com.cleanArch.hh02.user.lect.model;

import com.cleanArch.hh02.common.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "lecture_regist",
        uniqueConstraints = { @UniqueConstraint(columnNames = {"userId", "timeId"}) }
)
public class LectureRegist { /* 강의예약정보 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registId; /* Key */

    /*
    JPA에서는 컬럼이 아닌 관련 엔티티 자체를 참조 : 객체 참조(Object Reference)
    객체 관계 매핑(Object-Relational Mapping, ORM)의 핵심적인 부분
    */
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "timeId", nullable = false)
    private LectureTime lectureTime;

    @Column(nullable = false)
    private Timestamp registDtm; /* 예약날짜 */
}
