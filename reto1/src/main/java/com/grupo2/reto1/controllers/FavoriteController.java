package com.grupo2.reto1.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.grupo2.reto1.modelos.favoriteModelo.FavoriteGetResponse;
import com.grupo2.reto1.modelos.favoriteModelo.FavoritePostRequest;
import com.grupo2.reto1.modelos.songModelo.SongGetResponse;
import com.grupo2.reto1.modelos.userModelo.User;
import com.grupo2.reto1.services.favoriteService.FavoriteService;

@RestController
@RequestMapping("api")
public class FavoriteController {

	@Autowired
	FavoriteService favoriteService;

	@GetMapping("/favorites")
	public List<FavoriteGetResponse> getFavorites() {
		List<FavoriteGetResponse> favoritesListServiceResponse = favoriteService.getAllFavorites();
		return favoritesListServiceResponse;
	}

	@GetMapping("/favorites/{id}")
	public ResponseEntity<?> getFavorite(@Valid @PathVariable("id") Long id) {

		List<FavoriteGetResponse> favoriteGetResponse = favoriteService.getFavoriteById(id);
		return new ResponseEntity<List<FavoriteGetResponse>>(favoriteGetResponse, HttpStatus.OK);
	}

	@PostMapping("/favorites/create/{idSong}")
	public ResponseEntity<?> createFavorite(@PathVariable("idSong") Long idSong, Authentication authentication) {

		User userDetails = (User) authentication.getPrincipal();

		favoriteService.createFavorite(userDetails.getId(), idSong);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/favorites/{id}")
	public int updateFavorite(@PathVariable("id") Long id, @RequestBody FavoritePostRequest favoritePostRequest) {
		return favoriteService.updateFavoriteById(id, favoritePostRequest);
	}

	@DeleteMapping("/delete/favorite/{idSong}")
	public int deleteFavorite(@PathVariable("idSong") Long idSong, Authentication authentication) {
		User userDetails = (User) authentication.getPrincipal();
		return favoriteService.deleteFavoriteById(idSong, userDetails.getId());
	}

	@GetMapping("/favorites/user")
	public ResponseEntity<List<SongGetResponse>> getUserFavorites(Authentication authentication) {

		User userDetails = (User) authentication.getPrincipal();
		List<SongGetResponse> favoritesListServiceResponse = favoriteService.getFavoriteByUserId(userDetails.getId());
		return new ResponseEntity<List<SongGetResponse>>(favoritesListServiceResponse, HttpStatus.OK);
	}

}
