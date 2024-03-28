package com.cleanArch.hh02.user.lect.controller.controllerDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LectureListResponse {
    private Long lectureId; /* Key */
    private String lectureNm; /* 강의명 */
}
