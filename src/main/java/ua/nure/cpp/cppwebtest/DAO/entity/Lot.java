package ua.nure.cpp.cppwebtest.DAO.entity;

public class Lot {
    int id;
    String name;
    String description;
    int starting_price;
    int seller_id;

    public Lot(int id, String name, String description, int starting_price, int seller_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.starting_price = starting_price;
        this.seller_id = seller_id;
    }

    public static Lot createLot(String name, String description, int starting_price){
        Lot p = new Lot();
        p.setName(name);
        p.setDescription(description);
        p.setStarting_price(starting_price);
        return p;
    }
    public Lot(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStarting_price() {
        return starting_price;
    }

    public void setStarting_price(int starting_price) {
        this.starting_price = starting_price;
    }
    public int getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }

    @Override
    public String toString() {
        return "Lot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", starting_price=" + starting_price +
                ", seller_id=" + seller_id +
                '}';
    }


}
