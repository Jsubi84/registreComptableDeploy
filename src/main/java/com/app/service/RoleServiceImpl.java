package com.app.service;

import com.app.controller.persistence.entity.RoleEntity;
import com.app.controller.persistence.repository.BaseRepository;
import com.app.controller.persistence.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleEntity, Long> implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    public RoleServiceImpl(BaseRepository<RoleEntity, Long> baseRepository) {
        super(baseRepository);
    }

}
