package com.watsonxyz.kd.generator;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.watsonxyz.kd.model.Person;
import com.watsonxyz.kd.repository.PersonRepository;
import io.bloco.faker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@SpringComponent
public class PersonsGenerator {
    @Bean
    public CommandLineRunner loadSampleData(PersonRepository personRepository){
        return args -> {
            Logger logger = LoggerFactory.getLogger(getClass());
            if(personRepository.count() != 0){
                logger.info("Using Existing Database");
                return;
            }
            int seed = 123;
            logger.info("Generating Persons Data");
            List<Person> persons = createSamplePersonsList();
            personRepository.saveAll(persons);
            logger.info("Generated Sample Person Data");

        };
    }
    public List<Person> createSamplePersonsList(){

        List<Person> personList = new ArrayList();
        int random = new Random().nextInt(100) + 10 ;

        for(int i = 0; i < ( random ); i++){
            Person randomPerson = createSamplePerson();
            personList.add(randomPerson);
        }
        return personList;
    }
    public Person createSamplePerson(){
        Faker faker = new Faker();
        Person samplePerson = new Person();
        samplePerson.setFirstName(faker.name.firstName());
        samplePerson.setLastName(faker.name.lastName());
        samplePerson.setEmail(faker.internet.email());
        return samplePerson;
    }
}
