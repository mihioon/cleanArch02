package com.cleanArch.hh02.user.lect.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LectureRegistRequest {
    private String userId;
    private String timeId;
}
