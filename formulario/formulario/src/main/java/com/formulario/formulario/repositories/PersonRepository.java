package com.formulario.formulario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formulario.formulario.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
