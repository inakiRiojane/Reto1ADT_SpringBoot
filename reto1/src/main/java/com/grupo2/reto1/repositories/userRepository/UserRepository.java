package com.grupo2.reto1.repositories.userRepository;

import java.util.Optional;
import com.grupo2.reto1.modelos.userModelo.User;

public interface UserRepository {
	User getUserById(Long id);

	int create(User user);

	int updateUser(User user);
	
	int updatePassword(Long id,String password);

	int deleteUserById(Long id);

	Optional<User> findByUsername(String username);

}
