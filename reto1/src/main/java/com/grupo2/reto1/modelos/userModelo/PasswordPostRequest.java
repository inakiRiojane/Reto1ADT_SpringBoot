package com.grupo2.reto1.modelos.userModelo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class PasswordPostRequest {

	@NotNull
	@Length(max = 100)
	private String passwordAntigua;
	@NotNull
	@Length(max = 100)
	private String passwordNueva;

	public PasswordPostRequest(@NotNull @Length(max = 100) String passwordAntigua,
			@NotNull @Length(max = 100) String passwordNueva) {
		super();
		this.passwordAntigua = passwordAntigua;
		this.passwordNueva = passwordNueva;
	}

	public String getPasswordAntigua() {
		return passwordAntigua;
	}

	public void setPasswordAntigua(String passwordAntigua) {
		this.passwordAntigua = passwordAntigua;
	}

	public String getPasswordNueva() {
		return passwordNueva;
	}

	public void setPasswordNueva(String passwordNueva) {
		this.passwordNueva = passwordNueva;
	}

	@Override
	public String toString() {
		return "PasswordPostRequest [passwordAntigua=" + passwordAntigua + ", passwordNueva=" + passwordNueva + "]";
	}

}
