/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterinnobaters.model;

import java.util.List;

/**
 * @author Johne
 */
public interface Restaurant {
    
    int MAX_CAP = 20;
    
    Integer getCurrentCustomerCount();
    List<Table> getTables();
    
}
