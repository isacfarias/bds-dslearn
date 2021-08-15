package com.farias.dslearnbds.service;


import com.farias.dslearnbds.dto.DeliverRevisionDTO;
import com.farias.dslearnbds.entities.Deliver;
import com.farias.dslearnbds.repositories.DeliverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.Delimiter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeliverService {

    @Autowired
    private DeliverRepository repository;


    @Transactional
    public void saveRevision(Long id, DeliverRevisionDTO deliverRevisionDTO) {
        var deliver = repository.getOne(id);
        deliver.setStatus(deliverRevisionDTO.getStatus());
        deliver.setFeedback(deliverRevisionDTO.getFeedback());
        deliver.setCorrectCount(deliverRevisionDTO.getCorrectCount());
        repository.save(deliver);
    }
}
