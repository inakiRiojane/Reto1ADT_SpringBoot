package com.grupo2.reto1.repositories.favoriteRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.grupo2.reto1.modelos.favoriteModelo.Favorite;

@Repository
public class FavoriteRepositoryImpl implements FavoriteRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Favorite> getAllFavorites() {
		try {
			return jdbcTemplate.query("SELECT * FROM favorites", BeanPropertyRowMapper.newInstance(Favorite.class));
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Favorite> getFavoriteById(Long id) {
		try {
			return jdbcTemplate.query("SELECT * FROM favorites WHERE id_user = ?",
					BeanPropertyRowMapper.newInstance(Favorite.class), id);
		}catch(IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}
	
	@Override
	public int createFavorite(Favorite favorite) {
		return jdbcTemplate.update(
				"INSERT INTO favorites (id_user, id_song) VALUES (?, ?)", 
				new Object[] { favorite.getIdUser(), favorite.getIdSong()}
		);
	}

	@Override
	public int updateFavorite(Favorite favorite) {
		return jdbcTemplate.update(
				"UPDATE favorites SET id_song = ? WHERE id_user = ?", 
				new Object[] { favorite.getIdSong(), favorite.getIdUser()}
				);
	}

	/**
	 * @return devuelve un delete de la CANCION que escoja el usuario
	 */
	@Override
	public int deleteFavoriteId(Long idSong, Long idUser) {
		return jdbcTemplate.update("DELETE FROM favorites WHERE id_song = ? AND id_user = ?", idSong, idUser);
	}



}
