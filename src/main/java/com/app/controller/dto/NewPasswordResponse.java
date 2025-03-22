package com.app.controller.dto;

import com.app.controller.persistence.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"user"})
public record NewPasswordResponse (UserEntity user){

}
