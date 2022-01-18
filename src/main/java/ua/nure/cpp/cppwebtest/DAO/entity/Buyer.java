package ua.nure.cpp.cppwebtest.DAO.entity;

public class Buyer {
    int id;
    String solvency;
    int person_id;

    public static Buyer createPerson(String solvency, int person_id){
        Buyer p = new Buyer();
        p.setSolvency(solvency);
        p.setPerson_id(person_id);
        return p;
    }
    public Buyer(){}
    public Buyer(int id, String solvency, int person_id) {
        this.id = id;
        this.solvency = solvency;
        this.person_id = person_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSolvency() {
        return solvency;
    }

    public void setSolvency(String solvency) {
        this.solvency = solvency;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", solvency='" + solvency + '\'' +
                ", person_id=" + person_id +
                '}';
    }
}
