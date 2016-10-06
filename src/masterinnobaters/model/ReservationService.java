/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterinnobaters.model;

import java.util.List;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import masterinnobaters.model.ReservationServiceStub.ReservationStub;

/**
 *
 * @author Johne
 */
public interface ReservationService {
    
//    ObservableList<String> getIssueIds(String projectName);
//    
//    ObservableList<String> getProjectNames();
//    
//    ObservableIssue getIssue(String tickectId);
//    
//    ObservableIssue createIssueFor(String projectName);
//    
//    void deleteIssue(String issueId);
//    
//    void saveIssue(String issueId, Issue.IssueStatus status,
//            String synopsis, String description);
    
    // -- reservation
    
    void deleteReservation(String reservationId);
    
    void saveReservationFor(String partyId);
    
    ObservableMap<String, ObservableReservation> getReservations();

    ObservableReservation getReservationFor(String partyId);
    
    ObservableReservation getReservation(String reservationId);
    
//    void saveReservation(String id, ReservationStub updatedReservation);
    
    void saveReservation(String id, String firstName, String lastName,
            String email, String mobileNo, String timeIn, 
            String timeOut, String roomNo,
            String ptySize, String tableLoc, String title,
            String tableId, String occassion);
    
    ReservationStub addReservation(String id, String firstName, String lastName,
            String email, String mobileNo, String timeIn, 
            String timeOut, String roomNo,
            String ptySize, String tableLoc, String title,
            String tableId, String occassion);
}
