package com.app.controller;

import com.app.controller.persistence.entity.RoleEntity;
import com.app.service.RoleServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping({"/api/v1/roles"})
public class RoleController extends BaseControllerImpl<RoleEntity, RoleServiceImpl> {

}
