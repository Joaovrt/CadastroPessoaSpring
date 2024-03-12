package com.formulario.formulario.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.formulario.formulario.model.Person;

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

    public List<Person> findAll(){

        logger.info("Finding all...");

        List<Person> people = new ArrayList<>();
        for (int i = 0; i<8; i++){
            Person person = mockPerson(i);
            people.add(person);
        }
        return people;
    }

    private Person mockPerson(int i){
         Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Name "+i);
        person.setLastName("Last "+i);
        person.setAddress("Address "+i);
        person.setGender("Gender "+i);
        return person;
    }

    public Person create (Person person){

        logger.info("Creating person");
        return person;
    }

    public Person update (Person person){

        logger.info("Updating person");
        return person;
    }

    public void delete (String id){

        logger.info("Deleting person");
    }
}   
