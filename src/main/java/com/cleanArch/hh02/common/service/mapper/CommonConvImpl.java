package com.cleanArch.hh02.common.service.mapper;

import com.cleanArch.hh02.common.service.serviceDTO.UserDTO;
import com.cleanArch.hh02.error.ParseException;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class CommonConvImpl implements CommonConvMapper {

    private static final Logger log = Logger.getLogger(CommonConvImpl.class.getName());

    //공통
    public Long parseStrLong(String str) throws ParseException {
        Long number = null;
        try {
            number = Long.parseLong(str);
        } catch (NumberFormatException e) {
            throw new ParseException("숫자 값이 아님.");
        }
        return number;
    }

    public Long dtoToUserId(UserDTO param) throws ParseException {
        return parseStrLong(param.getUserId());
    }
}
