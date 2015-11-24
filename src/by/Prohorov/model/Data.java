package by.Prohorov.model;


import by.Prohorov.controller.ConnectDB.OpenDB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;


@ManagedBean(name = "data")
@SessionScoped
public class Data implements Serializable{
    private SortFilterModel<User> filterModel;
    private static ArrayList<User> tempList = new ArrayList<>();
    private static ArrayList<User> list = OpenDB.getInformationFromDB(tempList);

    public Data() {
        filterModel = new SortFilterModel<User>(new ListDataModel<User>(list));
    }

    public DataModel<User> getUsers(){

        return filterModel;
    }

    public String sortByName() {
        filterModel.sortBy(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return null;
    }

    public String sortBySurname() {
        filterModel.sortBy(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        });
        return null;
    }

    public String sortByLogin() {
        filterModel.sortBy(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getLogin().compareTo(o2.getLogin());
            }
        });
        return null;
    }

    public String sortByEmail() {
        filterModel.sortBy(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.geteMail().compareTo(o2.geteMail());
            }
        });
        return null;
    }

    public String sortByPhoneNumber() {
        filterModel.sortBy(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getPhoneNumber().compareTo(o2.getPhoneNumber());
            }
        });
        return null;
    }
}