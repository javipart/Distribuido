package logic;

public class PersonSalary {
    private String document;
    private String salary;

    public PersonSalary(){

    }

    public PersonSalary(String document, String salary){
        this.document = document;
        this.salary = salary;
    }

    public String getSalary() {
        return salary;
    }

    public String getDocument() {
        return document;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
