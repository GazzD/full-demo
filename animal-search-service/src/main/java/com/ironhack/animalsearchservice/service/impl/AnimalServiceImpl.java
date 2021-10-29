package com.ironhack.animalsearchservice.service.impl;

import com.ironhack.animalsearchservice.repository.AnimalRepository;
import com.ironhack.animalsearchservice.service.interfaces.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalServiceImpl implements AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

}
