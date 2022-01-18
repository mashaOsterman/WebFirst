package ua.nure.cpp.cppwebtest.DAO.mysql;

public abstract class DBconstants {

    public static final String FROM_PERSON = "SELECT * FROM person p ORDER BY p.first_name;";
    public static final String FROM_SEllER = "SELECT * FROM Seller p ORDER BY p.id;";
    public static final String FIND_BY_NAME = "select * from person where first_name like ? order by first_name;";
    public static final String INSERT_INTO_PERSON = "insert into person (first_name, second_name, address,  phone_number,  settlement_account) values ( ?, ?, ?, ?, ?);";
    public static final String INSERT_INTO_BUYER = "insert into buyer(solvency, person_id) values (?, ?)";
    public static final String DELETE_PERSON_BY_ID = "DELETE FROM person WHERE id = ?;";

    public static final String DELETE_PERSON_BY_FIRST_NAME = "DELETE FROM person WHERE first_name = ?;";
    public static final String INSERT_INTO_LOT = "insert into lot(lot_name, description, starting_price, seller_id) values(?, ?, ?, ?)";

    private DBconstants() {
    }

}
