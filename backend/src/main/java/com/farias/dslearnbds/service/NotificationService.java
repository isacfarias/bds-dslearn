package com.farias.dslearnbds.service;

import com.farias.dslearnbds.dto.NotificationDTO;
import com.farias.dslearnbds.entities.Deliver;
import com.farias.dslearnbds.entities.Notification;
import com.farias.dslearnbds.entities.User;
import com.farias.dslearnbds.observer.DeliverRevisionObserver;
import com.farias.dslearnbds.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.Instant;

@Service
public class NotificationService implements DeliverRevisionObserver {

    @Autowired
    private NotificationRepository repository;

    @Autowired
    private AuthService authService;

    @Autowired
    private DeliverService deliverService;

    @PostConstruct
    private void initialize() {
        deliverService.subscribeDeliverRevisionObserver(this);
    }

    @Transactional(readOnly = true)
    public Page<NotificationDTO> notificationsForCurrentUser(boolean unreadOnly, Pageable pageable) {
        return repository.find(authService.authenticated(), unreadOnly, pageable)
                         .map(NotificationDTO::new);
    }

    @Transactional
    public void saveDeliverNotification(Deliver deliver) {
        final var sectionId = deliver.getLesson().getSection().getId();
        final var resourceId = deliver.getLesson().getSection().getResource().getId();
        final var offerId = deliver.getLesson().getSection().getResource().getOffer().getId();

        final var route = "/offers/"+offerId+"/resources/"+resourceId+"/sections/"+sectionId;
        final var text = deliver.getFeedback();
        final var moment = Instant.now();
        final var user = deliver.getEnrollment().getStudent();

        var notification = new Notification(null, text, moment, false, route, user);
        repository.save(notification);
    }

    @Override
    public void onSaveRevision(Deliver deliver) {
        saveDeliverNotification(deliver);
    }
}
