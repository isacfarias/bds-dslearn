package com.farias.dslearnbds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farias.dslearnbds.entities.User;
import com.farias.dslearnbds.repositories.UserRepository;
import com.farias.dslearnbds.service.exceptions.ForbiddenException;
import com.farias.dslearnbds.service.exceptions.UnauthorizedException;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	public User authenticated() {
		try {
			final var userName = SecurityContextHolder.getContext().getAuthentication().getName();
			return userRepository.findByEmail(userName);
		} catch (Exception e) {
			throw new UnauthorizedException("Invalid user");
		}
	}

	public void validateSelfOrAdmin(Long userId) {
		User user = authenticated();

		if (!user.getId().equals(userId) && !user.hasRole("ROLE_ADMIN"))
			throw new ForbiddenException("Access denied");

	}
}
