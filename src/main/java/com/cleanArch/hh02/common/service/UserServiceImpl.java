package com.cleanArch.hh02.common.service;

import com.cleanArch.hh02.common.dto.UserRequest;
import com.cleanArch.hh02.common.mapper.CommonConvMapper;
import com.cleanArch.hh02.common.model.User;
import com.cleanArch.hh02.common.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final CommonConvMapper mapper;
    private final UserRepository userRepository;

    public UserServiceImpl(CommonConvMapper mapper, UserRepository userRepository) {
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    public User selectUserByUserId(UserRequest param){
        Long userId = mapper.dtoToUserId(param);
        User result = userRepository.selectByUserId(userId);
        return result;
    }
}
