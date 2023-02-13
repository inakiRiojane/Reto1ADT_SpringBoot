package com.grupo2.reto1.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo2.reto1.modelos.userModelo.PasswordPostRequest;
import com.grupo2.reto1.modelos.userModelo.User;
import com.grupo2.reto1.modelos.userModelo.UserGetResponse;
import com.grupo2.reto1.modelos.userModelo.UserPostRequest;
import com.grupo2.reto1.security.JwtTokenUtil;
import com.grupo2.reto1.services.userService.UserService;

@RequestMapping("api")
@RestController
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	AuthenticationManager authManager;

	@Autowired
	JwtTokenUtil jwtUtil;

	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {

		UserGetResponse userGetResponse = userService.getUserById(id);
		return new ResponseEntity<UserGetResponse>(userGetResponse, HttpStatus.OK);
	}

	@PostMapping("/user/signup")
	public ResponseEntity<?> createUser(@Valid @RequestBody UserPostRequest userPostRequest) {

		return new ResponseEntity<Integer>(userService.createUser(userPostRequest), HttpStatus.CREATED);
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody UserPostRequest userPostRequest) {

		userService.updateUser(id, userPostRequest);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {

		userService.deleteUserById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/user/password")
	public ResponseEntity<?> updatePassword(@Valid @RequestBody PasswordPostRequest passwordPostRequest,
			Authentication authentication) {

		User userDetails = (User) authentication.getPrincipal();

		userService.updatePassword(userDetails.getId(), passwordPostRequest);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
