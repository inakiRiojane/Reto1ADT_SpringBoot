package com.grupo2.reto1.modelos.favoriteModelo;

public class Favorite {

	private Long idUser;
	private Long idSong;

	public Favorite() {
	}

	public Favorite(Long idUser, Long idSong) {
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
		return "Favorite [idUser=" + idUser + ", idSong=" + idSong + "]";
	}

	
}
