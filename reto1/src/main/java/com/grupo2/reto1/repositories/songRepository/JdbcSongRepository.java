package com.grupo2.reto1.repositories.songRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.grupo2.reto1.modelos.songModelo.Song;

@Repository
public class JdbcSongRepository implements SongRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Song> getAllSong() {
		return jdbcTemplate.query("SELECT * FROM songs", 
								BeanPropertyRowMapper.newInstance(Song.class));
	}

	@Override
	public Song getSongById(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM songs WHERE id = ?", 
								BeanPropertyRowMapper.newInstance(Song.class), id);
	}

	@Override
	public int createSong(Song song) {
		return jdbcTemplate.update(
				"INSERT INTO songs (titulo, autor, url) VALUES (?,?,?)",
				new Object[] {song.getTitulo(), song.getAutor(), song.getUrl()});
	}

	@Override
	public int updateSong(Song song) {
		return jdbcTemplate.update(
				"UPDATE songs SET titulo = ?, autor = ?, url = ? WHERE id = ?",
				new Object[] {song.getTitulo(), song.getAutor(), song.getUrl(), song.getId()});
	}

	@Override
	public int deleteSongById(Long id) {
		return jdbcTemplate.update("DELETE FROM songs WHERE id = ?", id);
	}

	@Override
	public List<Song> getUserFavorites(Long id) {
		try {
			return jdbcTemplate.query("SELECT S.id, S.titulo, S.autor, S.url FROM favorites F RIGHT JOIN songs S ON F.id_song = S.id\r\n"
					+ "WHERE F.id_user = ?", BeanPropertyRowMapper.newInstance(Song.class), id);
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

}
