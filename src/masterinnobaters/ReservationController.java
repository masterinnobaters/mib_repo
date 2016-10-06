/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterinnobaters;

import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.LocalDateStringConverter;
import masterinnobaters.model.DigitalClock;
import masterinnobaters.model.ObservableReservation;
import masterinnobaters.model.ReservationService;
import masterinnobaters.model.ReservationServiceStub;
import masterinnobaters.model.TableSchedule;
import masterinnobaters.util.StringUtil;

/**
 *
 * @author Johne
 */
public class ReservationController implements Initializable {
    
    @FXML
    VBox organizationGrp;
    
    @FXML
    VBox privateGrp;
    
    @FXML
    ImageView image1;
    
    @FXML
    Button updateBtn;
    @FXML
    Button newBtn;
    @FXML
    Button cancel;
    @FXML
    Button reserve;
    @FXML
    Button reset;
    @FXML
    Button lookup;
    @FXML
    Button addtlInfo;
    
    @FXML
    ImageView restaurantImage;
    
    @FXML
    TableView<ObservableReservation> table;
    @FXML
    AnchorPane tableAnchorPane;
    @FXML
    ScrollPane tableScrollPane;
    @FXML
    HBox buttonPane;
    @FXML
    TableColumn<ObservableReservation, String> colFirstName;
    @FXML
    TableColumn<ObservableReservation, String> colLastName;
    @FXML
    TableColumn<ObservableReservation, String> colTitle;
    @FXML
    TableColumn<ObservableReservation, String> colPhone;
    @FXML
    TableColumn<ObservableReservation, String> colEmail;
    @FXML
    TableColumn<ObservableReservation, String> colRoomNo;
    @FXML
    TableColumn<ObservableReservation, String> colTimeIn;
    @FXML
    TableColumn<ObservableReservation, String> colPtySize;
    @FXML
    TableColumn<ObservableReservation, String> colTimeOut;
    @FXML
    TableColumn<ObservableReservation, String> colTableLoc;
    @FXML
    TableColumn<ObservableReservation, String> colTableId;
    @FXML
    TableColumn<ObservableReservation, String> colOccassion;

    @FXML
    TitledPane privatePane;
    @FXML
    TitledPane detailsPane;
    
    @FXML
    ComboBox salutation;
    @FXML
    TextField firstName;
    @FXML
    TextField lastName;
    @FXML
    TextField phone;
    @FXML
    TextField areaCode;
    @FXML
    TextField email;
    @FXML
    TextField roomNo;
    @FXML
    ComboBox rating;
//    @FXML
//    Spinner ptySize;
    @FXML
    TextField smokingInd;
    @FXML
    ComboBox tableLocation;
    @FXML
    ComboBox tableId;
    @FXML
    ComboBox occassion;
    @FXML
    TextField tableRequest;
    
    @FXML
    AnchorPane imagePane;
    @FXML
    VBox leftPanel;
    @FXML
    SplitPane rightPanel;
    @FXML
    HBox headerPane;
    @FXML
    SplitPane bodySplitPane;
    @FXML
    Spinner arrivalHour;
    @FXML
    Spinner arrivalMinute;
    @FXML
    DatePicker dayIn;
    @FXML
    Spinner departHour;
    @FXML
    Spinner departMinute;
    @FXML
    DatePicker dayOut;
    @FXML
    Spinner adultWithAlc;
    @FXML
    Spinner adult;
    @FXML
    Spinner children;
    @FXML
    Spinner babies;
    @FXML
    Spinner special;
    
    @FXML
    TableView tableSchedule;
    @FXML
    TableColumn colTsTime;
    @FXML
    TableColumn colTsAv;
    @FXML
    TableColumn colTsRnC;
    @FXML
    TableColumn colTsCap;
    @FXML
    TableColumn colTsMpty;
    @FXML
    TableColumn colTsRes;
    
    private ObservableList<ObservableReservation> data =
        FXCollections.observableArrayList();
    
    protected ReservationService model  = null;
    
