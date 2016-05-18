package com.company;

import com.company.Controler.LoginController;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Edgaras on 4/8/2016.
 */
public class LogInView extends Application {


    Stage mainStage = new Stage();
    Scene loginScene;

    HBox loginHbox;
    VBox loginVbox;

    VBox vBox1;
    VBox vBox2;

    Button loginButton;
    Button newAccountButton;

    TextField usernameTextField;
    // TextField passwordTextField;
    PasswordField passwordTextField;

    Label usernameLabel;
    Label passwordLabel;


    //Greg
    LoginController loginController = new LoginController();





    @Override
    public void start(Stage primaryStage) throws Exception {

        mainStage.setScene(getLoginScene());
        mainStage.show();




    }

    public Scene getLoginScene()
    {

        usernameLabel = new Label("User Name");
        passwordLabel = new Label("Password");

        usernameTextField = new TextField();
        passwordTextField = new PasswordField();

        loginButton = new Button("Log in");
        loginButton.setStyle("-fx-font-size: 20px; -fx-background-color: powderblue; -fx-border-color: black");

        newAccountButton = new Button("New account");
        newAccountButton.setStyle("-fx-font-size: 20px; -fx-background-color: powderblue; -fx-border-color: black");


        loginHbox = new HBox();
        loginVbox = new VBox();

        vBox1 = new VBox();
        vBox2 = new VBox();
        vBox1.getChildren().addAll(usernameLabel, usernameTextField);
        vBox1.setStyle("-fx-font-size: 20px");
        vBox2.getChildren().addAll(passwordLabel, passwordTextField);
        vBox2.setStyle("-fx-font-size: 20px");



        loginHbox.getChildren().addAll(loginButton, newAccountButton);
        loginVbox.getChildren().addAll(vBox1, vBox2, loginHbox);
        loginVbox.setSpacing(20);
        loginVbox.setStyle("-fx-background-color: ghostwhite");


        loginScene = new Scene(loginVbox, 232, 350);
        loginVbox.setAlignment(Pos.BOTTOM_CENTER);

        newAccountButton.setOnAction(event -> {




        });

        loginButton.setOnAction(event -> {

            //controller



        });

        return loginScene;

    } }

