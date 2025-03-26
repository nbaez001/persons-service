package com.empresa.proyecto.persons.controller;

import com.empresa.proyecto.persons.dto.PersonDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonsApiImpl {

    @GetMapping("/persons")
    public ResponseEntity<List<PersonDto>> listPerson() {
        List<PersonDto> list = List.of(
                new PersonDto(1, "NERIO", "BAEZ DELGADO", 28));
        return ResponseEntity.status(200).body(list);
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<PersonDto> getPerson(@PathVariable(name = "id") Integer id) {
        PersonDto per = new PersonDto(1, "NERIO", "BAEZ DELGADO", 28);
        return ResponseEntity.status(200).body(per);
    }
}
