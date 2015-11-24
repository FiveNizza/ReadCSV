package by.Prohorov.controller;

import by.Prohorov.controller.ConnectDB.ConnectionDataBase;
import by.Prohorov.model.User;
import by.Prohorov.resource.DataBaseManager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

@ManagedBean(name="create")
@SessionScoped
public class ImportCreate implements Serializable{
    private static final String insert = "INSERT INTO \"Entity\".\"User\"" +
            "VALUES (?, ?, ?, ?, ?);";
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;


    public void write(){
        ArrayList<User> list = new ArrayList<>();
        OutputFromCSV.openFile(list);

        try {
            Class.forName(DataBaseManager.getProperty("db.forName"));
            try {
                connection = ConnectionDataBase.getConnection();
                try {
                    preparedStatement = connection.prepareStatement(insert);
                    for(User user1 : list) {
                        preparedStatement.setString(1, user1.getName());
                        preparedStatement.setString(2, user1.getSurname());
                        preparedStatement.setString(3, user1.getLogin());
                        preparedStatement.setString(4, user1.geteMail());
                        preparedStatement.setString(5, user1.getPhoneNumber());
                        preparedStatement.execute();
                    }
                } finally {
                    if (preparedStatement != null)
                        preparedStatement.close();
                }
            } finally {
                if (connection != null) {
                    connection.close();
                }
            }
        } catch (SQLException e) {
           e.printStackTrace();
       } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
