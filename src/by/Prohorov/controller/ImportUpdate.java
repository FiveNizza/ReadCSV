package by.Prohorov.controller;

import by.Prohorov.controller.ConnectDB.OpenDB;
import by.Prohorov.controller.ConnectDB.UpdateDB;
import by.Prohorov.model.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;


@ManagedBean(name = "update")
@SessionScoped
public class ImportUpdate implements Serializable{
//    private static final String select = "SELECT * FROM \"Entity\".\"User\";";

    private static ArrayList<User> listFromDB = new ArrayList<>();
    private static ArrayList<User> listFromFile = new ArrayList<>();
    private static User user;

    public static void rewrite() {
        OpenDB.getInformationFromDB(listFromDB);

        OutputFromCSV.openFile(listFromFile);

        if (checkInforamtion(listFromDB, listFromFile) == true) {
        }
    }

    public static boolean checkInforamtion(ArrayList<User> listFromDB, ArrayList<User> listFromFile) {
        for (int i = 0; i < listFromDB.size() - 1; i++) {
            for (int j = 0; j < listFromFile.size() - 1; j++) {
                if (listFromDB.get(i).getLogin().equals(listFromFile.get(j).getLogin())) {
                    user = new User(listFromFile.get(j).getName(),
                                    listFromFile.get(j).getSurname(),
                                    listFromFile.get(j).getLogin(),
                                    listFromFile.get(j).geteMail(),
                                    listFromFile.get(j).getPhoneNumber());
                    UpdateDB.update(user, listFromDB.get(i).getLogin());
                }
            }
        }

        return true;
    }
}
