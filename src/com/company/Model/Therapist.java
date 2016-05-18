package com.company.Model;

/**
 * Created by Kuba on 2016-05-08.
 */
public class Therapist {
    int therapistId;
    String name;
    String surname;
    String birthdate;
    String occupation;
    String address;
    String email;
    String password;
    String mobile;

    public Therapist(int therapistId, String name) {
        this.therapistId = therapistId;
        this.name = name;
    }

    public int getTherapistId() {
        return therapistId;
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

    public String getOccupation() {
        return occupation;
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

    public Therapist(int therapistId, String name, String surname, String birthdate, String occupation, String address, String email, String password, String mobile) {

        this.therapistId = therapistId;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.occupation = occupation;
        this.address = address;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
    }


}
