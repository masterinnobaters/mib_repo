package masterinnobaters.model;

import java.util.List;

public interface Reservation {

//    public static enum IssueStatus {
//        NEW, OPENED, FIXED, CLOSED
//    }

    String getId();
    Customer getCustomer();
    List<Table> getTables();
    String getRoomNo();
    String getArrivalTimestamp();
    String getDepartureTimestamp();
    String getPtySize();
    String getTableLoc();
    String getTableId();
    String getOccassion();
    void setCustomer(Customer customer);
    void setTables(List<Table> tables);
    void setRoomNo(String roomNo);
    void setArrivalTimestamp(String arrivalTimestamp);
    void setDepartureTimestamp(String departureTimestamp);
    void setPtySize(String ptySize);
    void setTableLoc(String tableLoc);
    void setTableId(String tableId);
    void setOccassion(String occassion);
    
    
//    public IssueStatus getStatus();
//    public String getSynopsis();
//    public String getDescription();
}
