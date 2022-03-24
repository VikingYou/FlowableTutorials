package com.example.flowableexample.repository;

import com.example.flowableexample.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByUsername(String username);
}
