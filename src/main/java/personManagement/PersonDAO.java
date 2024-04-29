package personManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PersonDAO {
    public void addPersonToDatabase(Person person) throws SQLException;

    public void updatePersonInDatabase(int personId, Person updatedPerson) throws SQLException;

    public void deletePersonFromDatabase(int personId) throws SQLException;
}
