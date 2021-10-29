package com.ironhack.animalsearchservice.repository;

import com.ironhack.animalsearchservice.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findByAgeAndType(int age, String type);
    List<Animal> findByAge(int age);
    List<Animal> findByType(String type);


}
