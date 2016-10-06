package masterinnobaters.model;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import masterinnobaters.util.StringUtil;

public class ReservationServiceStub implements ReservationService {

    // You add a project by adding an entry with an empty observable array list
    // of issue IDs in the projects Map.
    final ObservableMap<String, ObservableReservation> reservationMap;
    {
        final Map<String, ObservableReservation> map = new TreeMap<String, ObservableReservation>();
        reservationMap = FXCollections.observableMap(map);
//        for (String s : newList("Project1", "Project2", "Project3", "Project4")) {
//            reservationMap.put(s, FXCollections.<String>observableArrayList());
//        }
    }
    
//    final MapChangeListener<String, ReservationStub> reservationsMapChangeListener = new MapChangeListener<String, ReservationStub>() {
//        @Override
//        public void onChanged(MapChangeListener.Change<? extends String, ? extends Object> change) {
//            if (change.wasAdded()) projectNames.add(change.getKey());
//            if (change.wasRemoved()) projectNames.remove(change.getKey());
//        }
//    };
    
//
//    // The projectNames list is kept in sync with the project's map by observing
//    // the projectsMap and modifying the projectNames list in consequence.
//    final MapChangeListener<String, ObservableList<String>> projectsMapChangeListener = new MapChangeListener<String, ObservableList<String>>() {
//        @Override
//        public void onChanged(Change<? extends String, ? extends ObservableList<String>> change) {
//            if (change.wasAdded()) projectNames.add(change.getKey());
//            if (change.wasRemoved()) projectNames.remove(change.getKey());
//        }
//    };
//    final ObservableList<String> projectNames;
//    {
//        projectNames = FXCollections.<String>observableArrayList();
//        projectNames.addAll(projectsMap.keySet());
//        projectsMap.addListener(projectsMapChangeListener);
//    }

    public final class CustomerStub implements ObservableCustomer{

        private final SimpleStringProperty id;
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;
        private final SimpleStringProperty mobileNo;
        private final SimpleStringProperty roomNo;
        private final SimpleStringProperty title;

        public CustomerStub(String id, String firstName, 
                String lastName, String email, 
                String mobileNo, String roomNo, String title) {
            
            this.id = new SimpleStringProperty(id);
            this.firstName = new SimpleStringProperty(firstName);
            this.email = new SimpleStringProperty(email);
            this.lastName = new SimpleStringProperty(lastName);
            this.mobileNo = new SimpleStringProperty(mobileNo);
            this.roomNo = new SimpleStringProperty(roomNo);
            this.title = new SimpleStringProperty(title);
        }
        
        @Override
        public ObservableValue<String> idProperty() {
            return this.id;
        }

        @Override
        public ObservableValue<String> firstNameProperty() {
            return this.firstName;
        }

        @Override
        public ObservableValue<String> lastNameProperty() {
            return this.lastName;
        }

        @Override
        public ObservableValue<String> mobileNoProperty() {
            return this.mobileNo;
        }

        @Override
        public ObservableValue<String> emailProperty() {
            return this.email;
        }

        @Override
        public ObservableValue<String> roomNoProperty() {
            return this.roomNo;
        }

        @Override
        public ObservableValue<String> titleProperty() {
            return this.title;
        }        
        
        @Override
        public String getId() {
            return this.id.get();
        }

        @Override
        public String getFirstName() {
            return this.firstName.get();
        }

        @Override
        public String getLastName() {
            return this.lastName.get();
        }

        @Override
        public String getMobileNo() {
            return this.mobileNo.get();
        }

        @Override
        public String getEmail() {
            return this.email.get();
        }

        @Override
        public String getRoomNo() {
            return this.roomNo.get();
        }
        
        @Override
        public String getTitle(){
            return this.title.get();
        }
    }
    
    public final class ReservationStub implements ObservableReservation {

        private final SimpleStringProperty id;
        
        //essentially this should be encapsulated in Customer and Table object;
        private final SimpleObjectProperty<Customer> customer;
        private final SimpleObjectProperty<List<Table>> tables;
        
        private final SimpleStringProperty roomNo;
        private final SimpleStringProperty arrivalTimestamp;
        private final SimpleStringProperty departureTimestamp;
        private final SimpleStringProperty ptySize;
        private final SimpleStringProperty tableLoc;
        private final SimpleStringProperty tableId;
        private final SimpleStringProperty occassion;
        
