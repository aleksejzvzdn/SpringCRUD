package com.aleksejzvzdn.gmail.dao;

import com.aleksejzvzdn.gmail.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "James", 25, "james25@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Helen", 26, "helen26@yandex.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Andrew", 31, "andrew31@yahoo.com"));
        people.add(new Person(++PEOPLE_COUNT, "John", 28, "johnhaha@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Hillary", 65, "firstwoman@whitehouse.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
