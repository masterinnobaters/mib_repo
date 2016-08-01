/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterinnobaters.model;

import javafx.collections.ObservableList;

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
    
    ObservableList<String> getReservations();

    ObservableReservation getReservationFor(String partyId);
    
    ObservableReservation getReservation(String reservationId);
}
