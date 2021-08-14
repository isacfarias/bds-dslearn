package com.farias.dslearnbds.service;

import com.farias.dslearnbds.dto.NotificationDTO;
import com.farias.dslearnbds.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository repository;

    @Autowired
    private AuthService authService;

    public Page<NotificationDTO> notificationsForCurrentUser(boolean unreadOnly, Pageable pageable) {
        return repository.find(authService.authenticated(), unreadOnly, pageable)
                         .map(NotificationDTO::new);
    }

}
