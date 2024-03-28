package com.cleanArch.hh02.common.service.mapper;

import com.cleanArch.hh02.common.service.serviceDTO.UserDTO;
import com.cleanArch.hh02.error.ParseException;


public interface CommonConvMapper {
    //UserId Long 타입 반환
    public Long dtoToUserId(UserDTO param) throws ParseException;
}
