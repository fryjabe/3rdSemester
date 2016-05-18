package com.company;

import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.awt.*;

/**
 * Created by Kuba on 2016-05-08.
 */
public class TherapistView extends AbstractView {

    public TherapistView() {
        addBehaviour();
    }

    public void addBehaviour(){
        try {
            start(availabilityViewStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        javafx.scene.control.Button button1= new Button("elo");

    }


//    @Override
//    public void setBox(VBox box) {
//        super.setBox(box);
//        box.getChildren().addAll(button1);
//    }
}
