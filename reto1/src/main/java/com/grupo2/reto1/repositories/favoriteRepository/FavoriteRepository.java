package com.grupo2.reto1.repositories.favoriteRepository;

import java.util.List;
import com.grupo2.reto1.modelos.favoriteModelo.Favorite;

public interface FavoriteRepository {

	List<Favorite> getAllFavorites();

	List<Favorite> getFavoriteById(Long id);

	int createFavorite(Favorite favorite);

	int updateFavorite(Favorite favorite);

	int deleteFavoriteId(Long idSong, Long idUser);

}
