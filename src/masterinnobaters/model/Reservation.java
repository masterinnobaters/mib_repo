package masterinnobaters.model;

import java.util.List;

public interface Reservation {

//    public static enum IssueStatus {
//        NEW, OPENED, FIXED, CLOSED
//    }

    String getId();
    Customer getCustomer();
    List<Table> getTables();
    String getTimeIn();
    String getTimeOut();
    
//    public IssueStatus getStatus();
//    public String getSynopsis();
//    public String getDescription();
}
