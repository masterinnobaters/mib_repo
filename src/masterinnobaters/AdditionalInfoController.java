/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterinnobaters;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Johne
 */
public class AdditionalInfoController implements Initializable  {
    
    @FXML
    Button closeBtn;
    @FXML
    Button saveBtn;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    
    public void onClickClose(ActionEvent event){
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
