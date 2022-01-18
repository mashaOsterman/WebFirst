package ua.nure.cpp.cppwebtest.DAO.entity;

import java.util.Date;

public class ContractOfSale {
    int id;
    int price;
    Date date_contract;

    int buyer_id;

    public static ContractOfSale createPerson(int price, Date date_contract, int buyer_id){
        ContractOfSale p = new ContractOfSale();
        p.setDate_contract(date_contract);
        p.setBuyer_id(buyer_id);
        return p;
    }
    public ContractOfSale(){}
    public ContractOfSale(int id, int price, Date date_contract, int buyer_id) {
        this.id = id;
        this.price = price;
        this.date_contract = date_contract;
        this.buyer_id = buyer_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDate_contract() {
        return date_contract;
    }

    public void setDate_contract(Date date_contract) {
        this.date_contract = date_contract;
    }


    public int getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(int buyer_id) {
        this.buyer_id = buyer_id;
    }

    @Override
    public String toString() {
        return "Contract_of_sale{" +
                "id=" + id +
                ", price=" + price +
                ", date_contract=" + date_contract +
                ", buyer_id=" + buyer_id +
                '}';
    }
}
