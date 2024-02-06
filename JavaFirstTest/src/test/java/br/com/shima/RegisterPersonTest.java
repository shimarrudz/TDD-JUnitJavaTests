package br.com.shima;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class RegisterPersonTest {

    public void shouldCreatePersonsRegister() {
        PersonRegister register = new PersonRegister();

        Assertions.assertThat(register.getPersons()).isEmpty();
    }

    @Test
    @DisplayName("Should create person register")
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

    @Test
    @DisplayName("Should add person register")
    public void shouldNotAddAPersonWithEmptyName() {
        final PersonRegister personRegister = new PersonRegister();
        Person person = new Person();

        org.junit.jupiter.api.Assertions
                        .assertThrows(PersonWithEemptyNameExpection.class, () -> personRegister.register(person));

        personRegister.register(person);

    }

    @Test
    @DisplayName("Should remove person register")
    public void shouldRemoveAPerson() {
        PersonRegister personRegister = new PersonRegister();
        Person person = new Person();
        person.setName("Victor");
        personRegister.register(person);

        personRegister.remove(person);

        Assertions.assertThat(personRegister.getPersons()).isEmpty();
     }

     @Test
     @DisplayName("Should throw an erro removing unexistent person")
    public void shoudThrowErrorTryingToRemoveAnUnexistentPerson () {
        Person person = new Person();
        PersonRegister personRegister = new PersonRegister();

        personRegister.remove(person);

     }
}
