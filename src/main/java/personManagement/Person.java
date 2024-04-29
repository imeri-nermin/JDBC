package personManagement;

public class Person {
    private final int id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private Address address;
    private Gender gender;

    public Person(int id, String firstName, String lastName, String dateOfBirth, Address address, Gender gender) {
        this.id = id;
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setDateOfBirth(dateOfBirth);
        this.setAddress(address);
        this.setGender(gender);
    }

    public Person(int id, String firstName, String lastName) {
        this(id, firstName, lastName, null, null, null);
    }

    public Person(int id, String firstName, String lastName, Gender gender, String dateOfBirth) {
        this(id, firstName, lastName, dateOfBirth, null, gender);
    }

    public int getID() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + firstName + " " + lastName +
                ", Gender: " + (gender == null ? "not available" : gender) +
                ", Date of Birth: " + (dateOfBirth == null ? "not available" : dateOfBirth) +
                ", Address: " + (address == null ? "not available" : address);
    }
}
