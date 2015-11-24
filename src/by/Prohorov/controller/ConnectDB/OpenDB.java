package by.Prohorov.controller.ConnectDB;

import by.Prohorov.model.User;
import by.Prohorov.resource.DataBaseManager;

import java.sql.*;
import java.util.ArrayList;

public class OpenDB {
    private static final String selectInformation = "SELECT * FROM \"Entity\".\"User\";";
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    private static ArrayList<User> list = new ArrayList<>();

    public static ArrayList<User> getInformationFromDB(ArrayList<User> list) {
        try { //1
            Class.forName(DataBaseManager.getProperty("db.forName"));

            try { //2
                connection = ConnectionDataBase.getConnection();
                statement = null;

                try { //3
                    statement = connection.createStatement();
                    resultSet =null;

                    try { //4
                        resultSet = statement.executeQuery(selectInformation);

                        while (resultSet.next()) {
                            String name = resultSet.getString(1);
                            String surname = resultSet.getString(2);
                            String login = resultSet.getString(3);
                            String eMail = resultSet.getString(4);
                            String phoneNumber = resultSet.getString(5);

                            list.add(new User(name, surname, login, eMail, phoneNumber));
                        }
                    }
                    finally {
                        if (resultSet != null)
                            resultSet.close();
                    }
                }
                finally {
                    if (statement != null)
                        statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (connection != null)
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//
//        int count = 0;
//
//        for (User user : list) {
//            users[count] = user;
//            count++;
//        }

        return list;
    }
}
