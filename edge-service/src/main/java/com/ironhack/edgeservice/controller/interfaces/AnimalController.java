package com.ironhack.edgeservice.controller.interfaces;

import com.ironhack.edgeservice.controller.dto.Animal;

import java.util.List;
import java.util.Optional;

public interface AnimalController {
    List<Animal> search(Optional<Integer> optionalAge, Optional<String> optionalType);
}
