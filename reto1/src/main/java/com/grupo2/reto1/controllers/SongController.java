package com.grupo2.reto1.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo2.reto1.modelos.songModelo.SongGetResponse;
import com.grupo2.reto1.modelos.songModelo.SongPostRequest;
import com.grupo2.reto1.services.songService.SongService;

@RequestMapping("api")
@RestController
public class SongController {

	@Autowired
	SongService songService;

	@GetMapping("/songs")
	public ResponseEntity<?> getSongs() {
		return new ResponseEntity<>(songService.getAllSong(), HttpStatus.OK);
	}

	@GetMapping("/song/{id}")
	public ResponseEntity<?> getSongById(@Valid @PathVariable("id") Long id) {

		SongGetResponse songGetResponse = songService.getSongById(id);
		return new ResponseEntity<SongGetResponse>(songGetResponse, HttpStatus.OK);
	}

	@PostMapping("/song")
	public ResponseEntity<?> createSong(@Valid @RequestBody SongPostRequest songPostRequest) {

		songService.createSong(songPostRequest);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/update/song/{id}")
	public ResponseEntity<?> updateSong(@PathVariable("id") Long id, @RequestBody SongPostRequest songPostRequest) {

		songService.updateSongById(id, songPostRequest);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/delete/song/{id}")
	public ResponseEntity<?> deleteSongById(@PathVariable("id") Long id) {

		songService.deleteSongById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}