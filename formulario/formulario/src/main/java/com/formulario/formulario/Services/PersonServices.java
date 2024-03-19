package com.formulario.formulario.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import java.util.logging.Logger;

import org.aspectj.weaver.patterns.PerSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.formulario.formulario.model.Person;
import com.formulario.formulario.repositories.PersonRepository;

@Service
public class PersonServices {
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public Person findById(Long id){

        logger.info("Finding person...");
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this id"));
    }

    public List<Person> findAll(){

        logger.info("Finding all...");

       return repository.findAll();
    }
    
    public Person create (Person person){

        logger.info("Creating person");
        return repository.save(person);
    }

    public Person update (Person person){
        var entity = repository.findById(person.getId()).orElseThrow(()-> new ResourceNotFoundException("No records found for this id"));
      
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        logger.info("Updating person");
        return repository.save(person);
    }

    public void delete (Long id){
        var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this id"));
        repository.delete(entity);
        logger.info("Deleting person");
    }
}   
