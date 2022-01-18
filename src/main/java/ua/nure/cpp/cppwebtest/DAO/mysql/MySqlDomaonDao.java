package ua.nure.cpp.cppwebtest.DAO.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.nure.cpp.cppwebtest.DAO.DAOConfig;
import ua.nure.cpp.cppwebtest.DAO.DomaonDao;
import ua.nure.cpp.cppwebtest.DAO.entity.Buyer;
import ua.nure.cpp.cppwebtest.DAO.entity.Lot;
import ua.nure.cpp.cppwebtest.DAO.entity.Person;
import ua.nure.cpp.cppwebtest.DAO.entity.Seller;

import java.sql.*;
import java.util.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@Repository
public class MySqlDomaonDao implements DomaonDao {
    private static final String URL = "jdbc:mysql://localhost:3306/course_work";
    private static final String USER = "root";
    private static final String PASSWORD = "11017811";
    private static final String FULLURL = URL + "?" + "user=" + USER + "&password=" + PASSWORD;

    //private final String url ;
   // private final Properties dbProps = new Properties();


   //@Autowired
    /*public MySqlDomaonDao(DAOConfig config) {
        url = config.getUrl();
        dbProps.setProperty("user", config.getUser());
        dbProps.setProperty("password", config.getPassword());
    }*/

    public static MySqlDomaonDao getInstance(){
        return new MySqlDomaonDao();
    }

    public Connection getConnection() throws SQLException {
        // return DriverManager.getConnection(URL, conProps);
        return getConnection(true);
    }

