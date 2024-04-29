package personManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonDAOMySQL implements PersonDAO {
    public void addPersonToDatabase(Person person) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO Person (firstName, lastName, dateOfBirth, gender, address) VALUES (?, ?, ?, ?, ?)")) {
            statement.setString(1, person.getFirstName());
            statement.setString(2, person.getLastName());
            statement.setString(3, person.getDateOfBirth()); // Assuming getDateOfBirth returns a String
            statement.setString(4, String.valueOf(person.getGender()));
            statement.setString(5, String.valueOf(person.getAddress()));
            statement.executeUpdate();
            System.out.println("Statement executed");
        }
    }

    public void updatePersonInDatabase(int personId, Person updatedPerson) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE Person SET firstName=?, lastName=?, dateOfBirth=?, gender=?, address=? WHERE id=?")) {
            statement.setString(1, updatedPerson.getFirstName());
            statement.setString(2, updatedPerson.getLastName());
            statement.setString(3, updatedPerson.getDateOfBirth());
            statement.setString(4, String.valueOf(updatedPerson.getGender()));
            statement.setString(5, String.valueOf(updatedPerson.getAddress()));
            statement.setInt(6, personId);
            statement.executeUpdate();
            System.out.println("Statement executed");
        }
    }

    public void deletePersonFromDatabase(int personId) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "DELETE FROM Person WHERE id=?")) {
            statement.setInt(1, personId);
            statement.executeUpdate();
            System.out.println("Statement executed");
        }
    }
}
