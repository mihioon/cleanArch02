package com.cleanArch.hh02.common.model;

import com.cleanArch.hh02.user.lect.model.LectureRegist;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
@Table(name = "user")
public class User { /* 사용자정보 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId; /* Key */

    @Column(nullable = false)
    private byte[] id; /* 아이디 */

    @Column(nullable = false)
    private byte[] password; /* 비밀번호 */

    @Column(length = 20, nullable = false)
    private String userNm; /* 이름 */

    @Column
    private byte[] email; /* 이메일 */

    @Column(length = 20)
    private String nickNm; /* 닉네임 */

    @Column(nullable = false)
    private Boolean useYn; /* 사용여부 */

    @OneToMany(mappedBy = "user")
    private List<LectureRegist> lectureRegists;
}