    public Boolean isLoggedIn = false;
    
//    Image outlook = new Image("file:resources/Outlook.png");
//    Image outlookHover = new Image("file:resources/Outlook_hover.png");
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

//        if(restaurantImage != null){
//            restaurantImage.fitWidthProperty().bind(imagePane.widthProperty());
//            restaurantImage.fitHeightProperty().bind(imagePane.heightProperty());
//        }

//        organizationGrp.getChildren().clear();
        
        // add tooltip for lookup
        this.lookup.setTooltip(new Tooltip("This will look for existing customer"));

        this.privatePane.expandedProperty()
            .addListener((observable, wasExpanded, isExpanded) -> 
                this.privatePane.setMaxHeight(isExpanded ? 200 : 0/*privatePane.USE_PREF_SIZE*/));
        this.privatePane.setAnimated(true);

        // display the current date
        DigitalClock digitalClock = new DigitalClock();
        digitalClock.setFont(Font.font("Helvetica", 30));
        digitalClock.setTextFill(Color.web("#0076a3"));
        headerPane.getChildren().add(digitalClock);

        // set the splitter to 25%
        bodySplitPane.setDividerPositions(0.15);

        // set the hour and minute splitter
        this.setTimeSpinnerValue(arrivalHour, HourMinuteEnum.HOUR);
        this.setTimeSpinnerValue(arrivalMinute, HourMinuteEnum.MINUTE);
        this.setTimeSpinnerValue(departHour, HourMinuteEnum.HOUR, 23);
        this.setTimeSpinnerValue(departMinute, HourMinuteEnum.MINUTE, 59);

//        ptySize.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(
//            1, 10, 0));
//        ptySize.setEditable(false);

        this.adultWithAlc.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(
            0, 100, 0));
        
        this.adult.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(
            0, 100, 0));
        
        this.babies.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(
            0, 100, 0));
        
        this.children.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(
            0, 100, 0));
        
        this.special.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(
            0, 100, 0));

        // load options for combobox
        ObservableList<String> options1 = 
        FXCollections.observableArrayList(
            "Outdoor",
            "Indoor",
            "Smoking",
            "Lounge",
            "Terrace"
        );
        tableLocation.setItems(options1);
        
        ObservableList<String> options4 = 
        FXCollections.observableArrayList(
            "1","2","3","4","5","6","7","8","9","10","11"
        );
        tableId.setItems(options4);

        ObservableList<String> options5 = 
        FXCollections.observableArrayList(
            "Birthday",
            "Anniversary",
            "Wedding",
            "Debut",
            "Graduation",
            "Others"
        );
        occassion.setItems(options5);        
        
        ObservableList<String> options2 = 
        FXCollections.observableArrayList(
            "1", "2", "3", "4", "5", "N/A"
        );
        rating.setItems(options2);
        
        ObservableList<String> options3 = 
        FXCollections.observableArrayList(
            "Mr.", "Ms.", "Mrs.", "N/A"
        );
        salutation.setItems(options3);

        // setup table and column layout
