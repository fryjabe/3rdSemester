package com.company;


import com.company.Model.Child;
import com.company.Model.DatabaseModel;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;



public class AbstractView extends Application {


    public void hideWindow(){
        availabilityViewStage.hide();
    }

    TableView tableView= new TableView();
    Scene availabilityViewScene ;
    Stage availabilityViewStage;
    Calendar cal;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    ArrayList<Label> labels= new ArrayList<>();
    ArrayList<Button> buttons = new ArrayList<>();

    ArrayList<Child> childrenList;
    DatabaseModel databaseModel;

    HBox hBox;
    Label weekLabel;
    Button incrementByOneButton;
    Button decrementByOneButton;
    int[] weekDays = {2,3,4,5,6,7,1}; // because Sunday has number 1, we swap Monday(2) on that place - project requirements

    GridPane gridPane;
    BorderPane borderPane;

    int weekOfYear;

    Button whatever;

    public void createTableWithChildren()
    {


        TableColumn nameCol = new TableColumn("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<Child, String>("name"));

        TableColumn surnameCol = new TableColumn("Surname");
        surnameCol.setCellValueFactory(new PropertyValueFactory<Child, String>("surname"));

        TableColumn telCol = new TableColumn("Tel.");
        telCol.setCellValueFactory(new PropertyValueFactory<Child, Integer>("houseWorked"));


        tableView.getColumns().setAll(nameCol, surnameCol, telCol);


        tableView.setMaxWidth(428);

        tableView.setPrefHeight(300);

        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        childrenList = new ArrayList<>();

        databaseModel = DatabaseModel.getInstance();
        childrenList = databaseModel.getChildren();
        ObservableList<Child> childrenObservableList = FXCollections.observableList(childrenList);
        tableView.setItems(childrenObservableList);

    }

    public void createAvailabilityView(){

        cal = Calendar.getInstance();  // getting the current date
        cal.setFirstDayOfWeek(Calendar.MONDAY); // setting the Monday to be the first day of the week instead of Sunday
        weekOfYear = cal.get(Calendar.WEEK_OF_YEAR); // getting the current week number

        gridPane = new GridPane(); // creating a grid pane for the calendar and all the functional buttons
        gridPane.setVgap(8); // setting spacing between grid rows
        gridPane.setHgap(8);// setting spacing between grid columns
        gridPane.setPadding(new Insets(10,10,10,10));

        hBox = new HBox();
        decrementByOneButton = new Button("<");
        incrementByOneButton = new Button(">");
        weekLabel = new Label("WEEK: " + weekOfYear);
        Label ifLoggedInLabel = new Label();

        /**
         * Logged as
         * */


        gridPane.setConstraints(ifLoggedInLabel, 0, 0, 3, 2, HPos.LEFT, VPos.TOP);
        gridPane.getChildren().add(ifLoggedInLabel);

        HBox switchWeeks= new HBox();
        switchWeeks.getChildren().addAll(decrementByOneButton, weekLabel, incrementByOneButton);
        gridPane.setConstraints(switchWeeks, 3, 1, 3, 2, HPos.LEFT, VPos.CENTER);

        gridPane.getChildren().add(switchWeeks);
        decrementByOneButton.setMaxWidth(Double.MAX_VALUE);
        incrementByOneButton.setMaxWidth(Double.MAX_VALUE);

        decrementByOneButton.setAlignment(Pos.CENTER_RIGHT);

        incrementByOneButton.setOnAction(event1 -> {


         incrementByOneButtonAction();
        });

        decrementByOneButton.setOnAction(event1 -> {
            decrementByOneButtonAction();
        });


        createLabels();  // CREATING LABELS AND SETTING THEM TO GRID AT ROW 1 POSITIONS 1-7
        createButtons();


        gridPane.getColumnConstraints().add(new ColumnConstraints(240));
        gridPane.getColumnConstraints().add(new ColumnConstraints(56));
        gridPane.getColumnConstraints().add(new ColumnConstraints(56));
        gridPane.getColumnConstraints().add(new ColumnConstraints(56));
        gridPane.getColumnConstraints().add(new ColumnConstraints(56));
        gridPane.getColumnConstraints().add(new ColumnConstraints(56));
        gridPane.getColumnConstraints().add(new ColumnConstraints(56));
        gridPane.getColumnConstraints().add(new ColumnConstraints(56));


        borderPane = new BorderPane();
        borderPane.setTop(hBox);
        borderPane.setCenter(gridPane);
        availabilityViewStage = new Stage();
        availabilityViewScene = new Scene(borderPane, 1050, 600);


        availabilityViewStage.setScene(availabilityViewScene);
        availabilityViewStage.show();
        createHourLabels();
        createTableView();
        createTableWithChildren();

    }




    /**
     * Buttons methods
     */

    public void  createButtons() {  // probably for model
        Button logoutButton= new Button("Log out");// ShiftTypes[] shiftTypes= shiftTypesController.getShiftTypes(); // getting values from Enum of ShiftTypes (via Controller)

        gridPane.getChildren().add(logoutButton);
        gridPane.setConstraints(logoutButton,10, 0);

        for(int j=0; j<10; j++) {
            for(int i=0; i<7; i++) {
                String dates = labels.get(i).getText();
                String id = dates; // creating buttons Id
                Button button = new Button();
                button.setMaxWidth(Double.MAX_VALUE);
                button.setMaxHeight(Double.MAX_VALUE);
                button.setId(id);
                Date sqlDate = Date.valueOf(dates); // asigning a date of sql type Date

                // String shiftType = shiftTypes[j].toString();
              /*  boolean booked = availabilityController.ifAvailable(sqlDate, shiftTypes[j].toString(), loginController.passLoggedEmployee().getEmpId());

                if(booked == true) {

                    button.setStyle("-fx-base: #00b300"); // green


                }

                button.setOnAction(event -> {
                    // check if(ifAvailable() != true) -> button is gray(person haven't clicked 'available for work' yet
                    if (availabilityController.ifAvailable(sqlDate, shiftType, loginController.passLoggedEmployee().getEmpId()) != true) { // then add availability
                        button.setStyle("-fx-base: #00b300"); // green

                        availabilityController.addAvailability(sqlDate, shiftType, loginController.passLoggedEmployee().getEmpId()); // adding entry to availabilities table

                    } else {
                        availabilityController.removeAvailability(sqlDate, shiftType, loginController.passLoggedEmployee().getEmpId()); // remove entry
                        button.setStyle("-fx-base: #e3e3e3"); // gray

                    }
                    // send an update request for the particular button

                });*/
                buttons.add(button);
                gridPane.getChildren().add(button);
                gridPane.setConstraints(button, i + 1, j + 4);
            }
        }
    }




    public void incrementByOneButtonAction() { //main motor to changing the properties of the buttons of the calendar x shift
        if(weekOfYear < 52) {  // checking if the week is smaller than 52
            weekOfYear = weekOfYear + 1;// incrementing the week of the year
            updateDateLabels(labels); // updating the date labels
            updateButtons();// updating the button information


        }
    }
    public void decrementByOneButtonAction() {//main motor to changing the properties of the buttons of the calendar x shift
        if(weekOfYear > 1) {// checking if the week is smaller than 52
            weekOfYear = weekOfYear - 1; // decrementing the week of the year
            updateDateLabels(labels);// updating the date labels
            updateButtons();// updating the button information


        }
    }

    public void createHourLabels()
    {
        for (int i = 8; i< 18; i++)
        {
            Label label = new Label(i + "");
            gridPane.getChildren().add(label);
            gridPane.setConstraints(label, 0, i - 4);

        }
    }

    /**
     *
     * Labels methods
     *
     */

    public void updateButtons() {

        //String[] shiftTypes= {"N","D","E"};
        int indexButton = 0;

        for(int j=0; j<10; j++) {
            for (int i = 0; i < 7; i++) {

                // String id = labels.get(i).getText() + shiftTypes[j];
                Button button = buttons.get(indexButton);

               /* String date = id.substring(0,10);
                String shiftType = id.substring(10, 11);
                Date sqlDate = Date.valueOf(date);
                boolean booked = availabilityController.ifAvailable(sqlDate, shiftType, loginController.passLoggedEmployee().getEmpId());
                if(booked == true) {

                    button.setStyle("-fx-base: #00b300"); // green


                }
                else{
                    button.setStyle("-fx-base: #e3e3e3"); // gray
                }
                //  button.setStyle("-fx-font-size: 20px");
                button.setId(id);*/
                button.setOnAction(event -> {


                   /* // check if(ifAvailable() != true) -> button is gray(person haven't clicked 'available for work' yet
                    if(availabilityController.ifAvailable(sqlDate, shiftType, loginController.passLoggedEmployee().getEmpId() ) != true) { // then add availability
                        button.setStyle("-fx-base: #00b300"); // green

                        availabilityController.addAvailability(sqlDate, shiftType, loginController.passLoggedEmployee().getEmpId()); // adding entry to availabilities table

                    }
                    else {
                        availabilityController.removeAvailability(sqlDate, shiftType, loginController.passLoggedEmployee().getEmpId()); // remove entry
                        button.setStyle("-fx-base: #e3e3e3"); // gray

                    }



*/
                    //updateCustomTable(date, shiftType);
                });
                indexButton++;
            }
        }
    }



    public void createLabels (){


        for(int i =0; i<7; i++) {    // 7 times we create a label, from Monday label to Sunday label

            cal.set(Calendar.WEEK_OF_YEAR, cal.get(Calendar.WEEK_OF_YEAR)); // setting a calendar to a desired week
            cal.set(Calendar.DAY_OF_WEEK, weekDays[i]);

            String date= simpleDateFormat.format(cal.getTime());// labels Id format (date)
            Label label = new Label(); // creating a label for a date
            label.setText(date);// setting date to label
            label.setStyle("-fx-font-size: 8px");// setting size of the label
            labels.add(label);// adding labels to array list of labels

            gridPane.getChildren().add(label); // put label to grid
            gridPane.setConstraints(label, i + 1, 3); // position label at column 1...7, row 3
        }


    }

    public void updateDateLabels (ArrayList<Label> labels) {
        weekLabel.setText("WEEK: " + weekOfYear);  // setting the week label to a week of interest
        cal = Calendar.getInstance(); // getting the current date
        cal.setFirstDayOfWeek(Calendar.MONDAY);// setting the Monday to be the first day of the week instead of Sunday


        for (int i = 0; i < labels.size(); i++) {
            cal.set(Calendar.WEEK_OF_YEAR, weekOfYear);
            cal.set(Calendar.DAY_OF_WEEK, weekDays[i]);
            String date = simpleDateFormat.format(cal.getTime()); // setting a string for a desired date
            labels.get(i).setText(date); // setting the name of the label to desired date


        }
    }

    public void createTableView(){

        borderPane.setLeft(tableView);

    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        createAvailabilityView();
    }
}