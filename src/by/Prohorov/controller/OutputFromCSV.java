package by.Prohorov.controller;

import by.Prohorov.model.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class OutputFromCSV {
    private static final String fileName = "C:\\Users\\Vaio\\Desktop\\Junior\\Soution_1\\src\\1.csv";

    public static ArrayList<User> openFile(ArrayList<User> tempList) {
        String[] users;
        String tempName;
        String tempSurname;
        String tempLogin;
        String tempEmail;
        String tempPhoneNumber;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String temp;
            while((temp = reader.readLine()) != null) {
                users = temp.split(";");

                tempName = users[0];
                tempSurname = users[1];
                tempLogin = users[2];
                tempEmail = users[3];
                tempPhoneNumber = users[4];

                tempList.add(new User(tempName, tempSurname, tempLogin, tempEmail, tempPhoneNumber));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {}

        return tempList;
    }
}