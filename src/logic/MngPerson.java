package logic;

import connection.DAO;
import connection.JsonRead;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MngPerson {
    DAO dao = new DAO();
    JsonRead jsonRead = new JsonRead();
    private ArrayList<Person> persons = new ArrayList<>();
    private ArrayList<PersonSalary> salaries = new ArrayList<>();
    public boolean readPerson() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        jsonRead.readFile();
        salaries = jsonRead.getSalaries();
        try {
            ResultSet rs = dao.getPersons();
            if(rs != null){
                while (rs.next()){
                    String document = rs.getString("document");
                    String typeDocument = rs.getString("type_document");
                    String name = rs.getString("name");
                    String lastname = rs.getString("lastname");
                    String birthday = rs.getString("birthdate");
                    persons.add(new Person(document, typeDocument, name, lastname, birthday, getSalary(document)));
                }
                rs.close();
                return true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Person> getPersons(){
        return (ArrayList<Person>) persons.clone();
    }

    public Person findPerson(String document){
        for(Person person : persons){
            if(person.getDocument().equals(document)){
                return person;
            }
        }
        return null;
    }

    public String getSalary(String document){
        String salary = "";
        for (PersonSalary ps : salaries){
            if(document.replace(" ", "").equals(ps.getDocument())){

                return ps.getSalary();
            }
        }
        return"No";
    }
}
