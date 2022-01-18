package ua.nure.cpp.cppwebtest.DAO.entity;

public class Seller {
    int id;
    String ownership;
    int person_id;

    public static Seller createSeller(String ownership, int person_id){
        Seller p = new Seller();
        p.setOwnership(ownership);
        p.setPerson_id(person_id);
        return p;
    }
    public Seller(){

    }
    public Seller(int id, String ownership, int person_id) {
        this.id = id;
        this.ownership = ownership;
        this.person_id = person_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", ownership='" + ownership + '\'' +
                ", person_id=" + person_id +
                '}';
    }
}
