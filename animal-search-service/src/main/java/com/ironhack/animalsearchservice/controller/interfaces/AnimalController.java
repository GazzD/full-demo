package com.ironhack.animalsearchservice.controller.interfaces;

import com.ironhack.animalsearchservice.model.Animal;

import java.util.List;
import java.util.Optional;

public interface AnimalController {

    List<Animal> search(Optional<Integer> optionalAge, Optional<String> optionalType);

}
