package com.calculadora.calculadora.Services;

import java.util.concurrent.atomic.AtomicLong;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.calculadora.calculadora.model.Person;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id){

        logger.info("Finding person...");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("João");
        person.setLastName("Victor");
        person.setAddress("Rua");
        person.setGender("Male");
        return person;
    }
}   
