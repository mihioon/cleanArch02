package com.cleanArch.hh02.user.lect.entity;

import com.cleanArch.hh02.common.entity.User;
import com.cleanArch.hh02.error.RegistException;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@Table(name = "lecture_regist",
        uniqueConstraints = { @UniqueConstraint(columnNames = {"userId", "timeId"}) }
)
public class LectureRegist { /* 강의예약정보 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; /* Key */

    /*
    JPA에서는 컬럼이 아닌 관련 엔티티 자체를 참조 : 객체 참조(Object Reference)
    객체 관계 매핑(Object-Relational Mapping, ORM)의 핵심적인 부분
    */
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "lectureId", nullable = false)
    private Lecture lecture;

    @Column(nullable = false)
    private LocalDateTime registDtm; /* 예약날짜 */

    @Column
    private Long registCnt; /* 특강신청인원 */

    public void validateInput(Lecture lecture) throws RegistException {
        // userId-lectId 예약내역 확인 > unique key

        // 특강 오픈 타임과 서버 타임 비교
        LocalDateTime localDtm = LocalDateTime.of(2024, 4, 20, 13, 0);//특강오픈타임
        // LocalDateTime localDtm2 = LocalDateTime.now(); //서버타임

        if (localDtm.isBefore(registDtm)) {
            throw new RegistException("특강 오픈 시간 아직 안 됨");
        }

        // 신청 인원수 확인
        if(!(registCnt < 30)){ //30명 보다 적어야 됨
            throw new RegistException("수강인원 초과");
        }
    }
}
