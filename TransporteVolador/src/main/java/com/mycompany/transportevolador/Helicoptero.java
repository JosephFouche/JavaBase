/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportevolador;

/**
 *
 * @author Eduardo
 */
public class Helicoptero extends Transporte implements Volador{
    
    //Agregar la propiedad privada: String tipo que puede ser de rescate, militar o policial. Agregar los métodos
//set y get 
    private String tipo;

    
    public Helicoptero(String marca, String modelo, double velocidadMaxima,String tipo) {
        super(marca, modelo, velocidadMaxima);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
         // Verificar si el tipo es válido
        if (tipo.equalsIgnoreCase("rescate") || tipo.equalsIgnoreCase("policial") || tipo.equalsIgnoreCase("militar")) {
            this.tipo = tipo;
        } else {
            System.out.println("Tipo de helicóptero inválido. Debe ser 'rescate', 'policial' o 'militar'.");
        }
    }
    
    @Override
    public String despegar() {
        
        return "Esta depegando";
            }

    @Override
    public String volar(float km) {
        return "Volara"+km+" km"; 
    }

    @Override
    public String aterrizar() {
        return "Esta aterrizando";
    }

    @Override
    public String toString() {
        return super.toString()+"Helicoptero{" + "tipo=" + tipo + '}';
    }
    
}
