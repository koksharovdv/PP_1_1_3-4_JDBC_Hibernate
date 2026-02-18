package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Ivan", "Ivanov", (byte) 25);
        userService.saveUser("Petr", "Petrov", (byte) 38);
        userService.saveUser("Sergey", "Sergeev", (byte) 25);
        userService.saveUser("Alex", "Alexeev", (byte) 35);

        userService.getAllUsers().forEach(System.out::println);
        userService.removeUserById(1);
        userService.cleanUsersTable();
        userService.dropUsersTable();
//        Util.closeConnection();
    }
}
