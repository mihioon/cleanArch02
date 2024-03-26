package com.cleanArch.hh02.user.lect.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LectureListRequest {
    private String userId;

    private String lectId;

    private String startDtm; //"2024-03-26T22:07:30"
    private String endDtm;

}
