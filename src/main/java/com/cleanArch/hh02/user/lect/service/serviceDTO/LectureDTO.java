package com.cleanArch.hh02.user.lect.service.serviceDTO;

import com.cleanArch.hh02.common.model.User;
import com.cleanArch.hh02.user.lect.entity.Lecture;
import lombok.*;

@Data
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LectureDTO {
    private String userId;
    private String lectureId;
    private String lectureNm; /* 강의명 */

    private User user;
    private Lecture lecture;
    private Long registCnt;
}
