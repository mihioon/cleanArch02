package com.cleanArch.hh02.common.service;

import com.cleanArch.hh02.common.entity.User;
import com.cleanArch.hh02.common.service.serviceDTO.UserDTO;
import com.cleanArch.hh02.error.ParseException;

public interface UserService {
    public User selectUserByUserId(UserDTO param) throws ParseException;
}