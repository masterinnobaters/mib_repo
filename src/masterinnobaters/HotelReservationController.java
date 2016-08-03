//package masterinnobaters;
//
//import masterinnobaters.model.ReservationServiceStub;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.Collections;
//import static java.util.Collections.list;
//import java.util.List;
//import java.util.ResourceBundle;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.collections.FXCollections;
//import javafx.collections.ListChangeListener;
//import javafx.collections.ListChangeListener.Change;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.*;
//import masterinnobaters.model.ObservableReservation;
//import masterinnobaters.model.Reservation;
//import masterinnobaters.model.ReservationService;
//
//public class HotelReservationController implements Initializable {
//
//    @FXML
//    Button reserve;
//    @FXML
//    Button reset;
//    
//    @FXML
//    TableView<ObservableReservation> table;
//    @FXML
//    TableColumn<ObservableReservation, String> colName;
//    @FXML
//    TableColumn<ObservableReservation, String> colPhone;
//    @FXML
//    TableColumn<ObservableReservation, String> colEmail;
//    @FXML
//    TableColumn<ObservableReservation, String> colRoomNo;
//    @FXML
//    TableColumn<ObservableReservation, String> colTime;
//    @FXML
//    TableColumn<ObservableReservation, String> colPtySize;
//    @FXML
//    TableColumn<ObservableReservation, String> colLeaveBy;
//    @FXML
//    TableColumn<ObservableReservation, String> colSmokingInd;
//    @FXML
//    TableColumn<ObservableReservation, String> colTableLoc;
//    
////    @FXML
////    TableColumn<ObservableIssue, IssueStatus> colStatus;
////    @FXML
////    TableColumn<ObservableIssue, String> colSynopsis;
////    @FXML
////    ListView<String> list;
//    
//    @FXML
//    TitledPane privatePane;
//    
//    @FXML
//    TextField firstName;
//    @FXML
//    TextField lastName;
//    @FXML
//    TextField phone;
//    @FXML
//    TextField email;
//    @FXML
//    TextField roomNo;
//    @FXML
//    TextField time;
//    @FXML
//    TextField ptySize;
//    @FXML
//    TextField leaveBy;
//    @FXML
//    TextField smokingInd;
//    @FXML
//    TextField tableLocation;
//    @FXML
//    TextField tableId;
//    @FXML
//    TextField tableRequest;
//
//    private String displayedBugId; // the id of the bug displayed in the details section.
//    private String displayedBugProject; // the name of the project of the bug displayed in the detailed section.
//    @FXML
//    Label displayedIssueLabel; // the displayedIssueLabel will contain a concatenation of the 
//                               // the project name and the bug id.
////    @FXML
////    AnchorPane details;
////    @FXML
////    TextArea descriptionValue;
//    
//    ObservableList<String> projectsView = FXCollections.observableArrayList();
//    
//    ReservationService model = null;
//    
//    private TextField statusValue = new TextField();
//    
//    final ObservableList<ObservableReservation> tableContent = FXCollections.observableArrayList();
//    
//    private String printError(String field){
//        return "fx:id=\"" + field + "\" was not injected: check your FXML file 'IssueTrackingLite.fxml'.";
//    }
//    
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rsrcs) {
//        assert colName != null : printError("colName");
//        assert colPhone != null: printError("colPhone");
//        assert colEmail != null: printError("colEmail");
//        assert colLeaveBy != null: printError("colLeaveBy");
//        assert colPtySize != null: printError("colPtySize");
//        assert colRoomNo != null: printError("colRoomNo");
//        assert colSmokingInd != null: printError("colSmokingInd");
//        assert colTableLoc != null: printError("colTableLoc");
//        assert colTime != null: printError("colTime");
//        
////        assert colName != null : "fx:id=\"colName\" was not injected: check your FXML file 'IssueTrackingLite.fxml'.";
////        assert colStatus != null : "fx:id=\"colStatus\" was not injected: check your FXML file 'IssueTrackingLite.fxml'.";
////        assert colSynopsis != null : "fx:id=\"colSynopsis\" was not injected: check your FXML file 'IssueTrackingLite.fxml'.";
////        assert deleteIssue != null : "fx:id=\"deleteIssue\" was not injected: check your FXML file 'IssueTrackingLite.fxml'.";
////        assert descriptionValue != null : "fx:id=\"descriptionValue\" was not injected: check your FXML file 'IssueTrackingLite.fxml'.";
////        assert details != null : "fx:id=\"details\" was not injected: check your FXML file 'IssueTrackingLite.fxml'.";
////        assert displayedIssueLabel != null : "fx:id=\"displayedIssueLabel\" was not injected: check your FXML file 'IssueTrackingLite.fxml'.";
////        assert newIssue != null : "fx:id=\"newIssue\" was not injected: check your FXML file 'IssueTrackingLite.fxml'.";
////        assert saveIssue != null : "fx:id=\"saveIssue\" was not injected: check your FXML file 'IssueTrackingLite.fxml'.";
////        assert synopsis != null : "fx:id=\"synopsis\" was not injected: check your FXML file 'IssueTrackingLite.fxml'.";
////        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'IssueTrackingLite.fxml'.";
////        assert list != null : "fx:id=\"list\" was not injected: check your FXML file 'IssueTrackingLite.fxml'.";
//        
//        System.out.println(this.getClass().getSimpleName() + ".initialize");
//        configureButtons();
//        configureDetails();
//        configureTable();
//        connectToService();
//        
////        if (list != null) {
////            list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
////            list.getSelectionModel().selectedItemProperty().addListener(projectItemSelected);
////            displayedProjectNames.addListener(projectNamesListener);
////        }
//    }
//
//    /**
//     * Called when the NewIssue button is fired.
//     *
//     * @param event the action event.
//     */
//    public void newIssueFired(ActionEvent event) {
//        final String selectedProject = getSelectedProject();
//        if (model != null && selectedProject != null) {
//            ObservableReservation issue = model.createIssueFor(selectedProject);
//            if (table != null) {
//                // Select the newly created issue.
//                table.getSelectionModel().clearSelection();
//                table.getSelectionModel().select(issue);
//            }
//        }
//    }
//    
//    /**
//     * Called when the Private collapse is fired
//     *
//     * @param event the action event.
//     */
//    public void collapsePrivate(ActionEvent event) {
//        this.privatePane.setMinHeight(200);
//        this.privatePane.expandedProperty().addListener((observable, wasExpanded, isExpanded) -> 
//        this.privatePane.setMinHeight(isExpanded ? 200 : privatePane.USE_PREF_SIZE));
//        this.privatePane.setAnimated(false);
//    }
//    
//    /**
//     * Called when the DeleteIssue button is fired.
//     *
//     * @param event the action event.
//     */
//    public void deleteIssueFired(ActionEvent event) {
//        final String selectedProject = getSelectedProject();
//        if (model != null && selectedProject != null && table != null) {
//            // We create a copy of the current selection: we can't delete
//            //    issue while looping over the live selection, since
//            //    deleting selected issues will modify the selection.
//            final List<?> selectedIssue = new ArrayList<Object>(table.getSelectionModel().getSelectedItems());
//            for (Object o : selectedIssue) {
//                if (o instanceof ObservableReservation) {
//                    model.deleteIssue(((ObservableReservation) o).getId());
//                }
//            }
//            table.getSelectionModel().clearSelection();
//        }
//    }
//
//    /**
//     * Called when the SaveIssue button is fired.
//     *
//     * @param event the action event.
//     */
//    public void saveIssueFired(ActionEvent event) {
//        final ObservableReservation ref = getSelectedIssue();
//        final Reservation edited = new DetailsData();
//        SaveState saveState = computeSaveState(edited, ref);
//        if (saveState == SaveState.UNSAVED) {
//            model.saveIssue(ref.getId(), edited.getStatus(),
//                    edited.getSynopsis(), edited.getDescription());
//        }
//        // We refresh the content of the table because synopsis and/or description
//        // are likely to have been modified by the user.
//        int selectedRowIndex = table.getSelectionModel().getSelectedIndex();
//        table.getItems().clear();
//        displayedIssues = model.getIssueIds(getSelectedProject());
//        for (String id : displayedIssues) {
//            final ObservableReservation issue = model.getIssue(id);
//            table.getItems().add(issue);
//        }
//        table.getSelectionModel().select(selectedRowIndex);
//
//        updateSaveIssueButtonState();
//    }
//    
//    private void configureButtons() {
////        if (newIssue != null) {
////            newIssue.setDisable(true);
////        }
////        if (saveIssue != null) {
////            saveIssue.setDisable(true);
////        }
////        if (deleteIssue != null) {
////            deleteIssue.setDisable(true);
////        }
//    }
//    
//    // An observable list of project names obtained from the model.
//    // This is a live list, and we will react to its changes by removing
//    // and adding project names to/from our list widget.
//    private ObservableList<String> displayedProjectNames;
//    
//    // The list of Issue IDs relevant to the selected project. Can be null
//    // if no project is selected. This list is obtained from the model.
//    // This is a live list, and we will react to its changes by removing
//    // and adding Issue objects to/from our table widget.
//    private ObservableReservation displayedReservation;
//    
//    // This listener will listen to changes in the displayedProjectNames list,
//    // and update our list widget in consequence.
//    private final ListChangeListener<String> projectNamesListener = new ListChangeListener<String>() {
//
//        @Override
//        public void onChanged(Change<? extends String> c) {
//            if (projectsView == null) {
//                return;
//            }
//            while (c.next()) {
//                if (c.wasAdded() || c.wasReplaced()) {
//                    for (String p : c.getAddedSubList()) {
//                        projectsView.add(p);
//                    }
//                }
//                if (c.wasRemoved() || c.wasReplaced()) {
//                    for (String p : c.getRemoved()) {
//                        projectsView.remove(p);
//                    }
//                }
//            }
//            FXCollections.sort(projectsView);
//        }
//    };
//    
//    // This listener will listen to changes in the displayedIssues list,
//    // and update our table widget in consequence.
//    private final ListChangeListener<String> projectIssuesListener = new ListChangeListener<String>() {
//
//        @Override
//        public void onChanged(Change<? extends String> c) {
//            if (table == null) {
//                return;
//            }
//            while (c.next()) {
//                if (c.wasAdded() || c.wasReplaced()) {
//                    for (String p : c.getAddedSubList()) {
//                        table.getItems().add(model.getIssue(p));
//                    }
//                }
//                if (c.wasRemoved() || c.wasReplaced()) {
//                    for (String p : c.getRemoved()) {
//                        ObservableReservation removed = null;
//                        // Issue already removed:
//                        // we can't use model.getIssue(issueId) to get it.
//                        // we need to loop over the table content instead.
//                        // Then we need to remove it - but outside of the for loop
//                        // to avoid ConcurrentModificationExceptions.
//                        for (ObservableReservation t : table.getItems()) {
//                            if (t.getId().equals(p)) {
//                                removed = t;
//                                break;
//                            }
//                        }
//                        if (removed != null) {
//                            table.getItems().remove(removed);
//                        }
//                    }
//                }
//            }
//        }
//    };
//
//    // Connect to the model, get the project's names list, and listen to
//    // its changes. Initializes the list widget with retrieved project names.
//    private void connectToService() {
//        if (model == null) {
//            model = new ReservationServiceStub();
//            displayedProjectNames = model.getProjectNames();
//        }
//        projectsView.clear();
//        List<String> sortedProjects = new ArrayList<String>(displayedProjectNames);
//        Collections.sort(sortedProjects);
//        projectsView.addAll(sortedProjects);
//        list.setItems(projectsView);
//    }
//    
//    // This listener listen to changes in the table widget selection and
//    // update the DeleteIssue button state accordingly.
//    private final ListChangeListener<ObservableReservation> tableSelectionChanged =
//            new ListChangeListener<ObservableReservation>() {
//
//                @Override
//                public void onChanged(Change<? extends ObservableReservation> c) {
//                    updateDeleteIssueButtonState();
//                    updateBugDetails();
//                    updateSaveIssueButtonState();
//                }
//            };
//
//    private static String nonNull(String s) {
//        return s == null ? "" : s;
//    }
//
//    private void updateBugDetails() {
//        final ObservableReservation selectedIssue = getSelectedIssue();
//        if (details != null && selectedIssue != null) {
//            if (displayedIssueLabel != null) {
//                displayedBugId = selectedIssue.getId();
//                displayedBugProject = selectedIssue.getProjectName();
//                displayedIssueLabel.setText( displayedBugId + " / " + displayedBugProject );
//            }
////            if (synopsis != null) {
////                synopsis.setText(nonNull(selectedIssue.getSynopsis()));
////            }
//            if (statusValue != null) {
//                statusValue.setText(selectedIssue.getStatus().toString());
//            }
//            if (descriptionValue != null) {
//                descriptionValue.selectAll();
//                descriptionValue.cut();
//                descriptionValue.setText(selectedIssue.getDescription());
//            }
//        } else {
//            displayedIssueLabel.setText("");
//            displayedBugId = null;
//            displayedBugProject = null;
//        }
//        if (details != null) {
//            details.setVisible(selectedIssue != null);
//        }
//    }
//
//    private boolean isVoid(Object o) {
//        if (o instanceof String) {
//            return isEmpty((String) o);
//        } else {
//            return o == null;
//        }
//    }
//
//    private boolean isEmpty(String s) {
//        return s == null || s.trim().isEmpty();
//    }
//
//    private boolean equal(Object o1, Object o2) {
//        if (isVoid(o1)) {
//            return isVoid(o2);
//        }
//        return o1.equals(o2);
//    }
//
//    private static enum SaveState {
//
//        INVALID, UNSAVED, UNCHANGED
//    }
//
//    private final class DetailsData implements Reservation {
//
//        @Override
//        public String getId() {
//            if (displayedBugId == null || isEmpty(displayedIssueLabel.getText())) {
//                return null;
//            }
//            return displayedBugId;
//        }
//
//        @Override
//        public IssueStatus getStatus() {
//            if (statusValue == null || isEmpty(statusValue.getText())) {
//                return null;
//            }
//            return IssueStatus.valueOf(statusValue.getText().trim());
//        }
//        
//        @Override
//        public String getProjectName() {
//            if (displayedBugProject == null || isEmpty(displayedIssueLabel.getText())) {
//                return null;
//            }
//            return displayedBugProject;
//        }
//
//        @Override
//        public String getSynopsis() {
////            if (synopsis == null || isEmpty(synopsis.getText())) {
////                return "";
////            }
////            return synopsis.getText();
//            return "";
//        }
//
//        @Override
//        public String getDescription() {
//            if (descriptionValue == null || isEmpty(descriptionValue.getText())) {
//                return "";
//            }
//            return descriptionValue.getText();
//        }
//    }
//
//    private SaveState computeSaveState(Reservation edited, Reservation issue) {
//        try {
//            // These fields are not editable - so if they differ they are invalid
//            // and we cannot save.
//            if (!equal(edited.getId(), issue.getId())) {
//                return SaveState.INVALID;
//            }
//            if (!equal(edited.getProjectName(), issue.getProjectName())) {
//                return SaveState.INVALID;
//            }
//
//            // If these fields differ, the issue needs saving.
//            if (!equal(edited.getStatus(), issue.getStatus())) {
//                return SaveState.UNSAVED;
//            }
//            if (!equal(edited.getSynopsis(), issue.getSynopsis())) {
//                return SaveState.UNSAVED;
//            }
//            if (!equal(edited.getDescription(), issue.getDescription())) {
//                return SaveState.UNSAVED;
//            }
//        } catch (Exception x) {
//            // If there's an exception, some fields are invalid.
//            return SaveState.INVALID;
//        }
//        // No field is invalid, no field needs saving.
//        return SaveState.UNCHANGED;
//    }
//
//    private void updateDeleteIssueButtonState() {
//        boolean disable = true;
////        if (deleteIssue != null && table != null) {
////            final boolean nothingSelected = table.getSelectionModel().getSelectedItems().isEmpty();
////            disable = nothingSelected;
////        }
////        if (deleteIssue != null) {
////            deleteIssue.setDisable(disable);
////        }
//    }
//
//    private void updateSaveIssueButtonState() {
//        boolean disable = true;
////        if (saveIssue != null && table != null) {
////            final boolean nothingSelected = table.getSelectionModel().getSelectedItems().isEmpty();
////            disable = nothingSelected;
////        }
////        if (disable == false) {
////            disable = computeSaveState(new DetailsData(), getSelectedIssue()) != SaveState.UNSAVED;
////        }
////        if (saveIssue != null) {
////            saveIssue.setDisable(disable);
////        }
//    }
//
//    // Configure the table widget: set up its column, and register the
//    // selection changed listener.
//    private void configureTable() {
////        colName.setCellValueFactory(new PropertyValueFactory<ObservableIssue, String>("id"));
////        colSynopsis.setCellValueFactory(new PropertyValueFactory<ObservableIssue, String>("synopsis"));
////        colStatus.setCellValueFactory(new PropertyValueFactory<ObservableIssue, IssueStatus>("status"));
//
//        // In order to limit the amount of setup in Getting Started we set the width
//        // of the 3 columns programmatically but one can do it from SceneBuilder.
////        colName.setPrefWidth(75);
////        colStatus.setPrefWidth(75);
////        colSynopsis.setPrefWidth(443);
//
////        colName.setMinWidth(75);
////        colStatus.setMinWidth(75);
////        colSynopsis.setMinWidth(443);
//
////        colName.setMaxWidth(750);
////        colStatus.setMaxWidth(750);
////        colSynopsis.setMaxWidth(4430);
//
//        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//
//        table.setItems(tableContent);
//        assert table.getItems() == tableContent;
//
//        final ObservableList<ObservableReservation> tableSelection = table.getSelectionModel().getSelectedItems();
//
//        tableSelection.addListener(tableSelectionChanged);
//    }
//
//    /**
//     * Return the name of the project currently selected, or null if no project
//     * is currently selected.
//     *
//     */
//    public String getSelectedProject() {
//        if (model != null && list != null) {
//            final ObservableList<String> selectedProjectItem = list.getSelectionModel().getSelectedItems();
//            final String selectedProject = selectedProjectItem.get(0);
//            return selectedProject;
//        }
//        return null;
//    }
//
//    public ObservableReservation getSelectedIssue() {
//        if (model != null && table != null) {
//            List<ObservableReservation> selectedIssues = table.getSelectionModel().getSelectedItems();
//            if (selectedIssues.size() == 1) {
//                final ObservableReservation selectedIssue = selectedIssues.get(0);
//                return selectedIssue;
//            }
//        }
//        return null;
//    }
//    
//    /**
//     * Listen to changes in the list selection, and updates the table widget and
//     * DeleteIssue and NewIssue buttons accordingly.
//     */
//    private final ChangeListener<String> reservtionItemSelected = new ChangeListener<String>() {
//        @Override
//        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
////            projectUnselected(oldValue);
////            projectSelected(newValue);
//            reservationSelected(newValue);
//        }
//    };
//
//    // Called when a project is unselected.
//    private void projectUnselected(String oldReservation) {
//        if (oldReservation != null) {
//            displayedIssues.removeListener(projectIssuesListener);
//            displayedIssues = null;
//            table.getSelectionModel().clearSelection();
//            table.getItems().clear();
////            if (newIssue != null) {
////                newIssue.setDisable(true);
////            }
////            if (deleteIssue != null) {
////                deleteIssue.setDisable(true);
////            }
//        }
//    }
//
//    // Called when a project is selected.
//    private void reservationSelected(String reservation) {
//        if (reservation != null) {
//           
//            displayedReservation = model.getReservation(reservation);
//            
//            
//            if(displayedReservation != null){
//                
//                String fullName = displayedReservation.getCustomer().getName();
//                String fName = fullName.split(" ")[0];
//                String lName = fullName.split(" ")[1];
//                
//                firstName.setText(fName);
//                lastName.setText(lName);
//                
//            }
//            
//            
//            displayedIssues = model.getIssueIds(newProjectName);
//            for (String id : displayedIssues) {
//                final ObservableReservation issue = model.getIssue(id);
//                table.getItems().add(issue);
//            }
//            displayedIssues.addListener(projectIssuesListener);
////            if (newIssue != null) {
////                newIssue.setDisable(false);
////            }
//            updateDeleteIssueButtonState();
//            updateSaveIssueButtonState();
//        }
//    }
//
//    private void configureDetails() {
////        if (details != null) {
////            details.setVisible(false);
////        }
////
////        if (details != null) {
////            details.addEventFilter(EventType.ROOT, new EventHandler<Event>() {
////
////                @Override
////                public void handle(Event event) {
////                    if (event.getEventType() == MouseEvent.MOUSE_RELEASED
////                            || event.getEventType() == KeyEvent.KEY_RELEASED) {
////                        updateSaveIssueButtonState();
////                    }
////                }
////            });
////        }
//    }
//}
