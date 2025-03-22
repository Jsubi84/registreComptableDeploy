package com.app.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record NewPasswordRequest(@NotBlank String oldPassword,
                                 @NotBlank String newPassword,
                                  @NotBlank String userName){}
