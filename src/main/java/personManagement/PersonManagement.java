package personManagement;

import java.util.HashMap;
import java.util.Map;

public class PersonManagement {
    private Map<Integer, Person> personMap;

    public PersonManagement() {
        this.personMap = new HashMap<>();
    }

    private int getNextID() {
        return personMap.size();
    }

    public Person createPerson(String firstName, String lastName, String dateOfBirth, Address address, Gender gender) throws InvalidPersonException, InvalidPersonNameException {
        if (firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty()) {
            throw new InvalidPersonException(" First name and last name cannot be empty");
        }

        if (containsDigit(firstName) || containsDigit(lastName)) {
            throw new InvalidPersonNameException(" First name and last name cannot contain digits");
        }

        Person person = new Person(getNextID(), firstName, lastName, dateOfBirth, address, gender);
        personMap.put(person.getID(), person);
        return person;

    }

    private boolean containsDigit(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public void updatePerson(int id, String firstName, String lastName, String dateOfBirth, Address address, Gender gender) throws InvalidIdException {
        if (!personMap.containsKey(id)) {
            throw new InvalidIdException(" Invalid ID for updating");
        }

        Person person = personMap.get(id);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setDateOfBirth(dateOfBirth);
        person.setAddress(address);
        person.setGender(gender);
    }

    public void deletePerson(int id) throws InvalidIdException {
        if (!personMap.containsKey(id)) {
            throw new InvalidIdException(" Invalid ID for deletion");
        }

        personMap.remove(id);
    }

    public void displayPersons() {
        for (Person person : personMap.values()) {
            System.out.println(person);
        }
    }

    public Person findPersonByName(String firstName, String lastName) throws PersonNotFoundException {
        if (firstName == null || lastName == null) {
            throw new NullPointerException("First name and last name cannot be null");
        }

        for (Person person : personMap.values()) {
            if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
                return person;
            }
        }
        throw new PersonNotFoundException("Person with name " + firstName + " " + lastName + " not found");
    }
}