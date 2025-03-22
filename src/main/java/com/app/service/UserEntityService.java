package com.app.service;

import com.app.controller.dto.AuthUpdaterUserRequest;
import com.app.controller.dto.NewUserResponse;
import com.app.controller.persistence.entity.UserEntity;

import java.util.List;

public interface UserEntityService extends BaseService<UserEntity, Long> {

    boolean updatePassUserById (String userName, String newPassword, String oldPassword) throws Exception;
    boolean resetPassUserById (Long userId, String password) throws Exception;
    boolean updateUser (AuthUpdaterUserRequest authUpdaterUserRequest) throws Exception;
}
