package ua.nure.cpp.cppwebtest.form;

public class DeletePersonForm {
    private String name;
    public DeletePersonForm() {
        // default
    }

    public DeletePersonForm(String Name) {
        this.name = Name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
