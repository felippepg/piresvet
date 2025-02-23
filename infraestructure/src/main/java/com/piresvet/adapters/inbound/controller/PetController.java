package com.piresvet.adapters.inbound.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pets")
@RequiredArgsConstructor
public class PetController {
    public ResponseEntity<?> create() {
        return null;
    }

    public ResponseEntity<?> findById() {
        return null;
    }

    public ResponseEntity<?> findAll() {
        return null;
    }

    public ResponseEntity<?> update() {
        return null;
    }

    public void delete(){
        //
    }

}
