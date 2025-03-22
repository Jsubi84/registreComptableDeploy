package com.app.controller.persistence.repository;

import com.app.controller.persistence.entity.UserEntity;
import org.springframework.stereotype.Repository;



@Repository
public interface UserEntityRepository extends BaseRepository<UserEntity, Long> {



}
