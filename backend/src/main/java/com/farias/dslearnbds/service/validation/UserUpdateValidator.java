package com.farias.dslearnbds.service.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.farias.dslearnbds.dto.UserUpdateDTO;
import com.farias.dslearnbds.entities.User;
import com.farias.dslearnbds.repositories.UserRepository;
import com.farias.dslearnbds.resources.exceptions.FielddMessage;

public class UserUpdateValidator implements ConstraintValidator<UserUpdateValid, UserUpdateDTO> {
	
	@Autowired
	private HttpServletRequest request;
		
	@Autowired
	private UserRepository repository;
	
	@Override
	public void initialize(UserUpdateValid ann) {}

	@Override
	public boolean isValid(UserUpdateDTO dto, ConstraintValidatorContext context) {
		@SuppressWarnings("unchecked")
		final var uriVars = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		final long userId = Long.parseLong(uriVars.get("id"));
		
		List<FielddMessage> list = new ArrayList<>();
		
		User user = repository.findByEmail(dto.getEmail());		
		if (user != null && !user.getId().equals(userId) ) {
			list.add(new FielddMessage("email", "Email já existe"));
		}
		
		for (FielddMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage())
			                                              .addPropertyNode(e.getFiledName())
					                                      .addConstraintViolation();
		}
		
		return list.isEmpty();
	}
}