//        tableAnchorPane.prefWidthProperty().bind(tableScrollPane.prefWidthProperty());
//        table.prefWidthProperty().bind(tableAnchorPane.prefWidthProperty());
//        table.prefWidth(Double.MAX_VALUE);

        colFirstName.prefWidthProperty().bind(table.widthProperty().divide(8)); // w * 1/4
        colLastName.prefWidthProperty().bind(table.widthProperty().divide(8)); 
        colTitle.prefWidthProperty().bind(table.widthProperty().divide(8)); 
        colEmail.prefWidthProperty().bind(table.widthProperty().divide(8));
        colPhone.prefWidthProperty().bind(table.widthProperty().divide(8));
        colPtySize.prefWidthProperty().bind(table.widthProperty().divide(8));
        colTableLoc.prefWidthProperty().bind(table.widthProperty().divide(8));
        colRoomNo.prefWidthProperty().bind(table.widthProperty().divide(8));
        colTimeIn.prefWidthProperty().bind(table.widthProperty().divide(8));
        colTimeOut.prefWidthProperty().bind(table.widthProperty().divide(8));
        colTableId.prefWidthProperty().bind(table.widthProperty().divide(8));
        colOccassion.prefWidthProperty().bind(table.widthProperty().divide(8));

        tableSchedule.prefWidthProperty().bind(rightPanel.widthProperty().divide(4));
        colTsAv.prefWidthProperty().bind(tableSchedule.widthProperty().divide(6));
        colTsCap.prefWidthProperty().bind(tableSchedule.widthProperty().divide(6));
        colTsRes.prefWidthProperty().bind(tableSchedule.widthProperty().divide(6));
        colTsRnC.prefWidthProperty().bind(tableSchedule.widthProperty().divide(6));
        colTsTime.prefWidthProperty().bind(tableSchedule.widthProperty().divide(6));
        colTsMpty.prefWidthProperty().bind(tableSchedule.widthProperty().divide(6));

