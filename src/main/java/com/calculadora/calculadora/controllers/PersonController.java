package com.calculadora.calculadora.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.calculadora.calculadora.Services.PersonServices;
import com.calculadora.calculadora.exceptions.UnsupportedMathOperationException;
import com.calculadora.calculadora.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;

    @RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable(value = "id") String id){
        return service.findById(id);
    }
}