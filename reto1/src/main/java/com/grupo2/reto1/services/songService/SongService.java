package com.grupo2.reto1.services.songService;

import java.util.List;
import com.grupo2.reto1.modelos.songModelo.SongGetResponse;
import com.grupo2.reto1.modelos.songModelo.SongPostRequest;

public interface SongService {

	List<SongGetResponse> getAllSong();

	SongGetResponse getSongById(Long id);

	int createSong(SongPostRequest postRequest);

	int updateSongById(Long id, SongPostRequest postRequest);

	int deleteSongById(Long id);
}