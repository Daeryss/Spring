package com.miftakhov.spring.dao;

import com.miftakhov.spring.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom", 12, "tom@mail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Jerry", 5, "jerry@gmail.mouse"));
        people.add(new Person(++PEOPLE_COUNT, "Mommy", 56, "mommy@yandex.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Kitty", 7, "kitty@kitty.com"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(final int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person person) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(person.getName());
        personToBeUpdated.setAge(person.getAge());
        personToBeUpdated.setEmail(person.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
