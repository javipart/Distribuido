package logic;

public class Person {
    private String document;
    private String typeDocument;
    private String name;
    private String lastname;
    private String birthdate;
    private String salary;

    public String getDocument() {
        return document;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getSalary() {
        return salary;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Person(String document, String typeDocument, String name, String lastname, String birthdate, String salary) {
        this.document = document;
        this.typeDocument = typeDocument;
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.salary = salary;
    }

    public Person(){

    }
}
