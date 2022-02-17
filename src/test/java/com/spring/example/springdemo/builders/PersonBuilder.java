package com.spring.example.springdemo.builders;

import com.spring.example.springdemo.dto.Persondto;

import java.util.Map;

public class PersonBuilder {
    public Persondto Build(Map<String,String> parameters)
    {
        Persondto person = new Persondto();

        if(parameters.get("firstname") != null){person.setFirstname(parameters.get("firstname"));}
        if(parameters.get("lastname") !=null){person.setLastname(parameters.get("lastname"));}

        return person;
    }
}
