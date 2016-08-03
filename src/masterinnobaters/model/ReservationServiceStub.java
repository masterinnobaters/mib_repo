//package masterinnobaters.model;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//import java.util.TreeMap;
//import java.util.concurrent.atomic.AtomicInteger;
//import javafx.beans.property.SimpleObjectProperty;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.beans.value.ObservableValue;
//import javafx.collections.FXCollections;
//import javafx.collections.MapChangeListener;
//import javafx.collections.MapChangeListener.Change;
//import javafx.collections.ObservableList;
//import javafx.collections.ObservableMap;
//
//public class ReservationServiceStub implements ReservationService {
//
//    // You add a project by adding an entry with an empty observable array list
//    // of issue IDs in the projects Map.
////    final ObservableMap<String, ObservableList<String>> reservationMap;
////    {
////        final Map<String, ObservableList<String>> map = new TreeMap<String, ObservableList<String>>();
////        reservationMap = FXCollections.observableMap(map);
////        for (String s : newList("Project1", "Project2", "Project3", "Project4")) {
////            reservationMap.put(s, FXCollections.<String>observableArrayList());
////        }
////    }
////
////    // The projectNames list is kept in sync with the project's map by observing
////    // the projectsMap and modifying the projectNames list in consequence.
////    final MapChangeListener<String, ObservableList<String>> projectsMapChangeListener = new MapChangeListener<String, ObservableList<String>>() {
////        @Override
////        public void onChanged(Change<? extends String, ? extends ObservableList<String>> change) {
////            if (change.wasAdded()) projectNames.add(change.getKey());
////            if (change.wasRemoved()) projectNames.remove(change.getKey());
////        }
////    };
////    final ObservableList<String> projectNames;
////    {
////        projectNames = FXCollections.<String>observableArrayList();
////        projectNames.addAll(projectsMap.keySet());
////        projectsMap.addListener(projectsMapChangeListener);
////    }
//
//    // A Issue stub.
//    public final class ReservationStub implements ObservableReservation {
//        
//        private final SimpleStringProperty id;
//        private final SimpleObjectProperty<Customer> customer;
//        private final SimpleObjectProperty<List<Table>> tables;
//        private final SimpleStringProperty timeIn;
//        private final SimpleStringProperty timeOut;
//
//        ReservationStub(String id, 
//                        Customer customer,
//                        List<Table> tables,
//                        String timeIn,
//                        String timeOut) {
////            assert name.contains(name);
////            assert ! projectsMap.get(projectName).contains(id);
////            assert ! issuesMap.containsKey(id);
//            this.id = new SimpleStringProperty(id);
//            this.customer = new SimpleObjectProperty<>(customer);
//            this.tables = new SimpleObjectProperty<>(tables);
//            this.timeIn = new SimpleStringProperty(timeIn);
//            this.timeOut = new SimpleStringProperty(timeOut);
//        }
//
//        @Override
//        public String getId() {
//            return id.get();
//        }
//
//        @Override
//        public ObservableValue<String> idProperty() {
//            return this.id;
//        }
//
//        @Override
//        public ObservableValue<Customer> customerProperty() {
//            return this.customer;
//        }
//
//        @Override
//        public ObservableValue<List<Table>> tablesProperty() {
//            return this.tables;
//        }
//
//        @Override
//        public ObservableValue<String> timeInProperty() {
//           return this.timeIn;
//        }
//
//        @Override
//        public ObservableValue<String> timeOutProperty() {
//            return this.timeOut;
//        }
//
//        @Override
//        public Customer getCustomer() {
//            return this.customer.get();
//        }
//
//        @Override
//        public List<Table> getTables() {
//            return this.tables.get();
//        }
//
//        @Override
//        public String getTimeIn() {
//            return this.timeIn.get();
//        }
//
//        @Override
//        public String getTimeOut() {
//            return this.timeOut.get();
//        }
//
//    }
//
//    // You create new reservation by adding a ReservationStub instance to the reservationsMap.
//    // the new id will be automatically added to the corresponding list in
//    // the .
//    //
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
//
//}
