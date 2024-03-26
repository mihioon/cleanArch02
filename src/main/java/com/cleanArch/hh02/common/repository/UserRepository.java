package com.cleanArch.hh02.common.repository;

import com.cleanArch.hh02.common.model.User;

public interface UserRepository {
    User selectByUserId(Long userId); // userId로 user정보 조회
}
