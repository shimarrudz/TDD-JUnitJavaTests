package br.com.shima;
import java.util.ArrayList;
import java.util.List;

public class PersonRegister {
    private List<Person> persons;

    public PersonRegister() {
        this.persons = new ArrayList<>();
    }

    public List<Person> getPersons() {
        return this.persons;
    }

    public void register(Person person) {
        if(person.getName() == null) {
            throw new PersonWithEemptyNameExpection();
        }
        this.persons.add(person);
    }

    public void remove(Person person) {
        if (this.persons.isEmpty()) {
            throw new EmptyRegisterException();
        }
        this.persons.remove(person);
    }
}
