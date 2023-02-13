package com.grupo2.reto1.services.favoriteService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grupo2.reto1.modelos.favoriteModelo.Favorite;
import com.grupo2.reto1.modelos.favoriteModelo.FavoriteGetResponse;
import com.grupo2.reto1.modelos.favoriteModelo.FavoritePostRequest;
import com.grupo2.reto1.modelos.songModelo.SongGetResponse;
import com.grupo2.reto1.repositories.favoriteRepository.FavoriteRepository;
import com.grupo2.reto1.services.songService.SongService;

@Service
public class FavoriteServiceImpl implements FavoriteService{
	@Autowired
	SongService songService;
	@Autowired
	FavoriteRepository favoriteRepository;
	
	@Override
	public List<FavoriteGetResponse> getAllFavorites() {
		List<FavoriteGetResponse> response = new ArrayList<FavoriteGetResponse>();
		List<Favorite> favoriteListServiceResponse = favoriteRepository.getAllFavorites();

		for (Favorite favoriteActual : favoriteListServiceResponse) {
			response.add(new FavoriteGetResponse(favoriteActual.getIdUser(), favoriteActual.getIdSong()));
		}
		return response;
	}

	@Override
	public List<FavoriteGetResponse> getFavoriteById(Long id) {
		List<Favorite> favorite = favoriteRepository.getFavoriteById(id);
		List<FavoriteGetResponse> favoriteGetResponse = new ArrayList<FavoriteGetResponse>();
		
		for (Favorite favoriteActual : favorite) {
			favoriteGetResponse.add(new FavoriteGetResponse(favoriteActual.getIdUser(), favoriteActual.getIdSong()));
		}
		return favoriteGetResponse;
	}

	@Override
	public int createFavorite(Long idUser, Long idSong) {
		
		Favorite favorite = new Favorite(idUser, idSong);
		
		return favoriteRepository.createFavorite(favorite);
	}

	@Override
	public int updateFavoriteById(Long idSong, FavoritePostRequest favoritePostRequest) {
		Favorite favorite = new Favorite(favoritePostRequest.getIdUser(), idSong);
		return favoriteRepository.updateFavorite(favorite);
	}

	@Override
	public int deleteFavoriteById(Long idSong, Long idUser) {
		return favoriteRepository.deleteFavoriteId(idSong, idUser);
	}
	
	@Override
	public List<SongGetResponse> getFavoriteByUserId(Long id) {
		
		List<SongGetResponse> favoriteGetResponse = new ArrayList<>();
		
		List<Favorite> listFav=favoriteRepository.getFavoriteById(id);
		
		for(Favorite favorite : listFav) {			
			SongGetResponse getResponse = songService.getSongById(favorite.getIdSong());
			favoriteGetResponse.add(getResponse);		
		}
		return favoriteGetResponse;
	}



	

}
