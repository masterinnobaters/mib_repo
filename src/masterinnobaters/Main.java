/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterinnobaters;

import com.sun.javafx.application.LauncherImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import master_inno_baters.preloader.master_inno_baters_Preloader;

/**
 *
 * @author Johne
 */
public class Main extends Application {
    
    // Just a counter to create some delay while showing preloader.
    private static final int COUNT_LIMIT = 300000;

    private static int stepCount = 1;

    // Used to demonstrate step couns.
    public static String STEP() {
        return stepCount++ + ". ";
    }
    
    @Override
    public void init() throws Exception {
        System.out.println(Main.STEP() + "MyApplication#init (doing some heavy lifting), thread: " + Thread.currentThread().getName());

        // Perform some heavy lifting (i.e. database start, check for application updates, etc. )
        for (int i = 0; i < COUNT_LIMIT; i++) {
            double progress = (100 * i) / COUNT_LIMIT;
            LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(progress));
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Application.launch(Main.class, (java.lang.String[])null);
        LauncherImpl.launchApplication(Main.class, master_inno_baters_Preloader.class, args);
    }

    @Override
    public void start(Stage primaryStage) {
        
        try {
            AnchorPane page = (AnchorPane) FXMLLoader.load(Main.class.getResource("login.fxml"));
            page.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #5f6266, #91969e)");
            Scene scene = new Scene(page);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Hotel Reservation");
//            primaryStage.setFullScreen(true);

            String image = Main.class.getResource("resources/background4.jpg").toExternalForm();
            page.setStyle("-fx-background-image: url('" + image + "'); " +
                    "-fx-background-position: center center; " +
                    "-fx-background-repeat: stretch;");
            primaryStage.initStyle(StageStyle.UNDECORATED);
            
            primaryStage.show();
            
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        try {
//            AnchorPane page = (AnchorPane) FXMLLoader.load(Main.class.getResource("masterinnobaters.fxml"));
//            Scene scene = new Scene(page);
//            primaryStage.setScene(scene);
//            primaryStage.setTitle("Hotel Reservation");
//            primaryStage.setFullScreen(true);
//            primaryStage.show();
//        } catch (Exception ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
}
