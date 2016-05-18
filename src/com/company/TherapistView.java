package com.company;
import javafx.scene.control.Button;

import java.awt.*;

/**
 * Created by Kuba on 2016-05-08.
 */
public class TherapistView extends AbstractView {

    public TherapistView() {
        addBehaviour();
    }

    public void addBehaviour() {
        try {

            start(availabilityViewStage);

        } catch (Exception e) {

            e.printStackTrace();
        }
        Button button1 = new Button("elo");

    }


}
