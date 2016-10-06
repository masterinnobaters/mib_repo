/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterinnobaters.model;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Johne
 */
public class TableSchedule {
    
    private final SimpleStringProperty time;
    private final SimpleStringProperty ave;
    private final SimpleStringProperty rnc;
    private final SimpleStringProperty cap;
    private final SimpleStringProperty mpty;
    private final SimpleStringProperty res;
    
    public TableSchedule(String time, String ave, String rnc, String cap,
            String mpty, String res){
        this.time = new SimpleStringProperty(time);
        this.ave = new SimpleStringProperty(ave);
        this.rnc = new SimpleStringProperty(rnc);
        this.cap = new SimpleStringProperty(cap);
        this.mpty = new SimpleStringProperty(mpty);
        this.res = new SimpleStringProperty(res);
    }

    public String getMpty(){
        return this.mpty.get();
    }
    
    public String getRes(){
        return this.res.get();
    }
    
    public String getTime(){
        return this.time.get();
    }
    
    public String getAve(){
        return this.ave.get();
    }
    
    public String getRnc(){
        return this.rnc.get();
    }
    
    public String getCap(){
        return this.cap.get();
    }
    
    public void setCap(String cap){
        this.cap.set(cap);
    }
    
    public void setTime(String time){
        this.time.set(time);
    }
    
    public void setAve(String ave){
        this.ave.set(ave);
    }
 
    public void setRnc(String rnc){
        this.rnc.set(rnc);
    }
    
    public void setMpty(String mpty){
        this.mpty.set(mpty);
    }
    
    public void setRes(String res){
        this.res.set(res);
    }
}
