package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.controller.dto.Animal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@FeignClient("animal-search-service")
public interface AnimalSearchClient {

    @GetMapping("/animals")
    List<Animal> search(@RequestParam("age") Integer age, @RequestParam("type") String type);

    @GetMapping("/animalss")
    List<Animal> findAll();

    @GetMapping("/test")
    String testCall();
}
