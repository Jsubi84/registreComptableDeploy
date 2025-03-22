package com.app.service;

import com.app.controller.dto.AuthUpdaterUserRequest;
import com.app.controller.dto.NewUserResponse;
import com.app.controller.persistence.entity.RoleEntity;
import com.app.controller.persistence.entity.UserEntity;
import com.app.controller.persistence.repository.BaseRepository;
import com.app.controller.persistence.repository.RoleRepository;
import com.app.controller.persistence.repository.UserEntityRepository;
import com.app.controller.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class UserEntityServiceImpl extends BaseServiceImpl<UserEntity, Long> implements UserEntityService{

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleEntityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserEntityServiceImpl(BaseRepository<UserEntity, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public boolean updatePassUserById(String userName, String newPassword, String oldPassword) throws Exception {
        Optional<UserEntity> userOptional = userRepository.findUserEntityByUsername(userName);
        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            boolean matches = passwordEncoder.matches(oldPassword, user.getPassword());
            if (matches) {
                user.setPassword(passwordEncoder.encode(newPassword));
                baseRepository.save(user);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean resetPassUserById(Long userId, String password) throws Exception {
        Optional<UserEntity> userOptional = baseRepository.findById(userId);

        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            String encodedPassword = passwordEncoder.encode(password);
            user.setPassword(encodedPassword);
            baseRepository.save(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateUser(AuthUpdaterUserRequest authUpdaterUserRequest) throws Exception {
        Optional<UserEntity> userOptional = baseRepository.findById(authUpdaterUserRequest.id());
        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            user.setUsername(authUpdaterUserRequest.username());
            Set<RoleEntity> roles = new HashSet<>(roleEntityRepository.findRoleEntitiesByRoleEnumIn(authUpdaterUserRequest.roleRequest().roleListName()));
            user.setRoles(roles);
            UserEntity userUpdated = baseRepository.save(user);
            return true;
        } else {
            return false;
        }
    }

}
