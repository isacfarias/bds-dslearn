package com.farias.dslearnbds.resources;

import com.farias.dslearnbds.dto.NotificationDTO;
import com.farias.dslearnbds.dto.UserDTO;
import com.farias.dslearnbds.service.NotificationService;
import com.farias.dslearnbds.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/notifications")
public class NotificationResource {
	
	@Autowired
	private NotificationService service;

	@GetMapping
	public ResponseEntity<Page<NotificationDTO>> notifications (
			@RequestParam(value = "unreadOnly", defaultValue = "false") Boolean unreadOnly,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "12") Integer size) {

		PageRequest pageRequest = PageRequest.of(page, size);
		var response = service.notificationsForCurrentUser(unreadOnly, pageRequest);

		return ResponseEntity.ok().body(response);
	}
	
}
