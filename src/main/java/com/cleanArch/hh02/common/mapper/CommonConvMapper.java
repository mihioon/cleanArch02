package com.cleanArch.hh02.common.mapper;

import com.cleanArch.hh02.common.dto.UserRequest;


public interface CommonConvMapper {
    //UserId Long 타입 반환
    public Long dtoToUserId(UserRequest param);
}
