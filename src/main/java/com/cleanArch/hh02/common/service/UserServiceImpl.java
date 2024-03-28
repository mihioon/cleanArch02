package com.cleanArch.hh02.common.service;

import com.cleanArch.hh02.common.service.mapper.CommonConvMapper;
import com.cleanArch.hh02.common.entity.User;
import com.cleanArch.hh02.common.entity.repository.UserRepository;
import com.cleanArch.hh02.common.service.serviceDTO.UserDTO;
import com.cleanArch.hh02.error.ParseException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final CommonConvMapper mapper;
    private final UserRepository userRepository;

    public UserServiceImpl(CommonConvMapper mapper, UserRepository userRepository) {
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    public User selectUserByUserId(UserDTO param) throws ParseException {
        Long userId = mapper.dtoToUserId(param);
        User result = userRepository.selectByUserId(userId);
        return result;
    }
}
