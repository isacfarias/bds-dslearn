package com.farias.dslearnbds.resources;


import com.farias.dslearnbds.dto.DeliverRevisionDTO;
import com.farias.dslearnbds.service.DeliverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/deliveries")
public class DeliverResource {

    @Autowired
    private DeliverService service;

    @PreAuthorize("hasAnyRole('ADMIM', 'INSTRUCTOR')")
    @PutMapping("/{id}")
    public ResponseEntity<Void> saveRevision(@PathVariable Long id, @RequestBody DeliverRevisionDTO revisionDTO) {
        service.saveRevision(id, revisionDTO);
        return ResponseEntity.noContent().build();
    }


}
