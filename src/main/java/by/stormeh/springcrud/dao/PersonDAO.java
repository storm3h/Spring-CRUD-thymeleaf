package by.stormeh.springcrud.dao;

import by.stormeh.springcrud.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private static int peopleCount;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++peopleCount, "Katya"));
        people.add(new Person(++peopleCount, "Sasha"));
        people.add(new Person(++peopleCount, "Masha"));
    }
    public List<Person> index() {
        return people;
    }
    public Person show(int id) {

        return people.stream().filter(people -> people.getId()==id).findAny().orElse(null);
    }
    public void save(Person person) {
        person.setId(++peopleCount);
        people.add(person);
    }
    public void update(int id, Person updatedPerson) {
    Person personToBeUpdated = show(id);
    personToBeUpdated.setName(updatedPerson.getName());
    }
    public void delete(int id) {
        people.removeIf(person -> person.getId()==id);
    }
}
