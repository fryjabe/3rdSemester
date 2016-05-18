package com.company.Model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Kuba on 2016-05-08.
 */
public class DatabaseModel {

    private java.sql.Connection conn = null;

    public DatabaseModel() {

        String DB_URL = "jdbc:mysql://sql7.freesqldatabase.com:3306/sql7118051";  // dont forget to insert
        String USER = "sql7118051";
        String PASS = "EY414dsxHW";
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addNewPresident( String name, String surname, String birthdate, String address, String email, String password,
                                 String mobile) {
        String sql = "INSERT INTO useraccount VALUES(null, ?, ?, ?, ?, ?, ? ,? )";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, birthdate);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, password);
            preparedStatement.setString(7, mobile);


            int numberOfRows = preparedStatement.executeUpdate();
            System.out.println("Completed insert. Number of rows affected:" + numberOfRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addNewTherapist( String name, String surname, String birthdate,String occupation,  String address, String email,
                                 String password, String mobile) {
        String sql = "INSERT INTO useraccount VALUES(null, ?, ?, ?, ?, ?, ?, ?, ? )";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, birthdate);
            preparedStatement.setString(4, occupation);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, email);
            preparedStatement.setString(7, password);
            preparedStatement.setString(8, mobile);


            int numberOfRows = preparedStatement.executeUpdate();
            System.out.println("Completed insert. Number of rows affected:" + numberOfRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addNewChild( String name, String surname, String birthdate, String address, String email, String password,
                                 String mobile1, String mobile2, String disabilities) {
        String sql = "INSERT INTO useraccount VALUES(null, ?, ?, ?, ?, ?, ? ,?, ?,? )";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, birthdate);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, password);
            preparedStatement.setString(7, mobile1);
            preparedStatement.setString(8, mobile2);
            preparedStatement.setString(9, disabilities);


            int numberOfRows = preparedStatement.executeUpdate();
            System.out.println("Completed insert. Number of rows affected:" + numberOfRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public Child retrieveChildIfAllowedToLogIn(String email, String password) {
        String sql = "SELECT * FROM children WHERE email = ? AND password= ?";
        Child child = null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int childId = resultSet.getInt(1);
                String name = resultSet.getString(2);



                child = new Child(childId, name);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return child;
    }

    public President retrievePresidentIfAllowedToLogIn(String email, String password) {
        String sql = "SELECT * FROM presidents WHERE email = ? AND password= ?";
        President president = null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int presidentId = resultSet.getInt(1);
                String name = resultSet.getString(2);



                president = new President(presidentId, name);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return president;
    }


    public Therapist retrieveTherapistIfAllowedToLogIn(String email, String password) {
        String sql = "SELECT * FROM therapists WHERE email = ? AND password= ?";
        Therapist therapist = null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int therapistId = resultSet.getInt(1);
                String name = resultSet.getString(2);



                therapist = new Therapist(therapistId, name);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return therapist;
    }

    public ArrayList<Child> getChildren() {
        ArrayList<Child> children = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Children";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            //preparedStatement.setInt(1, childId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Child child = new Child(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7),
                        resultSet.getString(8), resultSet.getString(9), resultSet.getString(10));
                children.add(child);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return children;
    }

    public ArrayList<Therapist> getTherapists() {
        ArrayList<Therapist> therapists = new ArrayList<>();

        try {
            String sql = "SELECT * FROM therapists";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            //preparedStatement.setInt(1, childId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Therapist therapist = new Therapist(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7),
                        resultSet.getString(8), resultSet.getString(9));
                therapists.add(therapist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return therapists;
    }




}
