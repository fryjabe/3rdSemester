package com.company.Model;

/**
 * Created by Kuba on 2016-05-08.
 */
public class President {
    int presidentId;
    String name;
    String surname;
    String birthdate;
    String address;
    String email;
    String password;
    String mobile;

    public President(int presidentId, String name) {
        this.presidentId = presidentId;
        this.name = name;
    }

    public int getPresidentId() {
        return presidentId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getMobile() {
        return mobile;
    }

    public President(int presidentId, String name, String surname, String birthdate, String address, String email, String password, String mobile) {

        this.presidentId = presidentId;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.address = address;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
    }


}
