package com.cleanArch.hh02.common.entity.repository;

import com.cleanArch.hh02.common.entity.User;

public interface UserRepository {
    User selectByUserId(Long userId); // userId로 user정보 조회
}
