/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterinnobaters.model;

import java.util.Calendar;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.util.Duration;
import masterinnobaters.util.StringUtil;

/**
 *
 * @author Johne
 * 
 * reference : http://stackoverflow.com/questions/13227809/displaying-changing-values-in-javafx-label
 */
public class DigitalClock extends Label{

    public DigitalClock() {
        bindToTime();
    }

    // the digital clock updates once a second.
    private void bindToTime() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),
                        new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Calendar time = Calendar.getInstance();
                        String hourString = StringUtil.pad(2, ' ', time.get(Calendar.HOUR) == 0 ? "12" : time.get(Calendar.HOUR) + "");
                        String minuteString = StringUtil.pad(2, '0', time.get(Calendar.MINUTE) + "");
                        String secondString = StringUtil.pad(2, '0', time.get(Calendar.SECOND) + "");
                        String ampmString = time.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
                        setText(hourString + ":" + minuteString + ":" + secondString + " " + ampmString);
                    }
                }
                ),
                new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
