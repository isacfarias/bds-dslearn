package com.farias.dslearnbds.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.farias.dslearnbds.entities.User;
import com.farias.dslearnbds.repositories.RoleRepository;
import com.farias.dslearnbds.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	private static Logger LOG  = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder ;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	/*
	@Transactional(readOnly = true)
	public Page<UserDTO> findAllPaged(PageRequest pageRequest) {
		return userRepository.findAll(pageRequest).map(UserDTO::new);
	}

	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
		return new UserDTO(user);				
	}

	@Transactional
	public UserDTO save(UserInsertDTO dto) {
		User user = new User();
		copyDtoToEntity(dto, user);
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		return new UserDTO(userRepository.save(user));
	}

	@Transactional
	public UserDTO update(Long id, UserUpdateDTO dto) {
		try {
			User user = userRepository.getOne(id);
			copyDtoToEntity(dto, user);
			return new UserDTO(userRepository.save(user));
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id não encontrado: "+id);
		}
	}

	public void delete(Long id) {
		try {
			userRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Integridade violada: "+id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id não encontrado: "+id);
		}
	}
	
	private void copyDtoToEntity(UserDTO dto, User user) {
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setEmail(dto.getEmail());
		user.getRoles().clear();
		for (RoleDTO roleDTO : dto.getRoles()) {
			Role role = roleRepository.getOne(roleDTO.getId());
			user.getRoles().add(role);								
		}
	}
	
	*/

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if (user == null) {
			LOG.error("Email not found:"+username);
			throw new UsernameNotFoundException("Email not found"); 
		}
		LOG.info("User found:"+username);
		return user;
	}
}