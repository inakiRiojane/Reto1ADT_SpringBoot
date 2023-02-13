package com.grupo2.reto1.modelos.favoriteModelo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.grupo2.reto1.modelos.songModelo.Song;

public class FavoriteGetResponse {

	private Long idUser;
	private Long idSong;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Song> userFavoriteSongs;

	public FavoriteGetResponse() {
	}

	public FavoriteGetResponse(Long idUser, Long idSong) {
		super();
		this.idUser = idUser;
		this.idSong = idSong;
	}
	
	public FavoriteGetResponse(Long idUser, Long idSong, List<Song> userFavoriteSongs) {
		super();
		this.idUser = idUser;
		this.idSong = idSong;
		this.userFavoriteSongs = userFavoriteSongs;
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

	public List<Song> getUserFavoriteSongs() {
		return userFavoriteSongs;
	}

	public void setUserFavoriteSongs(List<Song> userFavoriteSongs) {
		this.userFavoriteSongs = userFavoriteSongs;
	}

	@Override
	public String toString() {
		return "FavoriteGetResponse [idUser=" + idUser + ", idSong=" + idSong + ", userFavoriteSongs="
				+ userFavoriteSongs + "]";
	}

}
