package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoJDBCImpl();

        userDao.createUsersTable();

        userDao.saveUser("Ivan", "Ivanov", (byte) 25);
        userDao.saveUser("Petr", "Petrov", (byte) 38);
        userDao.saveUser("Sergey", "Sergeev", (byte) 25);
        userDao.saveUser("Alex", "Alexeev", (byte) 35);

        userDao.getAllUsers().forEach(System.out::println);
        userDao.removeUserById(1);
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
        Util.closeConnection();
    }
}
