/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterinnobaters;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import masterinnobaters.model.ObservableReservation;

/**
 *
 * @author Johne
 */
public class TempController implements Initializable {
    
    @FXML
    Button reserve;
    @FXML
    Button reset;
    
    @FXML
    ImageView restaurantImage;
    
    @FXML
    TableView<ObservableReservation> table;
    @FXML
    TableColumn<ObservableReservation, String> colName;
    @FXML
    TableColumn<ObservableReservation, String> colPhone;
    @FXML
    TableColumn<ObservableReservation, String> colEmail;
    @FXML
    TableColumn<ObservableReservation, String> colRoomNo;
    @FXML
    TableColumn<ObservableReservation, String> colTime;
    @FXML
    TableColumn<ObservableReservation, String> colPtySize;
    @FXML
    TableColumn<ObservableReservation, String> colLeaveBy;
    @FXML
    TableColumn<ObservableReservation, String> colSmokingInd;
    @FXML
    TableColumn<ObservableReservation, String> colTableLoc;

    @FXML
    TitledPane privatePane;
    @FXML
    TitledPane detailsPane;
    
    @FXML
    TextField firstName;
    @FXML
    TextField lastName;
    @FXML
    TextField phone;
    @FXML
    TextField email;
    @FXML
    TextField roomNo;
    @FXML
    DatePicker time;
    @FXML
    TextField ptySize;
    @FXML
    TextField leaveBy;
    @FXML
    TextField smokingInd;
    @FXML
    TextField tableLocation;
    @FXML
    TextField tableId;
    @FXML
    TextField tableRequest;
    
    @FXML
    AnchorPane imagePane;
    
    @FXML
    Label timeLabel;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

//        if(restaurantImage != null){
//            restaurantImage.fitWidthProperty().bind(imagePane.widthProperty());
//            restaurantImage.fitHeightProperty().bind(imagePane.heightProperty());
//        }

        this.privatePane.expandedProperty()
            .addListener((observable, wasExpanded, isExpanded) -> 
                this.privatePane.setMaxHeight(isExpanded ? 200 : 0/*privatePane.USE_PREF_SIZE*/));
        this.privatePane.setAnimated(true);
        
        this.timeLabel.setText(String.valueOf(new Date()));
    }
   
    public void titledPaneClicked(ActionEvent event) {
//        this.privatePane.setMinHeight(200);
        this.privatePane.expandedProperty()
            .addListener((observable, wasExpanded, isExpanded) -> 
                this.privatePane.setMinHeight(isExpanded ? 200 : privatePane.USE_PREF_SIZE));
        this.privatePane.setAnimated(false);
    }
}
