package com.ironhack.adopterservice.controller.impl;

import com.ironhack.adopterservice.controller.interfaces.AdopterController;
import com.ironhack.adopterservice.model.Adopter;
import com.ironhack.adopterservice.repository.AdopterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdopterControllerImpl implements AdopterController {

    @Autowired
    private AdopterRepository adopterRepository;

    @PostMapping("/adopters")
    @ResponseStatus(HttpStatus.CREATED)
    public Adopter store(@RequestBody Adopter adopter) {
        return adopterRepository.save(adopter);
    }
}
