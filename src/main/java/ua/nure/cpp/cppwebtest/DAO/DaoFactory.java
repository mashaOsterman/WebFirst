package ua.nure.cpp.cppwebtest.DAO;


import ua.nure.cpp.cppwebtest.DAO.mysql.MySqlDomaonDao;



public abstract class DaoFactory {
    public static DomaonDao GetForumDao(){
        return MySqlDomaonDao.getInstance();
    }

}