    public  Connection getConnection(boolean autocommit) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        connection.setAutoCommit(autocommit);
        if (!autocommit){
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        }
        return connection;
    }
    @Override
    public List<Person> getAllPersons() throws SQLException {
        List<Person> persons = new ArrayList<>();
        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(DBconstants.FROM_PERSON)) {
            while (rs.next()) {
                persons.add(mapPerson(rs));
            }

        } catch (SQLException e) {
            //log
            e.printStackTrace();
            throw e;
        }

        return persons;
    }
    @Override
    public List<Seller> getAllSellers() throws SQLException {
        List<Seller> seller = new ArrayList<>();
        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(DBconstants.FROM_SEllER)) {
            while (rs.next()) {
                seller.add(mapSeller(rs));
            }

        } catch (SQLException e) {
            //log
            e.printStackTrace();
            throw e;
        }
        return seller;
    }
    @Override
    public List<Buyer> getAllBuyer() throws SQLException{
        List<Buyer> buyer = new ArrayList<>();
        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(DBconstants.FROM_SEllER)) {
            while (rs.next()) {
                buyer.add(mapBuyer(rs));
            }

        } catch (SQLException e) {
            //log
            e.printStackTrace();
            throw e;
        }
        return buyer;
    }
    @Override
    public List<Person> findPersonsbyName(String pattern) throws SQLException {
        List<Person> persons = new ArrayList<>();
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(DBconstants.FIND_BY_NAME);) {
            int k = 1;
            stmt.setString(k++, "%" + escapeForLike(pattern) + "%");
            try (ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {
                    persons.add(mapPerson(rs));
                }
            } catch (SQLException e) {
                //log
                e.printStackTrace();
                throw e;
            }
        } catch (SQLException e) {
            //log
            e.printStackTrace();
            throw e;
        }
        return persons;
    }

    @Override
    public void addNewPerson(Person newPers) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = getConnection();
            stmt = con.prepareStatement(DBconstants.INSERT_INTO_PERSON);
            int k = 0;
            stmt.setString(++k, newPers.getFirst_name());
            stmt.setString(++k, newPers.getSecond_name());
            stmt.setString(++k, newPers.getAddress());
            stmt.setString(++k, newPers.getPhone_number());
            stmt.setString(++k, newPers.getSettlement_account());
            int count = stmt.executeUpdate();
            //stmt.executeUpdate();

        } catch (SQLException e) {
            //log
            e.printStackTrace();
            throw e;
        } finally {
            close(con);
            close(stmt);
        }
    }

    static String escapeForLike(String param) {
        return param.replace("!", "!!").replace("%", "!%").replace("_", "!_");//  .replace("")
    }

    @Override
    public void deletePerson(int Pers_id) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = getConnection();
            stmt = con.prepareStatement(DBconstants.DELETE_PERSON_BY_ID);
            int k = 0;
            stmt.setInt(1, Pers_id);
            //int count = stmt.executeUpdate();
        } catch (SQLException e) {
            //log
            e.printStackTrace();
            throw e;
        } finally {
            close(con);
            close(stmt);
        }
    }
    @Override
    public void deletePerson(String first) throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con =getConnection();
            stmt = con.prepareStatement(DBconstants.DELETE_PERSON_BY_FIRST_NAME);
            int k = 0;
            stmt.setString(1, first);
            int count = stmt.executeUpdate();
        } catch (SQLException e) {
            //log
            e.printStackTrace();
            throw e;
        } finally {
            close(con);
            close(stmt);
        }
    }
    @Override
    public void addBuyer(Person newPers) {
        Buyer newBuyer = new Buyer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new Solvency:");
        newBuyer.setSolvency(scanner.nextLine());
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = getConnection();
            con.setAutoCommit(false);
            stmt = con.prepareStatement(DBconstants.INSERT_INTO_PERSON, Statement.RETURN_GENERATED_KEYS);
            int k = 0;
            stmt.setString(++k, newPers.getFirst_name());
            stmt.setString(++k, newPers.getSecond_name());
            stmt.setString(++k, newPers.getAddress());
            stmt.setString(++k, newPers.getPhone_number());
            stmt.setString(++k, newPers.getSettlement_account());
            int count = stmt.executeUpdate();
            if (count > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys();) {
                    if (rs.next()) {
                        stmt = con.prepareStatement(DBconstants.INSERT_INTO_BUYER);
                        k = 0;
                        stmt.setString(++k, newBuyer.getSolvency());
                        stmt.setInt(++k, rs.getInt(1));
                        stmt.executeUpdate();
                    }
                }
            }
            con.commit();
            //  stmt.executeUpdate();

        } catch (SQLException e) {
            //log
            e.printStackTrace();
            rollback(con);
            e.printStackTrace();
        } finally {
            close(con);
            close(stmt);
        }
    }

    @Override
    public void addLot(Lot newLot) throws SQLException {
        System.out.println("What do you want?\n"
                + "1. add a lot to an existing seller\n"
                + "2. create a new one?");
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            choice = scanner.nextInt();
        } while (choice != 1 && choice != 2);
        Seller seller = new Seller();
        int id = 0;
        Connection con = null;
        PreparedStatement stmt = null;
        con = getConnection();
        con.setAutoCommit(false);

        switch (choice) {
            case 1:
                System.out.println("Enter id of seller");
                id = scanner.nextInt();
                break;
            case 2:
                String ownership;
                //int person_id =
                //Seller createSeller()

                System.out.println("Enter the first name");
                String first_name = scanner.nextLine();
                System.out.println("Enter the first name");

                String second_name = scanner.nextLine();
                System.out.println("Enter the second name");

                String adress = scanner.nextLine();
                System.out.println("Enter the adress");

                String phone_number = scanner.nextLine();
                System.out.println("Enter the phone_number");

                String settlement_account = scanner.nextLine();
                System.out.println("Enter the settlement_account");
                Person newPers = Person.createPerson(first_name, second_name, adress, phone_number, settlement_account);

                try {
                    stmt = con.prepareStatement(DBconstants.INSERT_INTO_PERSON);
                    int k = 0;
                    stmt.setString(++k, newPers.getFirst_name());
                    stmt.setString(++k, newPers.getSecond_name());
                    stmt.setString(++k, newPers.getAddress());
                    stmt.setString(++k, newPers.getPhone_number());
                    stmt.setString(++k, newPers.getSettlement_account());
                    int count = stmt.executeUpdate();
                    stmt.executeUpdate();
                    if (count > 0) {
                        try (ResultSet rs = stmt.getGeneratedKeys();) {
                            id = rs.getInt(1);
                        }
                    }
                } catch (SQLException e) {
                    //log
                    rollback(con);
                    e.printStackTrace();
                    throw e;
                } finally {
                    close(con);
                    close(stmt);
                }
        }

        stmt = con.prepareStatement(DBconstants.INSERT_INTO_LOT);
        int k = 0;
        stmt.setString(++k, newLot.getName());
        stmt.setString(++k, newLot.getDescription());
        stmt.setInt(++k, newLot.getStarting_price());
        stmt.setInt(++k, id);
        if(stmt.executeUpdate()<=0){
            rollback(con);
        }
        con.commit();
    }

    private void rollback(Connection con) {
        try {
            con.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void close(AutoCloseable con) {
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Person mapPerson(ResultSet rs) throws SQLException {
        Person p = new Person();
        p.setId(rs.getInt("id"));
        p.setFirst_name(rs.getString("first_name"));
        p.setSecond_name(rs.getString("second_name"));
        p.setAddress(rs.getString("address"));
        p.setPhone_number(rs.getString("phone_number"));
        p.setSettlement_account(rs.getString("settlement_account"));
        return p;
    }
    private Seller mapSeller(ResultSet rs) throws SQLException {
        Seller p = new Seller();
        p.setId(rs.getInt("id"));
        p.setOwnership(rs.getString("ownership"));
        p.setPerson_id(rs.getInt("person_id"));
        return p;
    }
    private Buyer mapBuyer(ResultSet rs) throws SQLException {
        Buyer p = new Buyer();
        p.setId(rs.getInt("id"));
        p.setSolvency(rs.getString("solvency"));
        p.setPerson_id(rs.getInt("person_id"));
        return p;
    }

}
