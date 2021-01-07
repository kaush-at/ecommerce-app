package com.kaush.ebussinessapp.dtos;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
public class LoginDataDTO {

	private String username;
	private String password;
	private String userRole;
	private String email;
}
