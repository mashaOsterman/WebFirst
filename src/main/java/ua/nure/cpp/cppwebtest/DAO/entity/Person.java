package ua.nure.cpp.cppwebtest.DAO.entity;

public class Person {
    private int id;
    private String first_name;
    private String second_name;
    private String address;
    private String phone_number;
    private String settlement_account;

    public static Person createPerson(String first_name, String second_name, String adress, String phone_number, String settlement_account){
        Person p = new Person();
        p.setFirst_name(first_name);
        p.setSecond_name(second_name);
        p.setAddress(adress);
        p.setPhone_number(phone_number);
        p.setSettlement_account(settlement_account);
        return p;
    }
    public Person(){
        //default
    }
    public Person( String first_name, String second_name, String adress,  String phone_number, String settlement_account) {
        //this.id = id;
        this.first_name = first_name;
        this.second_name = second_name;
        this.address =  adress;
        this.phone_number = phone_number;
        this.settlement_account = settlement_account;
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getSettlement_account() {
        return settlement_account;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setSettlement_account(String settlement_account) {
        this.settlement_account = settlement_account;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", second_name='" + second_name + '\'' +
                ", address='" + address + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", settlement_account='" + settlement_account + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }
}
