package com.cleanArch.hh02.common.service;

import com.cleanArch.hh02.common.dto.UserRequest;
import com.cleanArch.hh02.common.mapper.CommonConvMapper;
import com.cleanArch.hh02.common.model.User;
import com.cleanArch.hh02.common.repository.UserRepository;

public interface UserService {
    public User selectUserByUserId(UserRequest param);
}