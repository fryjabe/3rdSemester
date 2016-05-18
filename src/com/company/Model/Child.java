package com.company.Model;

/**
 * Created by Kuba on 2016-05-08.
 */
public class Child {

   private int childId;
   private String name;
   private String surname;
   private String birthdate;
   private String address;
   private String email;
   private String password;
   private String mobile1;
   private String mobile2;
   private String disabilities;

    public Child(int childId, String name) {
        this.childId = childId;
        this.name = name;
    }

    public void tralalallaallaal(){}

    public int getChildId() {
        return childId;
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

    public String getMobile1() {
        return mobile1;
    }

    public String getMobile2() {
        return mobile2;
    }

    public String getDisabilities() {
        return disabilities;
    }


    public Child(int childId, String name, String surname, String birthdate, String address, String email, String password, String mobile1, String mobile2, String disabilities) {

        this.childId = childId;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.address = address;
        this.email = email;
        this.password = password;
        this.mobile1 = mobile1;
        this.mobile2 = mobile2;
        this.disabilities = disabilities;
    }


}
