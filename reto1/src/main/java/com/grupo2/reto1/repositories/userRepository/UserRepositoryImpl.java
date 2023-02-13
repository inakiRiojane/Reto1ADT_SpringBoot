package com.grupo2.reto1.repositories.userRepository;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import com.grupo2.reto1.modelos.userModelo.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User getUserById(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?",
				BeanPropertyRowMapper.newInstance(User.class), id);
	}

	@Override
	public int create(User user) {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = passwordEncoder.encode(user.getPassword());

		return jdbcTemplate.update(
				"INSERT INTO users ( login_user, nombre, apellidos, email, password) VALUES( ?, ?, ?, ?, ?)",
				new Object[] { user.getLoginUser(), user.getNombre(), user.getApellidos(), user.getEmail(), password });
	}

	@Override
	public int updateUser(User user) {

		return jdbcTemplate.update(
				"UPDATE users SET loginUser = ?, nombre = ?, apellidos = ?, email = ?, password = ? WHERE id = ? ",
				new Object[] { user.getLoginUser(), user.getNombre(), user.getApellidos(), user.getEmail(),
						user.getPassword(), user.getId() });

	}

	@Override
	public int deleteUserById(Long id) {
		return jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
	}

	@Override
	public Optional<User> findByUsername(String username) {
		try {
			User user = jdbcTemplate.queryForObject("SELECT * from users where login_user = ?",
					BeanPropertyRowMapper.newInstance(User.class), username);
			return Optional.of(user);
		} catch (EmptyResultDataAccessException e) {
			System.out.println(username);
			e.printStackTrace();
			return Optional.empty();
		}
	}

	@Override
	public int updatePassword(Long id, String password) {
		// TODO CHANGE PASSWORD
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String newPass = passwordEncoder.encode(password);
		
		return jdbcTemplate.update("UPDATE users SET password = ? WHERE id = ?", newPass, id);

	}

}
