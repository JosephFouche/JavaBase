/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportevolador;

/**
 *
 * @author Eduardo
 */
public class Avion extends Transporte implements Volador {
    
    private int cantPasajeros;
    private boolean comercial;

    public Avion(String marca, String modelo, int capacidadPasajeros, double velocidadMaxima) {
        super(marca, modelo, velocidadMaxima);
    }

    public Avion(int cantPasajeros, boolean comercial, String marca, String modelo, double velocidadMaxima) {
        super(marca, modelo, velocidadMaxima);
        this.cantPasajeros = cantPasajeros;
        this.comercial = comercial;
    }

    public int getCantPasajeros() {
        return cantPasajeros;
    }

    public void setCantPasajeros(int cantPasajeros) {
        this.cantPasajeros = cantPasajeros;
    }

    public boolean isComercial() {
        return comercial;
    }

    public void setComercial(boolean comercial) {
        this.comercial = comercial;
    }
    
    @Override
    public String despegar() {
        return "Esta despegando"; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

    @Override
    public String aterrizar() {
        return "Esta aterrizando"; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toString() {
        return super.toString()+"Avion{" + "cantPasajeros=" + cantPasajeros + ", comercial=" + comercial + '}';
    }

    @Override
    public String volar(float km) {
        return "Volara"+km+" km"; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
