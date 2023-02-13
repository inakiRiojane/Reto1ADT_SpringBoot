package com.grupo2.reto1.modelos.userModelo;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class LoginPostRequest {

	@NotNull
	@Length(max = 100)
	private String loginUser;
	@NotNull
	@Length(max = 100)
	private String password;

	public LoginPostRequest() {
	}

	public LoginPostRequest(@NotNull @Length(max = 100) String loginUser, @NotNull @Length(max = 100) String password) {
		super();
		this.loginUser = loginUser;
		this.password = password;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
