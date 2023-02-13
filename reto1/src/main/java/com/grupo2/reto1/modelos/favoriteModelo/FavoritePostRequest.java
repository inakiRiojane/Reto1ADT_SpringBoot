package com.grupo2.reto1.modelos.favoriteModelo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class FavoritePostRequest {

	@NotNull(message = "No puede ser nulo")
	@NotEmpty(message = "No puede estar vacio")
	@NotBlank(message = "No puede estar en blanco")
	private Long idUser;
	@NotNull(message = "No puede ser nulo")
	@NotEmpty(message = "No puede estar vacio")
	@NotBlank(message = "No puede estar en blanco")
	private Long idSong;
	
	public FavoritePostRequest() {}

	public FavoritePostRequest(
			@NotNull(message = "No puede ser nulo") @NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") Long idUser,
			@NotNull(message = "No puede ser nulo") @NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") Long idSong) {
		super();
		this.idUser = idUser;
		this.idSong = idSong;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdSong() {
		return idSong;
	}

	public void setIdSong(Long idSong) {
		this.idSong = idSong;
	}

	@Override
	public String toString() {
		return "FavoritePostRequest [idUser=" + idUser + ", idSong=" + idSong + "]";
	}
	
}
