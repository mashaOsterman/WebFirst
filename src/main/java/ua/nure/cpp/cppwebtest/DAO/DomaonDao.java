package ua.nure.cpp.cppwebtest.DAO;

import org.springframework.stereotype.Service;
import ua.nure.cpp.cppwebtest.DAO.entity.Buyer;
import ua.nure.cpp.cppwebtest.DAO.entity.Lot;
import ua.nure.cpp.cppwebtest.DAO.entity.Person;
import ua.nure.cpp.cppwebtest.DAO.entity.Seller;

import java.sql.SQLException;
import java.util.List;

@Service
public interface DomaonDao {
    List<Person> getAllPersons() throws SQLException;
    List<Seller> getAllSellers() throws SQLException;
    List<Buyer> getAllBuyer() throws SQLException;
    List<Person> findPersonsbyName(String pattern) throws SQLException;
    void addNewPerson(Person newPers) throws SQLException;
    void deletePerson(int Pers_id) throws SQLException;
    void deletePerson(String first) throws SQLException;

    void addBuyer(Person newPers);
    void addLot(Lot newLot) throws SQLException;
}
