package br.com.shima;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class RegisterPersonTest {

    public void shouldCreatePersonsRegister() {
        PersonRegister register = new PersonRegister();

        Assertions.assertThat(register.getPersons()).isEmpty();
    }

    @Test
    public void shouldAddAPerson() {
        PersonRegister personRegister = new PersonRegister();
        Person person = new Person();
        person.setName("Victor");

        personRegister.register(person);

        Assertions.assertThat(personRegister.getPersons())
                .isNotEmpty()
                .hasSize(1)
                .contains(person);
    }

    @Test(expected = PersonWithEemptyNameExpection.class)
    public void shouldNotAddAPersonWithEmptyName() {
        PersonRegister personRegister = new PersonRegister();
        Person person = new Person();

        personRegister.register(person);

    }

    @Test
    public void shouldRemoveAPerson() {
        PersonRegister personRegister = new PersonRegister();
        Person person = new Person();
        person.setName("Victor");
        personRegister.register(person);

        personRegister.remove(person);

        Assertions.assertThat(personRegister.getPersons()).isEmpty();
     }

     @Test(expected = EmptyRegisterException.class)
    public void shoudThrowErrorTryingToRemoveAnUnexistentPerson () {
        Person person = new Person();
        PersonRegister personRegister = new PersonRegister();

        personRegister.remove(person);

     }
}
