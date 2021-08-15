package com.farias.dslearnbds.service;


import com.farias.dslearnbds.dto.DeliverRevisionDTO;
import com.farias.dslearnbds.observer.DeliverRevisionObserver;
import com.farias.dslearnbds.repositories.DeliverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class DeliverService {

    @Autowired
    private DeliverRepository repository;
    private final Set<DeliverRevisionObserver> deliverRevisionObserver = new LinkedHashSet<>();

    @Transactional
    public void saveRevision(Long id, DeliverRevisionDTO deliverRevisionDTO) {
        var deliver = repository.getOne(id);
        deliver.setStatus(deliverRevisionDTO.getStatus());
        deliver.setFeedback(deliverRevisionDTO.getFeedback());
        deliver.setCorrectCount(deliverRevisionDTO.getCorrectCount());
        repository.save(deliver);
        deliverRevisionObserver.forEach(x -> x.onSaveRevision(deliver));
    }

    public void subscribeDeliverRevisionObserver(DeliverRevisionObserver observer) {
        deliverRevisionObserver.add(observer);
    }
}
