package com.grupo2.reto1.services.songService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grupo2.reto1.modelos.songModelo.Song;
import com.grupo2.reto1.modelos.songModelo.SongGetResponse;
import com.grupo2.reto1.modelos.songModelo.SongPostRequest;
import com.grupo2.reto1.repositories.songRepository.SongRepository;

@Service
public class SongServicelmpl implements SongService{

	@Autowired
	SongRepository songRepository;
	
	@Override
	public List<SongGetResponse> getAllSong() {
		
		List<SongGetResponse> response = new ArrayList<SongGetResponse>();
		List<Song> songList = songRepository.getAllSong();
		
		for (Song song : songList) {
			response.add(new SongGetResponse(
						song.getId(),
						song.getTitulo(),
						song.getAutor(),
						song.getUrl()));
		}
		return response;
	}

	@Override
	public SongGetResponse getSongById(Long id) {
		Song song  = songRepository.getSongById(id);
		SongGetResponse songGetResponse = new SongGetResponse(
												song.getId(),
												song.getTitulo(),
												song.getAutor(),
												song.getUrl());
		return songGetResponse;
	}

	@Override
	public int createSong(SongPostRequest postRequest) {
		Song song = new Song(null,
						postRequest.getTitulo(),
						postRequest.getAutor(),
						postRequest.getUrl());
		return songRepository.createSong(song);
	}

	@Override
	public int updateSongById(Long id, SongPostRequest postRequest) {
		Song song = new Song(id,
							postRequest.getTitulo(),
							postRequest.getAutor(),
							postRequest.getUrl());
		return songRepository.updateSong(song);
	}

	@Override
	public int deleteSongById(Long id) {
		int res = songRepository.deleteSongById(id);
		return res;
	}
}
