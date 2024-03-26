package com.cleanArch.hh02.common.mapper;

import com.cleanArch.hh02.common.dto.UserRequest;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class CommonConvImpl implements CommonConvMapper {

    private static final Logger log = Logger.getLogger(CommonConvImpl.class.getName());

    //공통
    public Long parseStrLong(String str){
        Long number = 0L;
        try {
            number = Long.parseLong(str);
        } catch (NumberFormatException e) {
            log.severe("DtoToEntity>NumberFormatException : " + e.toString());
        }
        return number;
    }

    public Long dtoToUserId(UserRequest param) {
        String str = param.getUserId();
        Long result = parseStrLong(str);
        return result;
    }
}
