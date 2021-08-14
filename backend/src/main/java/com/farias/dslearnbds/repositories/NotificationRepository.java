package com.farias.dslearnbds.repositories;

import com.farias.dslearnbds.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.farias.dslearnbds.entities.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    @Query("SELECT n FROM Notification n WHERE "
            + "(n.user = :user ) "
            + "AND ( :unreadOnly = false or  n.read = false) "
            + "ORDER BY n.moment DESC"
    )
    Page<Notification> find(User user, boolean unreadOnly, Pageable pageable);

}
