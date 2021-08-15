package com.farias.dslearnbds.observer;

import com.farias.dslearnbds.entities.Deliver;

public interface DeliverRevisionObserver {

    void onSaveRevision(Deliver deliver);
}
