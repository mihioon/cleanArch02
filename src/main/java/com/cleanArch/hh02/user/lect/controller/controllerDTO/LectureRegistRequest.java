package com.cleanArch.hh02.user.lect.controller.controllerDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LectureRegistRequest {
    private String userId;
    private String lectureId;
}
