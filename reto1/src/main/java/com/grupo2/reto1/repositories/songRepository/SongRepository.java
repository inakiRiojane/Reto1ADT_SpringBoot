package com.grupo2.reto1.repositories.songRepository;

import java.util.List;
import com.grupo2.reto1.modelos.songModelo.Song;

public interface SongRepository {

	List<Song> getAllSong();

	Song getSongById(Long id);

	public int createSong(Song song);

	public int updateSong(Song song);

	public int deleteSongById(Long id);

	List<Song> getUserFavorites(Long id);
}
