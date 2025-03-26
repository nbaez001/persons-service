package com.empresa.proyecto.persons.controller;

import com.empresa.proyecto.persons.dto.PersonDto;
import com.empresa.proyecto.persons.resource.PersonsApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PersonsApiImpl implements PersonsApi {

    @Override
    public ResponseEntity<PersonDto> createPerson(@RequestBody PersonDto personDto) {
        PersonDto createdPerson = new PersonDto()
                .id(1)
                .firstName("NERIO")
                .lastName("BAEZ DELGADO")
                .age(28);
        return ResponseEntity.status(201).body(createdPerson);
    }

    @Override
    public ResponseEntity<Void> deletePerson(@PathVariable("id") Integer id) {
        boolean deleted = true;
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<List<PersonDto>> getAllPersons() {
        List<PersonDto> persons = new ArrayList<>();
        persons.add(
                new PersonDto()
                        .id(1)
                        .firstName("NERIO")
                        .lastName("BAEZ DELGADO")
                        .age(28));
        return ResponseEntity.ok(persons);
    }

    @Override
    public ResponseEntity<PersonDto> getPersonById(@PathVariable("id") Integer id) {
        return Optional.of(new PersonDto()
                        .id(1)
                        .firstName("NERIO")
                        .lastName("BAEZ DELGADO")
                        .age(28)
                )
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<PersonDto> updatePerson(@PathVariable("id") Integer id, @RequestBody PersonDto personDto) {
        return Optional.of(new PersonDto()
                        .id(1)
                        .firstName("NERIO")
                        .lastName("BAEZ DELGADO")
                        .age(28)
                )
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
