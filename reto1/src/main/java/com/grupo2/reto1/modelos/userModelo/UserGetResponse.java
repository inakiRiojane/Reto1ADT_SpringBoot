package com.grupo2.reto1.modelos.userModelo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.grupo2.reto1.modelos.favoriteModelo.FavoriteGetResponse;

public class UserGetResponse {

	private Long id;
	private String loginUser;
	private String nombre;
	private String apellidos;
	private String email;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<FavoriteGetResponse> favoriteGetResponseList;

	public UserGetResponse() {

	}

	public UserGetResponse(Long id, String loginUser, String nombre, String apellidos, String email,
			List<FavoriteGetResponse> favoriteGetResponseList) {
		super();
		this.id = id;
		this.loginUser = loginUser;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.favoriteGetResponseList = favoriteGetResponseList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<FavoriteGetResponse> getFavoriteGetResponseList() {
		return favoriteGetResponseList;
	}

	public void setFavoriteGetResponseList(List<FavoriteGetResponse> favoriteGetResponseList) {
		this.favoriteGetResponseList = favoriteGetResponseList;
	}

	@Override
	public String toString() {
		return "UserGetResponse [id=" + id + ", loginUser=" + loginUser + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", email=" + email + ", favoriteGetResponseList=" + favoriteGetResponseList + "]";
	}

}
