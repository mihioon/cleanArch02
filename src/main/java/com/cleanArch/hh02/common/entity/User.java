package com.cleanArch.hh02.common.entity;

import com.cleanArch.hh02.user.lect.entity.LectureRegist;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
@Table(name = "user")
public class User { /* 사용자정보 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; /* Key */

    @Column(nullable = false)
    private byte[] loginId; /* 아이디 */

    @OneToMany(mappedBy = "user")
    private List<LectureRegist> lectureRegists;
}
