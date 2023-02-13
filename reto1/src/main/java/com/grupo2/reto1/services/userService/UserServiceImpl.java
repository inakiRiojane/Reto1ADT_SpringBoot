package com.grupo2.reto1.services.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.grupo2.reto1.modelos.userModelo.PasswordPostRequest;
import com.grupo2.reto1.modelos.userModelo.User;
import com.grupo2.reto1.modelos.userModelo.UserGetResponse;
import com.grupo2.reto1.modelos.userModelo.UserPostRequest;
import com.grupo2.reto1.repositories.userRepository.UserRepository;
import com.grupo2.reto1.services.favoriteService.FavoriteService;
import com.grupo2.reto1.services.songService.SongService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	FavoriteService favoriteService;
	@Autowired
	SongService songService;
	@Autowired
	AuthenticationManager authManager;

	@Override
	public UserGetResponse getUserById(Long id) {

		User user = userRepository.getUserById(id);
		UserGetResponse userGetResponse = new UserGetResponse(user.getId(), user.getLoginUser(), user.getNombre(),
				user.getApellidos(), user.getEmail(), null);

		return userGetResponse;
	}

	@Override
	public int createUser(UserPostRequest userPostRequest) {

		User user = new User(null, userPostRequest.getLoginUser(), userPostRequest.getNombre(),
				userPostRequest.getApellidos(), userPostRequest.getEmail(), userPostRequest.getPassword());
		return userRepository.create(user);
	}

	@Override
	public int updateUser(Long id, UserPostRequest userPostRequest) {

		User user = new User(id, userPostRequest.getLoginUser(), userPostRequest.getNombre(),
				userPostRequest.getApellidos(), userPostRequest.getEmail(), userPostRequest.getPassword());

		return userRepository.updateUser(user);

	}

	@Override
	public int deleteUserById(Long id) {
		int result = userRepository.deleteUserById(id);

		return result;
	}

	@Override
	public int updatePassword(Long id, PasswordPostRequest passwordPostRequest) {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		User user = userRepository.getUserById(id);

		String oldPass = passwordPostRequest.getPasswordAntigua();
		String newPass = passwordPostRequest.getPasswordNueva();

		if (passwordEncoder.matches(oldPass, user.getPassword())) {

			int result = userRepository.updatePassword(id, newPass);

			return result;
		} else {
			System.out.println("noooooooooo");
			return 0;
		}
	}
}
