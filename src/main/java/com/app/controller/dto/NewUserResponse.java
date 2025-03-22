package com.app.controller.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"success", "message"})
public record NewUserResponse(Boolean success, String message){

}
