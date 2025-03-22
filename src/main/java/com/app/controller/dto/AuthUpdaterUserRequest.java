package com.app.controller.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AuthUpdaterUserRequest(@NotNull Long id,
                                    @NotBlank String username,
                                    @Valid AuthCreateRoleRequest roleRequest) {
}
