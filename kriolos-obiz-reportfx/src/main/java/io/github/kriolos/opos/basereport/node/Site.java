/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.kriolos.opos.basereport.node;

/**
 *
 * @author poolb
 */
public class Site {
    private String name;
    //private LatLng location;
    private Antenna antenna;
    private String type;
    
    //Transmiter
    private double eirp;
    
    //Receiver
    private double sensibility;
    private double powerReceived;
}
