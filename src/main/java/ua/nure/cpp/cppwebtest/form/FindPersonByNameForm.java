package ua.nure.cpp.cppwebtest.form;

public class FindPersonByNameForm {
    private String nameOfPerson;

    public FindPersonByNameForm() {
    }

    public FindPersonByNameForm(String nameOfPerson) {
        this.nameOfPerson = nameOfPerson;
    }


    public String getNameOfPerson() {
        return nameOfPerson;
    }

    public void setNameOfPerson(String nameOfPerson) {
        this.nameOfPerson = nameOfPerson;
    }
}
