package com.farias.dslearnbds.dto;

import com.farias.dslearnbds.entities.Notification;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class NotificationDTO implements Serializable {

    private Long id;
    private String text;
    private Instant moment;
    private boolean read;
    private String route;
    private Long userId;

    public NotificationDTO() {}

    public NotificationDTO(Notification notification) {
        this.id = notification.getId();
        this.text = notification.getText();
        this.moment = notification.getMoment();
        this.read = notification.isRead();
        this.route = notification.getRoute();
        this.userId = notification.getUser().getId();
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Instant getMoment() {
        return moment;
    }

    public boolean isRead() {
        return read;
    }

    public String getRoute() {
        return route;
    }

    public Long getUserId() {
        return userId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationDTO that = (NotificationDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