//        image1.imageProperty().bind(Bindings.when(image1.hoverProperty())
//                .then(outlookHover)
//                .otherwise(outlook));
        this.updateButtonState();
        this.tableSchedule.setItems(tableSched);

        this.connectToService();
    }
   
    enum HourMinuteEnum{
        MINUTE,
        HOUR
    }
    
    private void setTimeSpinnerValue(Spinner spinner, HourMinuteEnum hourOrMinute){
        setTimeSpinnerValue(spinner, hourOrMinute, null);
    }
    
    private void setTimeSpinnerValue(Spinner spinner, HourMinuteEnum hourOrMinute, Integer customValue){
        
        int maxValue = 0, 
            minValue = 0,
            value = 0;
        
        if(hourOrMinute.equals(hourOrMinute.HOUR)){
            maxValue = 23;
            minValue = 0;
        }else if(hourOrMinute.equals(hourOrMinute.MINUTE)){
            maxValue = 59;
            minValue = 0;
        }
        
        if(customValue != null){
            value = customValue;
        }else{
            value = hourOrMinute.equals(hourOrMinute.HOUR) ? Integer.valueOf(LocalTime.now().getHour())
                : Integer.valueOf(LocalTime.now().getMinute());
        }
        
        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(
            minValue, maxValue, value));
        spinner.setEditable(false);
    }
    
    public void onAddtlInfoClicked(ActionEvent event) throws IOException{
        AnchorPane page = (AnchorPane) FXMLLoader.load(getClass().getResource("resources/addtlInfo.fxml"));
        Scene scene = new Scene(page);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Additional Information");
        primaryStage.show();
    }
    
    public void onImage1Hover(ActionEvent event){
        this.image1.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0); "
                            + "-fx-padding: 10; " +
                             "-fx-background-color: firebrick;");
    }
    
    public void titledPaneClicked(ActionEvent event) {
//        this.privatePane.setMinHeight(200);
        this.privatePane.expandedProperty()
            .addListener((observable, wasExpanded, isExpanded) -> 
                this.privatePane.setMinHeight(isExpanded ? 200 : privatePane.USE_PREF_SIZE));
        this.privatePane.setAnimated(false);
    }
    
    // Connect to the service, make the grid listen to changes
    private void connectToService() {
        if (model == null) {
            model = new ReservationServiceStub();
        }
        
        this.configureTable();
        
//        projectsView.clear();
//        List<String> sortedProjects = new ArrayList<String>(displayedProjectNames);
//        Collections.sort(sortedProjects);
//        projectsView.addAll(sortedProjects);
//        list.setItems(projectsView);
    }
    
        // This listener listen to changes in the table widget selection and
    // update the DeleteIssue button state accordingly.
    private final ListChangeListener<ObservableReservation> tableSelectionChanged =
        new ListChangeListener<ObservableReservation>() {

            @Override
            public void onChanged(ListChangeListener.Change<? extends ObservableReservation> c) {
                updateButtonState();
                updateDetails();
//                updateBugDetails();
//                updateSaveIssueButtonState();
            }
        };
    
    private void updateDetails(){
        ObservableReservation selectedReservation = getSelectedReservation();
        if(table != null && selectedReservation != null){
            if(selectedReservation.getCustomer() != null){
                String titleStr = selectedReservation.getCustomer().getTitle();
                if(titleStr != null){
                    this.salutation.setValue(titleStr);
                }
                this.firstName.setText(selectedReservation.getCustomer().getFirstName());
                this.lastName.setText(selectedReservation.getCustomer().getLastName());
                this.email.setText(selectedReservation.getCustomer().getEmail());
                this.roomNo.setText(selectedReservation.getCustomer().getRoomNo());
                String phoneStr = selectedReservation.getCustomer().getMobileNo();
                this.phone.setText(phoneStr.substring(phoneStr.indexOf("-")+1, phoneStr.length()));
                this.areaCode.setText(phoneStr.substring(0, phoneStr.indexOf("-")-1));
            }
            
            String pattern = "yyyy-MM-dd";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            String arrivalTimestamp = selectedReservation.getArrivalTimestamp();
            String arrvlHr = arrivalTimestamp.split(":")[0];
            String arrvlMnt = arrivalTimestamp.substring(arrivalTimestamp.indexOf(":") + 1, arrivalTimestamp.indexOf(" "));
            String dayIn = arrivalTimestamp.substring(arrivalTimestamp.indexOf(" "), arrivalTimestamp.length());
            
            this.arrivalHour.getValueFactory().setValue(Integer.valueOf(arrvlHr));
            this.arrivalMinute.getValueFactory().setValue(Integer.valueOf(arrvlMnt));
            this.dayIn.setValue(new LocalDateStringConverter(formatter, null).fromString(dayIn));
            
            String departureTimestamp = selectedReservation.getDepartureTimestamp();
            String dprtHr = departureTimestamp.split(":")[0];
            String dprtMnt = departureTimestamp.substring(departureTimestamp.indexOf(":") + 1, departureTimestamp.indexOf(" "));
            String dayOut = departureTimestamp.substring(departureTimestamp.indexOf(" "), departureTimestamp.length());
 
            this.departHour.getValueFactory().setValue(Integer.valueOf(dprtHr));
            this.departMinute.getValueFactory().setValue(Integer.valueOf(dprtMnt));
            this.dayOut.setValue(new LocalDateStringConverter(formatter, null).fromString(dayOut));
            
            String[] partiesArr = selectedReservation.getPtySize().split(";");
            Map<String, String> partyMap = new HashMap<String, String>();
            
            for(String party : partiesArr){
                String[] keyVal = party.split("=");
                partyMap.put(keyVal[0], keyVal[1]);
            }
            
            Iterator i = partyMap.keySet().iterator();
            
            while(i.hasNext()){
                String key = (String)i.next();
                switch(key){
                    case "Adult w/ ALC" : this.adultWithAlc.getValueFactory().setValue(Integer.valueOf(partyMap.get(key)));
                                            break;
                    case "Adult w/o ALC" : this.adult.getValueFactory().setValue(Integer.valueOf(partyMap.get(key)));
                                            break;
                    case "Children" : this.children.getValueFactory().setValue(Integer.valueOf(partyMap.get(key)));
                                            break;
                    case "Babies" : this.babies.getValueFactory().setValue(Integer.valueOf(partyMap.get(key)));
                                            break;
                    case "Special" : this.special.getValueFactory().setValue(Integer.valueOf(partyMap.get(key)));
                                            break;
                }
            }
            
//            this.ptySize.getValueFactory().setValue(Integer.valueOf(selectedReservation.getPtySize()));
            
            this.tableLocation.setValue(selectedReservation.getTableLoc());
            this.tableId.setValue(selectedReservation.getTableId());
            this.occassion.setValue(selectedReservation.getOccassion());
            
        }else{
            this.salutation.setSelectionModel(null);
            this.firstName.setText("");
            this.lastName.setText("");
            this.phone.setText("");
            this.areaCode.setText("");
            this.email.setText("");
            this.roomNo.setText("");
            this.arrivalHour.getValueFactory().setValue(0);
            this.arrivalMinute.getValueFactory().setValue(0);
            this.dayIn.setValue(null);
            this.departHour.getValueFactory().setValue(0);
            this.departMinute.getValueFactory().setValue(0);
            this.dayOut.setValue(null);
//            this.ptySize.getValueFactory().setValue(0);
            this.adult.getValueFactory().setValue(0);
            this.adultWithAlc.getValueFactory().setValue(0);
            this.children.getValueFactory().setValue(0);
            this.babies.getValueFactory().setValue(0);
            this.special.getValueFactory().setValue(0);
            this.tableLocation.getSelectionModel().clearSelection();
            this.tableId.getSelectionModel().clearSelection();
            this.occassion.getSelectionModel().clearSelection();
        }
    }
    
    public ObservableReservation getSelectedReservation() {
        if (model != null && table != null) {
            List<ObservableReservation> selectedReservations = table.getSelectionModel().getSelectedItems();
            if (selectedReservations.size() == 1) {
                final ObservableReservation selectedReservation = selectedReservations.get(0);
                return selectedReservation;
            }
        }
        return null;
    }
    
    public void onClickNew(ActionEvent event){
        table.getSelectionModel().clearSelection();
    }
    
    public void onClickCancel(ActionEvent event){
        ObservableReservation selectedReservation = getSelectedReservation();
        
        if(model != null && selectedReservation != null){
            
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Cancel Reservation");
            alert.setHeaderText("You are about to cancel a reservation. Do you want to proceed");
            alert.setContentText("Press Cancel to proceed.");
            
            ButtonType buttonTypeCancel = new ButtonType("Cancel");
            ButtonType buttonTypeClose = new ButtonType("Close", ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(buttonTypeCancel, buttonTypeClose);

            Optional<ButtonType> result = alert.showAndWait();
            
            if (result.get() == buttonTypeCancel){
                model.deleteReservation(selectedReservation.getId());
                table.getSelectionModel().clearSelection();
                table.getItems().clear();
                table.getItems().addAll(model.getReservations().values());
                
            }else{
                alert.close();
            }
            
            table.refresh();
        }
    }
    
    private void updateButtonState(){
        if (reset != null && reserve != null && table != null) {
            final boolean nothingSelected = table.getSelectionModel().getSelectedItems().isEmpty();
            
            if(!nothingSelected){
                buttonPane.getChildren().clear();
                buttonPane.getChildren().add(newBtn);
                buttonPane.getChildren().add(updateBtn);
                buttonPane.getChildren().add(cancel);
               
            }else{
                buttonPane.getChildren().clear();
                buttonPane.getChildren().add(reserve);
                buttonPane.getChildren().add(reset);
            }
            
            buttonPane.layout();
        }
//        if (reset != null) {
//            reset.setText()
//        }
    }
    
    private void configureTable(){
//       colName.setCellValueFactory(new PropertyValueFactory<ReservationStub, String>(""));

        colFirstName.setCellValueFactory(new Callback<CellDataFeatures<ObservableReservation, String>, 
                                                             ObservableValue<String>>() {  
            @Override  
            public ObservableValue<String> call(CellDataFeatures<ObservableReservation, String> data){  
                return new SimpleObjectProperty<>(data.getValue().getCustomer().getFirstName());      
            }  
        });
        
        colLastName.setCellValueFactory(new Callback<CellDataFeatures<ObservableReservation, String>, 
                                                             ObservableValue<String>>() {  
            @Override  
            public ObservableValue<String> call(CellDataFeatures<ObservableReservation, String> data){  
                return new SimpleObjectProperty<>(data.getValue().getCustomer().getLastName());      
            }  
        }); 
        
        colTitle.setCellValueFactory(new Callback<CellDataFeatures<ObservableReservation, String>, 
                                                             ObservableValue<String>>() {  
            @Override  
            public ObservableValue<String> call(CellDataFeatures<ObservableReservation, String> data){  
                return new SimpleObjectProperty<>(data.getValue().getCustomer().getTitle());      
            }  
        });
        
        colEmail.setCellValueFactory(new Callback<CellDataFeatures<ObservableReservation, String>, 
                                                             ObservableValue<String>>() {  
            @Override  
            public ObservableValue<String> call(CellDataFeatures<ObservableReservation, String> data){  
                return new SimpleObjectProperty<>(data.getValue().getCustomer().getEmail());      
            }  
        });
        
        colPhone.setCellValueFactory(new Callback<CellDataFeatures<ObservableReservation, String>, 
                                                             ObservableValue<String>>() {  
            @Override  
            public ObservableValue<String> call(CellDataFeatures<ObservableReservation, String> data){  
                return new SimpleObjectProperty<>(data.getValue().getCustomer().getMobileNo());      
            }  
        });
        
        colRoomNo.setCellValueFactory(new Callback<CellDataFeatures<ObservableReservation, String>, 
                                                             ObservableValue<String>>() {  
            @Override  
            public ObservableValue<String> call(CellDataFeatures<ObservableReservation, String> data){  
                return new SimpleObjectProperty<>(data.getValue().getCustomer().getRoomNo());      
            }  
        });
        
        colTimeIn.setCellValueFactory(
                new PropertyValueFactory<ObservableReservation, String>("arrivalTimestamp"));
        
        colTimeOut.setCellValueFactory(
               new PropertyValueFactory<ObservableReservation, String>("departureTimestamp"));
        
        colPtySize.setCellValueFactory(
               new PropertyValueFactory<ObservableReservation, String>("ptySize"));
        
        colTableLoc.setCellValueFactory(
               new PropertyValueFactory<ObservableReservation, String>("tableLoc"));
        
        colTableId.setCellValueFactory(
               new PropertyValueFactory<ObservableReservation, String>("tableId"));
        
        colOccassion.setCellValueFactory(
               new PropertyValueFactory<ObservableReservation, String>("occassion"));
        
        final ObservableList<ObservableReservation> tableSelection = table.getSelectionModel().getSelectedItems();
        tableSelection.addListener(tableSelectionChanged);
        
        // on lost focus,
//        table.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
//            if (! isNowFocused) {
//                table.getSelectionModel().clearSelection();
//                reset.setText("Reset");
//                reserve.setText("Reserve");
//            }
//        });

        colTsAv.setCellValueFactory(
                new PropertyValueFactory<TableSchedule, String>("ave"));
        
        colTsCap.setCellValueFactory(
                new PropertyValueFactory<TableSchedule, String>("cap"));
        
        colTsRnC.setCellValueFactory(
                new PropertyValueFactory<TableSchedule, String>("rnc"));
        
        colTsTime.setCellValueFactory(
                new PropertyValueFactory<TableSchedule, String>("time"));
        
        colTsMpty.setCellValueFactory(
                new PropertyValueFactory<TableSchedule, String>("mpty"));
        
        colTsRes.setCellValueFactory(
                new PropertyValueFactory<TableSchedule, String>("res"));
    }
    
    public static boolean isNotBlank(String str){
        if(str != null && str.length() > 0 && !str.equalsIgnoreCase("null")){
            return true;
        }
        
        return false;
    }
    
    public void addReservationFired(ActionEvent event){
        if(model != null){
            // customer lookup
            String firstName = (this.firstName != null && isNotBlank(this.firstName.getText())) 
                    ? this.firstName.getText() : "";
            
            String lastName = (this.lastName != null && isNotBlank(this.lastName.getText())) 
                    ? this.lastName.getText() : "";
            
            String areaCode = ((this.areaCode != null && isNotBlank(this.areaCode.getText())) 
                    ? this.areaCode.getText() + "-" : "");
            
            String mobileNo = (this.phone != null && isNotBlank(this.phone.getText())) 
                    ? areaCode + this.phone.getText() : "";
            
            String email = (this.email != null && isNotBlank(this.email.getText())) 
                    ? this.email.getText() : "";
            
            String roomNo = (this.roomNo != null && isNotBlank(this.roomNo.getText())) 
                    ? this.roomNo.getText() : "";
            
            String arrivalTimestamp = String.valueOf(this.arrivalHour.getValue()) + ":" 
                    + String.valueOf(this.arrivalMinute.getValue()) + " "
                    + (this.dayIn != null ? String.valueOf(this.dayIn.getValue()) 
                    : Instant.now().toString());
            
            String departureTimestamp = String.valueOf(this.departHour.getValue()) + ":" 
                    + String.valueOf(this.departMinute.getValue()) + " "
                    + (this.dayOut != null ? String.valueOf(this.dayOut.getValue()) 
                    : Instant.now().toString());
            
            Map<String, String> partyMap = new HashMap<String, String>();
            partyMap.put("Adult w/ ALC", StringUtil.nonNull(String.valueOf(this.adultWithAlc.getValue())));
            partyMap.put("Adult w/o ALC", StringUtil.nonNull(String.valueOf(this.adult.getValue())));
            partyMap.put("Children", StringUtil.nonNull(String.valueOf(this.children.getValue())));
            partyMap.put("Babies", StringUtil.nonNull(String.valueOf(this.babies.getValue())));
            partyMap.put("Special", StringUtil.nonNull(String.valueOf(this.special.getValue())));
            
            String ptySize = "";
            
            for(String each : partyMap.keySet()){
                ptySize += each + "=" + partyMap.get(each) + ";";
            }
                    
            String tableLoc = (this.tableLocation != null ) 
                    ? String.valueOf(this.tableLocation.getSelectionModel().getSelectedItem()) : "";
                    
            String title = (this.salutation != null && isNotBlank(String.valueOf(this.salutation.getValue()))) 
                    ? String.valueOf(this.salutation.getValue()) : "";
            
            String tableId = (this.tableId != null && isNotBlank(String.valueOf(this.tableId.getSelectionModel().getSelectedItem()))) 
                    ? String.valueOf(this.tableId.getSelectionModel().getSelectedItem()) : "";
                    
            String occassion = (this.occassion != null && isNotBlank(String.valueOf(this.occassion.getSelectionModel().getSelectedItem()))) 
                    ? String.valueOf(this.occassion.getSelectionModel().getSelectedItem()) : "";

            ObservableReservation selectedReservation = getSelectedReservation();
            
            if(selectedReservation != null){
                model.saveReservation(selectedReservation.getId(), firstName, lastName, 
                        email, mobileNo, tableId, title, 
                        roomNo, ptySize, tableLoc, title, 
                        tableId, occassion);
                
                table.getItems().clear();
                table.getItems().addAll(model.getReservations().values());
                
            }else{
                Collection<ObservableReservation> reservations = model.getReservations().values();
                
                ObservableReservation reservation = model.addReservation(String.valueOf((reservations.size()+1)), 
                firstName, lastName, email, mobileNo, arrivalTimestamp, 
                departureTimestamp, roomNo, ptySize, tableLoc, title,
                tableId, occassion);

                table.getItems().add(reservation);
                
                System.out.println(table.getItems().get(0).getId());
            }

            this.updateDetails();
        }
    }
    
    private final ObservableList<TableSchedule> tableSched =
        FXCollections.observableArrayList(
            new TableSchedule("8:30", "72", "8", "80C", "8", "2/10"),
            new TableSchedule("9:00", "60", "0", "60C", "8", "1/10"),
            new TableSchedule("9:30", "24", "26", "50C", "8", "3/10"),
            new TableSchedule("10:00", "0", "40", "40", "8", "0/8"),
            new TableSchedule("10:30", "10", "20", "30", "8", "4/8")
        ); 
}
