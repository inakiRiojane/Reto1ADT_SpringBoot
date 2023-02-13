package com.grupo2.reto1.services.userService;

import com.grupo2.reto1.modelos.userModelo.PasswordPostRequest;
import com.grupo2.reto1.modelos.userModelo.UserGetResponse;
import com.grupo2.reto1.modelos.userModelo.UserPostRequest;

public interface UserService {

	UserGetResponse getUserById(Long id);

	int createUser(UserPostRequest postRequest);

	int updateUser(Long id, UserPostRequest postRequest);

	int updatePassword(Long id, PasswordPostRequest passwordPostRequest);

	int deleteUserById(Long id);

}
