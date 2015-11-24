package by.Prohorov.model;

import java.io.Serializable;

public class User implements Serializable{
    private String name;
    private String surname;
    private String login;
    private String eMail;
    private String phoneNumber;

    public User(String name, String surname,
                String login, String eMail,
                String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
