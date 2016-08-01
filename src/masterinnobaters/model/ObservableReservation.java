package masterinnobaters.model;

import java.util.List;
import javafx.beans.value.ObservableValue;

public interface ObservableReservation extends Reservation {

    public ObservableValue<String> idProperty();
    public ObservableValue<Customer> customerProperty();
    public ObservableValue<List<Table>> tablesProperty();
    public ObservableValue<String> timeInProperty();
    public ObservableValue<String> timeOutProperty();
    
//    public ObservableValue<String> idProperty();
//    public ObservableValue<String> projectNameProperty();
//    public ObservableValue<IssueStatus> statusProperty();
//    public ObservableValue<String> synopsisProperty();
//    public ObservableValue<String> descriptionProperty();
}
