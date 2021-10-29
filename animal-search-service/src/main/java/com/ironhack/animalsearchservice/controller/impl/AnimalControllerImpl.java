package com.ironhack.animalsearchservice.controller.impl;

import com.ironhack.animalsearchservice.controller.interfaces.AnimalController;
import com.ironhack.animalsearchservice.model.Animal;
import com.ironhack.animalsearchservice.repository.AnimalRepository;
import com.ironhack.animalsearchservice.service.interfaces.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AnimalControllerImpl implements AnimalController {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping("/animals")
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> search(@RequestParam("age") Optional<Integer> optionalAge, @RequestParam("type") Optional<String> optionalType) {
        if(optionalAge.isPresent() && optionalType.isPresent())
            return animalRepository.findByAgeAndType(optionalAge.get(), optionalType.get());
        if(optionalAge.isPresent() && !optionalType.isPresent())
            return animalRepository.findByAge(optionalAge.get());
        if(!optionalAge.isPresent() && optionalType.isPresent())
            return animalRepository.findByType(optionalType.get());

        return animalRepository.findAll();
    }

    @GetMapping("/test")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/animalss")
    public List<Animal> findAll() {
        return animalRepository.findAll();
    }


    @PostMapping("/animals")
    @ResponseStatus(HttpStatus.CREATED)
    public Animal store(@RequestBody Animal animal) {
        return animalRepository.save(animal);
    }
}
