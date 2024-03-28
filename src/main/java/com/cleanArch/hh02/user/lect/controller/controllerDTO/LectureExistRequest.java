package com.cleanArch.hh02.user.lect.controller.controllerDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LectureExistRequest {
    private String userId;
    private String lectureId;
}