        ReservationStub(String id, 
                        Customer customer,
                        List<Table> tables,
                        String arrivalTimestamp,
                        String departureTimestamp,
                        String roomNo,
                        String ptySize,
                        String tableLoc,
                        String tableId,
                        String occassion) {
//            assert name.contains(name);
//            assert ! projectsMap.get(projectName).contains(id);
//            assert ! issuesMap.containsKey(id);
            this.id = new SimpleStringProperty(StringUtil.nonNull(id));
            this.customer = new SimpleObjectProperty<>(customer);
            this.tables = new SimpleObjectProperty<>(tables);
            this.arrivalTimestamp = new SimpleStringProperty(StringUtil.nonNull(arrivalTimestamp));
            this.departureTimestamp = new SimpleStringProperty(StringUtil.nonNull(departureTimestamp));
            this.roomNo = new SimpleStringProperty(StringUtil.nonNull(roomNo));
            this.ptySize = new SimpleStringProperty(StringUtil.nonNull(ptySize));
            this.tableLoc = new SimpleStringProperty(StringUtil.nonNull(tableLoc));
            this.tableId = new SimpleStringProperty(StringUtil.nonNull(tableId));
            this.occassion = new SimpleStringProperty(StringUtil.nonNull(occassion));
        }

        @Override
        public String getId() {
            return id.get();
        }

        @Override
        public ObservableValue<String> idProperty() {
            return this.id;
        }

        @Override
        public ObservableValue<Customer> customerProperty() {
            return this.customer;
        }

        @Override
        public ObservableValue<List<Table>> tablesProperty() {
            return this.tables;
        }

        @Override
        public Customer getCustomer() {
            return this.customer.get();
        }

        public void setCustomer(Customer customer){
            this.customer.set(customer);
        }
        
        @Override
        public List<Table> getTables() {
            return this.tables.get();
        }

        public void setTables(List<Table> tables){
            this.tables.set(tables);
        }
        
        @Override
        public String getRoomNo() {
            return this.roomNo.get();
        }
        
        public void setRoomNo(String roomNo){
            this.roomNo.set(roomNo);
        }
        
        @Override
        public ObservableValue<String> arrivalTimestampProperty() {
            return  this.arrivalTimestamp;
        }

        @Override
        public ObservableValue<String> departureTimestampProperty() {
            return this.departureTimestamp;
        }

        @Override
        public ObservableValue<String> ptySize() {
            return this.ptySize;
        }

        @Override
        public ObservableValue<String> tableLoc() {
            return this.tableLoc;
        }
        
        @Override
        public ObservableValue<String> tableId() {
            return this.tableId;
        }
        
        @Override
        public ObservableValue<String> occassion() {
            return this.occassion;
        }

        @Override
        public String getArrivalTimestamp() {
            return this.arrivalTimestamp.get();
        }
        
        public void setArrivalTimestamp(String arrivalTimestamp){
            this.arrivalTimestamp.set(arrivalTimestamp);
        }

        @Override
        public String getDepartureTimestamp() {
            return this.departureTimestamp.get();
        }
        
        public void setDepartureTimestamp(String departureTimestamp){
            this.departureTimestamp.set(departureTimestamp);
        }

        @Override
        public String getPtySize() {
            return this.ptySize.get();
        }

        public void setPtySize(String ptySize){
            this.ptySize.set(ptySize);
        }
        
        @Override
        public String getTableLoc() {
            return this.tableLoc.get();
        }
        
        public void setTableLoc(String tableLoc){
            this.tableLoc.set(tableLoc);
        }
        
        @Override
        public String getTableId() {
            return this.tableId.get();
        }
        
        public void setTableId(String tableId){
            this.tableId.set(tableId);
        }
        
        @Override
        public String getOccassion() {
            return this.occassion.get();
        }
        
        public void setOccassion(String occassion){
            this.occassion.set(occassion);
        }
    }

