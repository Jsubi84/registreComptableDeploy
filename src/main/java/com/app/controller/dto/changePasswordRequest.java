package com.app.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record changePasswordRequest(@NotBlank String password){}
