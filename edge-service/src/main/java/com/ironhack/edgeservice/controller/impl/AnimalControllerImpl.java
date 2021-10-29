package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.client.AnimalSearchClient;
import com.ironhack.edgeservice.controller.dto.Animal;
import com.ironhack.edgeservice.controller.interfaces.AnimalController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(value = "*")
public class AnimalControllerImpl implements AnimalController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AnimalControllerImpl.class);

    @Autowired
    private AnimalSearchClient animalSearchClient;

    @GetMapping("/animals")
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> search(@RequestParam("age") Optional<Integer> optionalAge, @RequestParam("type") Optional<String> optionalType) {
        Integer age = optionalAge.isPresent() ? optionalAge.get(): null;
        String type = optionalType.isPresent() ? optionalType.get(): null;

        return animalSearchClient.search(age, type);
    }

    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public String testCall() {
        return animalSearchClient.testCall();
    }
}
