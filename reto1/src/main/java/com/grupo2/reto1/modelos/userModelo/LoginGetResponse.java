package com.grupo2.reto1.modelos.userModelo;

public class LoginGetResponse {

	private String loginUser;
	private String accessToken;

	public LoginGetResponse() {
	}

	public LoginGetResponse(String loginUser, String accessToken) {
		super();
		this.loginUser = loginUser;
		this.accessToken = accessToken;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

}
