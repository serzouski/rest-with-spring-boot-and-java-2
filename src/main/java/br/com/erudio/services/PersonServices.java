package br.com.erudio.services;

import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {
        logger.info("Finding all people!");
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 8 ; i++) {
            Person person = mockPerson(i);
            people.add(person);

        }
        return people;
    }


    public Person findById(String id) {

        logger.info("Finding one person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Alexandre");
        person.setLastName("Serzouski");
        person.setAddress("Ponta Grossa");
        person.setGender("Male");
        return person;
    }

    public Person create(Person person) {
        logger.info("Creating one person!");

        return person;
    }
    public Person update(Person person) {
        logger.info("Updating one person!");

        return person;
    }
    public void delete(String id) {
        logger.info("Deleting one person!");

    }
    private Person mockPerson(int i) {

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + (i+1));
        person.setLastName("Last name " + (i+1));
        person.setAddress("Some address in Brazil " + (i+1));
        person.setGender("Male");
        return person;
    }
}
