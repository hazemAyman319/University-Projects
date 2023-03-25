
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.*;

/**
 *
 * @author Bassant Haider
 */
public class suppplier {
     Connection con1;
    PreparedStatement pst;
    int sid; 
    String sfname ;
    String location ;
    int stel;

    public suppplier(int sid, String sfname, String location, int stel) {
        this.sid = sid;
        this.sfname = sfname;
        this.location = location;
        this.stel = stel;
    }
    

    public int getSid() {
        return sid;
    }

    public String getSfname() {
        return sfname;
    }

    public String getLocation() {
        return location;
    }

    public int getStel() {
        return stel;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setSfname(String sfname) {
        this.sfname = sfname;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStel(int stel) {
        this.stel = stel;
    }
    public void clear(int sid,String sfname,String location ,int stel){
        sid = sidtxt.setText("");
        sfname = sfnametxt.setText("");
        location = locationtxt.setText("");
        stel = steltxt.setText("");

        sidtxt.requestFocus();
    }

}