    // You create new reservation by adding a ReservationStub instance to the reservationsMap.
    // the new id will be automatically added to the corresponding list in
    // the .
    //
//    final MapChangeListener<String, ReservationStub> reservationsMapChangeListener = new MapChangeListener<String, ReservationStub>() {
//        @Override
//        public void onChanged(Change<? extends String, ? extends ReservationStub> change) {
//            if (change.wasAdded()) {
//                final ReservationStub val = change.getValueAdded();
//                projectsMap.get(val.getProjectName()).add(val.getId());
//            }
//            if (change.wasRemoved()) {
//                final IssueStub val = change.getValueRemoved();
//                projectsMap.get(val.getProjectName()).remove(val.getId());
//            }
//        }
//    };
//    
//    final AtomicInteger reservationCounter = new AtomicInteger(0);
//    final ObservableMap<String, ReservationStub> reservationsMap;
//    {
//        final Map<String, ReservationStub> map = new TreeMap<String, ReservationStub>();
//        reservationsMap = FXCollections.observableMap(map);
//        reservationsMap.addListener(res);
//        ReservationStub ts;
//        ts = createIssueFor("Project1");
//        ts.setSynopsis("We rode in sorrow, with strong hounds three");
//        ts.setDescription("From \"The Wanderings Of Oisin\".\nW. B. Yeats.");
//        ts = createIssueFor("Project1");
//        ts.setSynopsis("Bran, Sgeolan, and Lomair");
//        ts.setDescription("From \"The Wanderings Of Oisin\".\nW. B. Yeats.");
//        ts = createIssueFor("Project2");
//        ts.setSynopsis("On a morning misty and mild and fair");
//        ts.setDescription("From \"The Wanderings Of Oisin\".\nW. B. Yeats.");
//        ts = createIssueFor("Project4");
//        ts.setSynopsis("The mist-drops hung on the fragrant trees");
//        ts.setDescription("From \"The Wanderings Of Oisin\".\nW. B. Yeats.");
//        ts = createIssueFor("Project3");
//        ts.setSynopsis("And in the blossoms hung the bees");
//        ts.setDescription("From \"The Wanderings Of Oisin\".\nW. B. Yeats.");
//        ts = createIssueFor("Project2");
//        ts.setSynopsis("We rode in sadness above Lough Lean");
//        ts.setDescription("From \"The Wanderings Of Oisin\".\nW. B. Yeats.");
//        ts = createIssueFor("Project1");
//        ts.setSynopsis("For our best were dead on Gavra's green");
//        ts.setDescription("From \"The Wanderings Of Oisin\".\nW. B. Yeats.");
//        ts = createIssueFor("Project4");
//        ts.setSynopsis("The Wanderings of Oisin");
//        ts.setDescription("William Butler Yeats.");
//    }
//
//    private static <T> List<T> newList(T... items) {
//        return Arrays.asList(items);
//    }
//
//
//    @Override
//    public IssueStub createIssueFor(String projectName) {
//        assert projectNames.contains(projectName);
//        final IssueStub issue = new IssueStub(projectName, "TT-"+issueCounter.incrementAndGet());
//        assert issuesMap.containsKey(issue.getId()) == false;
//        assert projectsMap.get(projectName).contains(issue.getId()) == false;
//        issuesMap.put(issue.getId(), issue);
//        return issue;
//    }
//
//    @Override
//    public void deleteIssue(String issueId) {
//        assert issuesMap.containsKey(issueId);
//        issuesMap.remove(issueId);
//    }
//
//    @Override
//    public ObservableList<String> getProjectNames() {
//        return projectNames;
//    }
//
//    @Override
//    public ObservableList<String> getIssueIds(String projectName) {
//        return projectsMap.get(projectName);
//    }
//
//    @Override
//    public IssueStub getIssue(String issueId) {
//        return issuesMap.get(issueId);
//    }
//
//    @Override
//    public void saveIssue(String issueId, IssueStatus status,
//            String synopsis, String description) {
//        IssueStub issue = getIssue(issueId);
//        issue.setDescription(description);
//        issue.setSynopsis(synopsis);
//        issue.setStatus(status);
//    }

    @Override
    public void deleteReservation(String reservationId) {
        reservationMap.remove(reservationId);
    }

    @Override
    public void saveReservationFor(String partyId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableMap<String, ObservableReservation> getReservations() {
        return reservationMap;
    }

    @Override
    public ObservableReservation getReservationFor(String partyId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableReservation getReservation(String reservationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void saveReservation(String id, String firstName, String lastName,
            String email, String mobileNo, String timeIn, 
            String timeOut, String roomNo,
            String ptySize, String tableLoc, String title,
            String tableId, String occassion) {
        
        ReservationStub reservation = (ReservationStub)reservationMap.get(id);
        
        CustomerStub customer = new CustomerStub(id, firstName, lastName, email, mobileNo, roomNo, title);
        
        if(reservation != null){
            reservation.setCustomer(customer);
            reservation.setTables(reservation.getTables());
            reservation.setArrivalTimestamp(timeIn);
            reservation.setDepartureTimestamp(timeOut);
            reservation.setOccassion(occassion);
            reservation.setPtySize(ptySize);
            reservation.setRoomNo(roomNo);
            reservation.setTableId(tableId);
            reservation.setTableLoc(tableLoc);
        }
    }
    
    @Override
    public ReservationStub addReservation(String id, String firstName, 
            String lastName, String email,  String mobileNo,
            String timeIn, String timeOut, String roomNo,
            String ptySize, String tableLoc, String title,
            String tableId, String occassion) {
        
        CustomerStub customer = new CustomerStub(id, firstName, lastName, email, mobileNo, roomNo, title);
        
        ReservationStub newReservation = new ReservationStub(id, customer,
            null, // table
            timeIn, timeOut, roomNo,
            ptySize, tableLoc, tableId, occassion);
        
        reservationMap.put(id, newReservation);
        
        return newReservation;
    }
}
