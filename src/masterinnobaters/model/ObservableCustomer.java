/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterinnobaters.model;

import javafx.beans.value.ObservableValue;

/**
 *
 * @author Johne
 */
public interface ObservableCustomer extends Customer{
    
    public ObservableValue<String> idProperty();
    public ObservableValue<String> firstNameProperty();
    public ObservableValue<String> lastNameProperty(); 
    public ObservableValue<String> mobileNoProperty(); 
    public ObservableValue<String> emailProperty(); 
    public ObservableValue<String> roomNoProperty(); 
    public ObservableValue<String> titleProperty();
}
