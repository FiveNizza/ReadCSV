package by.Prohorov.controller.ConnectDB;

import by.Prohorov.model.User;
import by.Prohorov.resource.DataBaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDB {
    private static final String update = "UPDATE \"Entity\".\"User\" SET " +
            "Name = ?," +
            "Surname = ?," +
            "Login = ?," +
            "Email = ?," +
            "PhoneNumber = ?" +
            "WHERE Login = ?";
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;

    public static void update(User user, String login) {
        try {
            Class.forName(DataBaseManager.getProperty("db.forName"));
            try {
                connection = ConnectionDataBase.getConnection();
                try {
                    preparedStatement = connection.prepareStatement(update);
                    preparedStatement.setString(1, user.getName());
                    preparedStatement.setString(2, user.getSurname());
                    preparedStatement.setString(3, user.getLogin());
                    preparedStatement.setString(4, user.geteMail());
                    preparedStatement.setString(5, user.getPhoneNumber());
                    preparedStatement.setString(6, login);
                    preparedStatement.executeUpdate();
                } finally {
                    if (preparedStatement != null)
                        preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
