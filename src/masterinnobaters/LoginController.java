/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterinnobaters;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Johne
 */
public class LoginController implements Initializable {
    
    @FXML
    Label errorMsgLbl;
    @FXML
    Label usernameLbl;
    @FXML
    Label passwordLbl;
    @FXML
    TextField username;
    @FXML
    TextField password;
    @FXML
    ImageView userImg;
    @FXML
    BorderPane loginPane;
    
    @FXML
    Button closeBtn;
    @FXML
    Button loginBtn;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.loginBtn.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #b8d2fc, #68a2ff)");

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(2), loginPane);
        fadeOut.setFromValue(0.0);
        fadeOut.setToValue(1.0);
        fadeOut.play();
    }
    
    public void onClickClose(ActionEvent event){
//        System.exit(0);
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
    
    public void onLoginClicked(ActionEvent event) throws IOException{
        
        if(username.getText().equals("admin") 
                && password.getText().equals("admin")){
            
            AnchorPane page = (AnchorPane) FXMLLoader.load(getClass().getResource("resources/masterinnobaters.fxml"));
            Scene scene = new Scene(page);
            Stage primaryStage = new Stage();
            primaryStage.setScene(scene);
            primaryStage.setTitle("Hotel Reservation");
            primaryStage.setFullScreen(true);
            primaryStage.show();

            ((Node)(event.getSource())).getScene().getWindow().hide();
        }else{
            errorMsgLbl.setVisible(true);
        }
    }        
}
