package masterinnobaters.model;

import java.util.List;
import javafx.beans.value.ObservableValue;

public interface ObservableReservation extends Reservation {

    public ObservableValue<String> idProperty();
    public ObservableValue<Customer> customerProperty();
    public ObservableValue<List<Table>> tablesProperty();
    public ObservableValue<String> arrivalTimestampProperty();
    public ObservableValue<String> departureTimestampProperty();
    public ObservableValue<String> ptySize();
    public ObservableValue<String> tableLoc();
    public ObservableValue<String> tableId();
    public ObservableValue<String> occassion();

//    public ObservableValue<String> idProperty();
//    public ObservableValue<String> projectNameProperty();
//    public ObservableValue<IssueStatus> statusProperty();
//    public ObservableValue<String> synopsisProperty();
//    public ObservableValue<String> descriptionProperty();
}
