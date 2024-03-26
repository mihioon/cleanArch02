package com.cleanArch.hh02.user.lect.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class LectureListResponse {
    private Long lectId; /* Key */
    private String lectNm; /* 강의명 */
    private String coachNm; /* 강사명 */
    private Timestamp startDtm; //"2024-03-26T22:07:30"
    private Timestamp endDtm;

}
