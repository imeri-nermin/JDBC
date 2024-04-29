package personManagement;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        PersonManagement pv = new PersonManagement();

        try {
            Person markus = pv.createPerson("Markus", "Berger", "01.01.1990", null, Gender.MALE);
            Person julia = pv.createPerson("Julia", "Berger", "15-05-1990", null, Gender.FEMALE);
            PersonDAO personDAO = new PersonDAOMySQL();
            personDAO.addPersonToDatabase(julia);

            Person stefan = pv.createPerson("Stefan", "Schwarz", "20.02.1985", new Address("4030", "Linz", "", ""), Gender.MALE);
            personDAO.addPersonToDatabase(stefan);

            System.out.println("Initial Persons:");
            pv.displayPersons();

            pv.updatePerson(julia.getID(), "Julia", "Weiss", "25.08.1992", null, Gender.FEMALE);
            personDAO.updatePersonInDatabase(julia.getID(), julia);

            pv.deletePerson(markus.getID());
            personDAO.deletePersonFromDatabase(markus.getID());

        } catch (InvalidPersonException | InvalidIdException | InvalidPersonNameException e) {
            System.out.println("Error: " + e.getMessage());
            } catch (NullPointerException e) {
                 System.out.println("Error: " + e.getMessage());
                 e.printStackTrace();
             } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nFinal Persons:");
        pv.displayPersons();
    }
}